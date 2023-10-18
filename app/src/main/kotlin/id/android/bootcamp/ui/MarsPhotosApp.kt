@file:OptIn(ExperimentalMaterial3Api::class)

package id.android.bootcamp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import id.android.bootcamp.R
import id.android.bootcamp.ui.screen.HomeScreen
import id.android.bootcamp.ui.screen.MarsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MarsPhotosApp() {
  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) }
  ) {
    Surface(modifier = Modifier.fillMaxSize()) {
      val marsViewModel: MarsViewModel = viewModel(factory = MarsViewModel.Factory)
      HomeScreen(
        marsUiState = marsViewModel.marsUiState,
        retryAction = marsViewModel::getMarsPhotos
      )
    }
  }
}

@Composable
fun MarsTopAppBar(
  scrollBehavior: TopAppBarScrollBehavior,
  modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    scrollBehavior = scrollBehavior,
    title = {
      Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.headlineSmall
      )
    },
    modifier = modifier
  )
}