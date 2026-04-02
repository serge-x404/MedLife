package com.serge.medlife.screens.servicesScreen.hospitals

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@Composable
fun HospitalMap() {

    val context = LocalContext.current

    var mapLoaded by remember {
        mutableStateOf(false)
    }
    val cameraPositionState = rememberCameraPositionState()

    var initialized by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val scope = rememberCoroutineScope()

        var currentLocation by remember { mutableStateOf<Location?>(null) }

        val locationPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) {permissionGranted ->
            if (permissionGranted) {
                fetchCurrentLocation(
                    context,
                    onLocationFetched = {location ->
                        currentLocation = location
                    }
                )
            }

        }

        LaunchedEffect(Unit) {
            locationPermissionLauncher
                .launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        LaunchedEffect(mapLoaded, currentLocation) {
            if (mapLoaded && currentLocation != null && !initialized) {
                currentLocation?.let { myLocation ->
                    cameraPositionState.animate(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(myLocation.latitude, myLocation.longitude),
                            15f
                        )
                    )
                    initialized = true
                } ?: cameraPositionState.animate(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(23.05,72.50),
                        15f
                    )
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
            uiSettings = MapUiSettings(
                compassEnabled = true
            )
        ) {
            currentLocation?.let {myLocation ->
                val location = LatLng(
                    myLocation.latitude,
                    myLocation.longitude
                )

                Marker(
                    state = MarkerState(location),
                    title = "Current Location",
                    snippet = "You are here"
                )
            }
        }

    }
}

private fun fetchCurrentLocation(
    context: Context,
    onLocationFetched: (Location) -> Unit
) {
    val fusedLocationClient = LocationServices
        .getFusedLocationProviderClient(context)

    val locationRequest = LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY,
        1000
    ).apply {
        setMinUpdateIntervalMillis(5000)
        setWaitForAccurateLocation(true)
    }.build()

    val locationCallback = object: LocationCallback() {

        override fun onLocationResult(locationResult: LocationResult) {
            locationResult.lastLocation?.let {
                currentLocation -> onLocationFetched(currentLocation)
            }
        }
    }

    try {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }
    catch (e: SecurityException) {
        e.printStackTrace()
    }
}

