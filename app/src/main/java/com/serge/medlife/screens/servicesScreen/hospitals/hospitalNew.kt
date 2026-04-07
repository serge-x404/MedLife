package com.serge.medlife.screens.servicesScreen.hospitals

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.edit
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.CircularBounds
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.SearchNearbyRequest
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.serge.medlife.theme.primaryDark
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalMap(
    back: () -> Unit
) {

    val context = LocalContext.current

    var mapLoaded by remember {
        mutableStateOf(false)
    }
    val cameraPositionState = rememberCameraPositionState()

    var initialized by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Nearby Hospitals",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {back()}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            )
        }
    )
    {
        val pref = context.getSharedPreferences("medLife", Context.MODE_PRIVATE)

        var isGranted = pref.getBoolean("location_permission", false)
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            val scope = rememberCoroutineScope()

            var currentLocation by remember { mutableStateOf<Location?>(null) }


            val locationPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { permissionGranted ->
                if (permissionGranted) {
                    isGranted = true
                    pref.edit(commit = true) {
                        putBoolean("location_permission", true)
                    }
                    scope.launch {
                        fetchCurrentLocation(
                            context,
                            onLocationFetched = { location ->
                                currentLocation = location
                                Log.d("LOCATION", currentLocation.toString())
                            }
                        )
                    }
                }

            }

            LaunchedEffect(isGranted) {
                if(!isGranted) {
                    locationPermissionLauncher
                        .launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
                else {
                    Log.d("LOCATION", "call fetch")

                    fetchCurrentLocation(
                        context,
                        onLocationFetched = { location ->
                            currentLocation = location
                            Log.d("LOCATION", currentLocation.toString())
                        }
                    )
                }
            }
            LaunchedEffect(mapLoaded, currentLocation, isGranted) {
                if (mapLoaded && currentLocation != null && !initialized) {
                    currentLocation?.let { myLocation ->
                        cameraPositionState.animate(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(myLocation.latitude, myLocation.longitude),
                                13f
                            )
                        )
                        initialized = true
                    } ?: cameraPositionState.animate(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(23.05, 72.50),
                            13f
                        )
                    )
                }
            }

            var nearbyHospitals by remember { mutableStateOf<List<NearbyPlace>>(emptyList()) }
            var selectedHospital by remember { mutableStateOf<NearbyPlace?>(null) }

            LaunchedEffect(currentLocation) {
                currentLocation?.let { location ->
                    searchNearbyHospitals(
                        context,
                        LatLng(location.latitude, location.longitude),
                        onResult = { nearbyHospitals = it },
                        onError = { Log.e("NearbyHospital", it) }
                    )
                }
            }

            GoogleMap(
                onMapLoaded = {
                    mapLoaded = true
                },
                cameraPositionState = cameraPositionState,
                onMapClick = {
                    scope.launch {
                        cameraPositionState.animate(
                            CameraUpdateFactory.newLatLngZoom(it, 15f),
                            800
                        )
                    }

                },
                properties = MapProperties(
                    isMyLocationEnabled = if(isGranted) true else false
                ),
                uiSettings = MapUiSettings(
                    compassEnabled = true,
                    myLocationButtonEnabled = false,
                    mapToolbarEnabled = false
                )
            ) {
//            currentLocation?.let {myLocation ->
//                val location = LatLng(
//                    myLocation.latitude,
//                    myLocation.longitude
//                )
//
//                Marker(
//                    state = MarkerState(location),
//                    title = "Current Location",
//                    snippet = "You are here"
//                )
//            }

                nearbyHospitals.forEach { hospital ->
                    Marker(
                        state = MarkerState(hospital.latLng),
                        title = hospital.name,
                        snippet = hospital.address,
                        icon = BitmapDescriptorFactory.defaultMarker(
                            if (selectedHospital == hospital) BitmapDescriptorFactory.HUE_RED
                            else BitmapDescriptorFactory.HUE_GREEN
                        ),
                        onClick = {
                            selectedHospital = hospital
                            false
                        }
                    )
                }

                currentLocation?.let {
                    Circle(
                        LatLng(it.latitude, it.longitude),
                        false,
                        primaryDark.copy(
                            alpha = 0.4f
                        ),
                        2000.0,
                        strokeWidth = 2f
                    )
                }
            }

        }
    }
}

    @SuppressLint("MissingPermission")
    private suspend fun fetchCurrentLocation(
        context: Context,
        onLocationFetched: (Location) -> Unit
    ) {
        Log.d("LOCATION", "fused called")

        val fusedLocationClient = LocationServices
            .getFusedLocationProviderClient(context)

        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            1000
        ).apply {
            setMinUpdateIntervalMillis(5000)
            setWaitForAccurateLocation(false)
        }.build()

        val lastLocation = fusedLocationClient.lastLocation.await()
        if(lastLocation != null) {
            Log.d("LOCATION", "last $lastLocation")
            onLocationFetched(lastLocation)
        }
        else {
            Log.d("LOCATION", "last is null")

        }

        val locationCallback = object : LocationCallback() {

            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.lastLocation?.let { currentLocation ->
                    onLocationFetched(currentLocation)
                }
            }
        }

        try {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                null
            )
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    private fun searchNearbyHospitals(
        context: Context,
        location: LatLng,
        onResult: (List<NearbyPlace>) -> Unit,
        onError: (String) -> Unit
    ) {
        val placesClient = Places.createClient(context)

        val request = SearchNearbyRequest.builder(
            CircularBounds.newInstance(
                LatLng(location.latitude, location.longitude),
                2000.0
            ),
            listOf(
                Place.Field.ID,
                Place.Field.DISPLAY_NAME,
                Place.Field.FORMATTED_ADDRESS,
                Place.Field.LOCATION
            )
        )

            .setIncludedPrimaryTypes(listOf("hospital"))
            .setMaxResultCount(5)
            .build()

        placesClient.searchNearby(request)
            .addOnSuccessListener { response ->
                val places = response.places.map { place ->
                    NearbyPlace(
                        name = place.displayName ?: "",
                        address = place.formattedAddress ?: "",
                        latLng = place.location ?: LatLng(0.0, 0.0)
                    )
                }
                onResult(places)
            }
            .addOnFailureListener { e ->
                onError(e.message ?: "Failed to fetch hospitals")
            }
    }

