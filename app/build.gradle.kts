import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")

    id("com.google.devtools.ksp") version "2.3.6"
    id("com.google.dagger.hilt.android")
}

val localProperties = Properties()
localProperties.load(rootProject.file("local.properties").inputStream())

android {
    namespace = "com.serge.medlife"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.serge.medlife"
        minSdk = 25
        targetSdk = 36
        versionCode = 1
        versionName = "0.3.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // supabase
        buildConfigField("String", "SUPABASE_URL", "\"${localProperties["SUPABASE_URL"]}\"")
        buildConfigField("String", "SUPABASE_ANON_KEY", "\"${localProperties["SUPABASE_ANON_KEY"]}\"")

        // Places
        buildConfigField("String", "MAPS_API_KEY", "\"${localProperties["MAPS_API_KEY"]}\"")

        // maps
        val localProps = Properties().apply {
            load(rootProject.file("local.properties").inputStream())
        }

        manifestPlaceholders["mapsApiKey"] = localProps["MAPS_API_KEY"] as String? ?: ""
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
//    kotlinOptions {
//        jvmTarget = "17"
//    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.database)
    implementation(libs.androidx.compose.ui.text.google.fonts)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Firebase dependencies
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.ai)


    // Supabase dependencies
    implementation(libs.storage.kt)
    implementation(libs.ktor.client.android)

    // Google Maps
    implementation(libs.maps.compose)

    // Icons Fix trial
    implementation(libs.androidx.compose.material.icons.core)
    implementation(libs.androidx.compose.material.icons.extended)

    // Chat response Markdown
    implementation(libs.compose.markdown)

    // Places API
    implementation(libs.places)
    implementation(libs.places)

    // ROOM database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // KSP
    implementation("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:dagger-compiler:2.51.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.59.2")
    ksp("com.google.dagger:hilt-android-compiler:2.59.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")
}