package com.serge.medlife.screens.servicesScreen.hospitals

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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberUpdatedMarkerState
import kotlinx.coroutines.launch

@Composable
fun HospitalMap() {

    var mapLoaded by remember {
        mutableStateOf(false)
    }
    val cameraPositionState = rememberCameraPositionState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val scope = rememberCoroutineScope()

        var latLng by remember { mutableStateOf(LatLng(23.05,72.50)) }
        val markerState = rememberUpdatedMarkerState(latLng)

        GoogleMap(
            onMapLoaded = {
                mapLoaded = true
            },
            cameraPositionState = cameraPositionState,
            onMapClick = {
                latLng = it
                markerState.position = it

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
            Marker(
                state = markerState
            )
        }

    }

    LaunchedEffect(mapLoaded) {
        cameraPositionState.animate(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(23.05,72.50),
                15f
            )
        )
    }
}