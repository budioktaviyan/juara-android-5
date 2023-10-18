package id.android.bootcamp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import id.android.bootcamp.R
import id.android.bootcamp.network.MarsPhoto
import id.android.bootcamp.ui.theme.MarsPhotosTheme

@Composable
fun HomeScreen(
  marsUiState: MarsUiState,
  modifier: Modifier = Modifier,
  contentPadding: PaddingValues = PaddingValues(0.dp)) {
  when (marsUiState) {
    is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
    is MarsUiState.Success -> MarsPhotoCard(photo = marsUiState.photos)
    is MarsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
  }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
  Image(
    modifier = modifier.size(200.dp),
    painter = painterResource(R.drawable.loading_img),
    contentDescription = stringResource(R.string.loading)
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
    modifier = modifier
  ) {
    Text(text = photos)
  }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_connection_error),
      contentDescription = ""
    )
    Text(
      text = stringResource(R.string.loading_failed),
      modifier = Modifier.padding(16.dp)
    )
  }
}

@Composable
fun MarsPhotoCard(photo: MarsPhoto) {
  AsyncImage(
    model = ImageRequest.Builder(context = LocalContext.current)
      .data(photo.imgSrc)
      .crossfade(true).build(),
    error = painterResource(id = R.drawable.ic_broken_image),
    placeholder = painterResource(R.drawable.loading_img),
    contentDescription = stringResource(R.string.mars_photo),
    contentScale = ContentScale.Crop
  )
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
  MarsPhotosTheme {
    ResultScreen(stringResource(R.string.placeholder_result))
  }
}