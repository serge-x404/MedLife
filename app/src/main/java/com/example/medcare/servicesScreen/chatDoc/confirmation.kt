package com.example.medcare.servicesScreen.chatDoc

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.SwipeableState
import androidx.wear.compose.material.swipeable
import com.example.medcare.R
import kotlin.math.roundToInt

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Confirmation(
    back: () -> Unit,
    navigateToAppointmentSuccess: () -> Unit
) {
    var checked by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Confirmation",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }, navigationIcon = {
                IconButton(onClick = back) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            })
        }) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Column(Modifier.padding(horizontal = 20.dp)) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHighest),
                    modifier = Modifier,
                    elevation = CardDefaults.elevatedCardElevation(2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.dr_luca),
                            contentDescription = null,
                            Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                        )
                        Column {
                            Text(
                                text = "Dr. Luca Rossi",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "Cardiology Specialist",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surfaceContainer)
                                .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Education",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                            Text(
                                text = "University of Milan",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surfaceContainer)
                                .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "License",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                            Text(
                                text = "1276126552881",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.elevatedCardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(
                            text = "Detail Appointment",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(Modifier.height(10.dp))
                        HorizontalDivider()
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Date & Time",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = "Wednesday, 22 Feb 1.00PM",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Location",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Rossi Cardiology Clinic\n" +
                                        "Via Garibaldi 15, Milan, Italy",
                                maxLines = 2,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "See Maps",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.surfaceTint
                            )
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Card(
                    onClick = {checked = !checked},
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.bell),
                            contentDescription = null,
                            Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Activate notifications",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it },
                            colors = SwitchDefaults.colors(
                                checkedTrackColor = MaterialTheme.colorScheme.secondary
                            )
                        )
                    }
                }
            }
            Box(modifier = Modifier.fillMaxSize()
                .padding(vertical = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                SwipeToConfirmButton(navigateToAppointmentSuccess)
            }
        }
    }
}


//@OptIn(ExperimentalWearMaterialApi::class)
//@Composable
//private fun SwipeableSample() {
//    val width = 96.dp
//    val squareSize = 48.dp
//
//    val swipeableState: SwipeToDismissBoxState = rememberSwipeToDismissBoxState(SwipeToDismissBoxValue.StartToEnd)
//    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
//    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states
//
//    Box(
//        modifier = Modifier
//            .width(width)
//            .swipeable(
//                state = swipeableState,
//                anchors = anchors,
//                thresholds = { _, _ -> FractionalThreshold(0.3f) },
//                orientation = Orientation.Horizontal
//            )
//            .background(Color.LightGray)
//    ) {
//        Box(
//            Modifier
//                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
//                .size(squareSize)
//                .background(Color.DarkGray)
//        )
//    }
//}


@Composable
fun SwipeToConfirmButton(
    navigateToAppointmentSuccess: () -> Unit
) {
    Box {
        val width = 320.dp
        val height = 56.dp
        val thumbSize = 48.dp
        val cornerRadius = 28.dp

        val density = LocalDensity.current
        val maxOffsetPx = with(density) { ((width) - thumbSize - 12.dp).toPx() }

        var offsetX by remember { mutableStateOf(0f) }
        var confirmed by remember { mutableStateOf(false) }

        val animatedOffset by animateFloatAsState(
            targetValue = offsetX,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessLow
            ),
            label = "SwipeOffset"
        )

        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .clip(RoundedCornerShape(cornerRadius))
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.outlineVariant,
                    RoundedCornerShape(cornerRadius)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (confirmed) "Appointment scheduled" else "Swipe to confirm",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge
            )

            val context = LocalContext.current

            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .offset { IntOffset(animatedOffset.roundToInt(), 0) }
                    .size(thumbSize)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainerLow)
                    .draggable(
                        enabled = !confirmed,
                        orientation = Orientation.Horizontal,
                        state = rememberDraggableState { delta ->
                            offsetX = (offsetX + delta)
                                .coerceIn(0f, maxOffsetPx)
                        },
                        onDragStopped = {
                            if (offsetX > maxOffsetPx * 0.85f) {
                                offsetX = maxOffsetPx
                                confirmed = true
                                Toast
                                    .makeText(
                                        context,
                                        "Appointment booked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()

                                navigateToAppointmentSuccess()
                            } else {
                                offsetX = 0f
                            }
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (confirmed)
                        Icons.Default.Check
                    else
                        Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}