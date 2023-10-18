package id.android.bootcamp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.android.bootcamp.R
import id.android.bootcamp.ui.theme.MarsPhotosTheme

@Composable
fun HomeScreen(
  marsUiState: String,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp), ) {
  ResultScreen(
    marsUiState,
    modifier.padding(top = contentPadding.calculateTopPadding())
  )
}

/**
 * ResultScreen displaying number of photos retrieved
 */
@Composable
fun ResultScreen(
  photos: String,
  modifier: Modifier = Modifier) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = modifier) {
    Text(text = photos)
  }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
  MarsPhotosTheme {
    ResultScreen(stringResource(R.string.placeholder_result))
  }
}