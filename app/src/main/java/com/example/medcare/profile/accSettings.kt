package com.example.medcare.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun AccountSettings() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("Account Setting",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ) },
            navigationIcon = { Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null
            ) }
        ) }
    ) {
        innerPadding ->

        var expand by remember {
            mutableStateOf(false)
        }

        var password by remember { mutableStateOf("") }

        val listOfLang = listOf("English", "Hindi", "Gujarati")

        var selected by remember {
            mutableStateOf<String?>(null)
        }
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize()) {
                Text("Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )
                Spacer(Modifier.height(4.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = Modifier
                        .border(1.dp, Color(0xFFA6CFD5), shape = RoundedCornerShape(4.dp))
                        .height(48.dp)
                        .fillMaxWidth(),
                    placeholder = {Text("Enter your password")},
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(Modifier.height(12.dp))
                Text("Language",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )
                Spacer(Modifier.height(4.dp))
                ExposedDropdownMenuBox(expanded = expand,
                    onExpandedChange = {
                        expand = !expand
                    }) {
                    OutlinedTextField(
                        value = selected ?: listOfLang.first(),
                        onValueChange = {},
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFA6CFD5),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .fillMaxWidth()
                            .height(48.dp)
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(expanded = expand,
                        onDismissRequest = {
                            expand = !expand}) {
                        listOfLang.forEach {
                            language ->
                            DropdownMenuItem(
                                text = { Text(language)},
                                onClick = {
                                    selected = language
                                    expand = false
                                }
                            )
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                Text("Privacy Settings",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF26408B)
                )
                Spacer(Modifier.height(4.dp))
                Row(modifier = Modifier
                    .border(width = 1.dp, color = Color(0xFFA6CFD5), shape = RoundedCornerShape(4.dp))
                    .padding(12.dp)
                    .clickable(enabled = true,
                        onClick = {}),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Information Privacy",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                }
            }
        }
    }
}