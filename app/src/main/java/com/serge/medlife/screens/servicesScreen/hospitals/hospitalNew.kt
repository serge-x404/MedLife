package com.serge.medlife.screens.servicesScreen.hospitals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HospitalMap() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMap(
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition(
                    LatLng(23.05,72.50),
                    16f,
                    0f,
                    0f
                )
            }
        )
    }
}