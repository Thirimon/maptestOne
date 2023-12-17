package com.example.maptestone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.maptestone.screens.LocationPermissionScreen
import com.example.maptestone.screens.MapScreen
import com.example.maptestone.screens.MapsScreen
import com.example.maptestone.screens.StreetView
import com.example.maptestone.ui.theme.MaptestOneTheme
import com.example.maptestone.utils.checkForPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaptestOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var hasLocationPermission by remember{ mutableStateOf(checkForPermission(this)) }

                    if (hasLocationPermission) {
                        //MapScreen(this)
                        //MapsScreen()
                        //StreetView(name = "Android")
                    } else {
                        LocationPermissionScreen {
                            hasLocationPermission = true
                        }
                    }
                }
            }
        }
    }
}


