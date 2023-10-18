package id.android.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import id.android.bootcamp.ui.RaceTrackerApp
import id.android.bootcamp.ui.theme.RaceTrackerTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      RaceTrackerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
          RaceTrackerApp()
        }
      }
    }
  }
}