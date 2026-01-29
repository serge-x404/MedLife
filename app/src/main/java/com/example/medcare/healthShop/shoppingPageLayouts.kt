package com.example.medcare.healthShop

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.R

@Composable
fun ImageGridPharma(item: Int) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(item),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotSalesGrid(hotSales: HotSales) {
    val sheetState = rememberModalBottomSheetState()
    var stateChange by remember { mutableStateOf(false) }
    if(stateChange) {
        ModalBottomSheet(onDismissRequest = {stateChange = false},
            sheetState = sheetState
        ) {
            Column(modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()) {
                Row() {
                    Image(
                        painter = painterResource(hotSales.image),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                    Column() {
                        Text(
                            text = hotSales.medicineName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.strip)
                        )
                        Spacer(Modifier.height(6.dp))
                        Row {
                            Text(
                                text = "Starts from:"
                            )
                            Text(
                                text = "$2.00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color(0xFF26408B)
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Button(onClick = {},
                                colors = ButtonDefaults.buttonColors(Color.White),
                                border = BorderStroke(width = 1.dp, Color(0xFF26408B)),
                                shape = RoundedCornerShape(10.dp)) {
                                Text("-",
                                    color = Color(0xFF26408B))
                            }
                            Button(onClick = {},
                                colors = ButtonDefaults.buttonColors(Color.White),
                                border = BorderStroke(width = 1.dp, Color(0xFF26408B)),
                                shape = RoundedCornerShape(10.dp)) {
                                Text("+",
                                    color = Color(0xFF26408B))
                            }
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF26408B))) {
                    Text(
                        text = "Add to Cart"
                    )
                }
            }
        }
    }
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(6.dp),
    ) {
        Column(Modifier.padding(6.dp)) {
            Image(
                painter = painterResource(hotSales.image),
                contentDescription = null,
                Modifier.size(100.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = hotSales.medicineName,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Per Strip",
                color = Color(0xFF8F8F8F)
            )
            Spacer(Modifier.height(20.dp))
            Row {
                Column {
                    Text(
                        text = "Starts from",
                        fontSize = 12.sp
                    )
                    Text(
                        text = "$2.00",
                        color = Color(0xFF26408B),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                }
                Spacer(Modifier.width(6.dp))
                Button(onClick = { stateChange = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp,Color(0xFF26408B))
                ) {
                    Text(
                        text = "Add",
                        color = Color(0xFF26408B)
                    )
                }
            }
        }
    }
}


@Composable
fun CartCard(hotSales: HotSales) {
    Card(onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 1.dp, Color(0xFFE3E3E3))) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(hotSales.image),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(Modifier.width(4.dp))
            Column() {
                Text(
                    text = hotSales.medicineName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = stringResource(R.string.strip)
                )
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Starts from:"
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = "$2.00",
                        color = Color(0xFF26408B),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}