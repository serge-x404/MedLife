package com.serge.medlife.screens.profile

import android.content.Context

fun Context.getVersionName(): String {
    return try {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        packageInfo.versionName ?: "Unknown"
    } catch (_: Exception) {
        "Unknown"
    }
}
