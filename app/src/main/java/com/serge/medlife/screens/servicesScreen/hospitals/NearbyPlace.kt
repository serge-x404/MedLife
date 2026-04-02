package com.serge.medlife.screens.servicesScreen.hospitals

import com.google.android.gms.maps.model.LatLng

data class NearbyPlace(
    val name: String = "",
    val address: String = "",
    val latLng: LatLng = LatLng(0.0,0.0)
)
