package com.example.maptestone.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.StreetViewPanoramaOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.streetview.rememberStreetViewCameraPositionState

@Composable
fun MapsScreen(){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    val points = listOf(
        LatLng(1.35, 103.97),
        LatLng(1.36, 105.78),
        LatLng(1.47, 104.79)
    )


    GoogleMap(
        cameraPositionState = cameraPositionState,
    ) {
        Polyline(points = points)
    }
}
@Composable
fun StreetView(name:String){
    val singapore=LatLng(1.35,103.87)
    var isPanningEnabled by remember{ mutableStateOf(false) }
    var isStreetNamesEnabled by remember{ mutableStateOf(true) }
    var isUserNavigationEnabled by remember { mutableStateOf(true) }
    var isZoomGesturesEnabled by remember{ mutableStateOf(true) }
    val camera= rememberStreetViewCameraPositionState()
    val context= LocalContext.current
    Box( Modifier.fillMaxSize(), Alignment.BottomStart){
        com.google.maps.android.compose.streetview.StreetView(
            Modifier.matchParentSize(),
            cameraPositionState = camera,
            streetViewPanoramaOptionsFactory = {
                StreetViewPanoramaOptions().position(singapore)
                StreetViewPanoramaOptions().zoomGesturesEnabled(true)
            },
            isPanningGesturesEnabled = isPanningEnabled,
            isStreetNamesEnabled = isStreetNamesEnabled,
            isUserNavigationEnabled = isUserNavigationEnabled,
            isZoomGesturesEnabled = isZoomGesturesEnabled,
            onClick = { Toast.makeText(context,"Street view clicked",Toast.LENGTH_SHORT).show()},
            onLongClick = {
                Toast.makeText(context,"Street view long clicked ${it.tilt} ${it.bearing} ${it.toString()}",Toast.LENGTH_SHORT).show()
            }
        )
    }

}

