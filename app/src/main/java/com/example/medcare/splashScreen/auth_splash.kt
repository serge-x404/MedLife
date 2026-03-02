package com.example.medcare.splashScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R


@Composable
fun AuthSplashScreen(
    navigateToRegister: () -> Unit,
    navigateToLogin: () -> Unit
//    navigateToHome: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            .padding(horizontal = 10.dp, vertical = 20.dp)
    ) {

        // Remove Language Button

//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 30.dp)
//                .padding(horizontal = 12.dp)
//        ) {
//            val context = LocalContext.current
//            Button(
//                onClick = {
//                    Toast.makeText(
//                        context,
//                        "App language will be available soon",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    navigateToLogin()
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inverseSurface),
//                border = BorderStroke(
//                    width = 1.dp,
//                    color = MaterialTheme.colorScheme.outlineVariant
//                ),
//                modifier = Modifier.align(Alignment.TopEnd)
//            ) {
//                Text(
//                    text = "English",
//                    color = MaterialTheme.colorScheme.inverseOnSurface,
//                    style = MaterialTheme.typography.labelMedium
//                )
//            }
//        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(R.drawable.medlife_main),
                contentDescription = null, Modifier.size(250.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
            Text(
                text = "We're here to keep you healthy",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(Modifier.height(150.dp))
            Column(Modifier.padding(vertical = 20.dp)) {
                Button(
                    onClick = {
                        navigateToLogin()
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Login",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Button(
                    onClick = {
                        navigateToRegister()
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                    border = BorderStroke(width = 2.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Register",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}
