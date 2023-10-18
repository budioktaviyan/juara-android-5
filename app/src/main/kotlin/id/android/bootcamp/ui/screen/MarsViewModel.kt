package id.android.bootcamp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.android.bootcamp.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState {
  data class Success(val photos: String) : MarsUiState
  data object Error : MarsUiState
  data object Loading : MarsUiState
}

class MarsViewModel : ViewModel() {

  /** The mutable State that stores the status of the most recent request */
  var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
    private set

  /**
   * Call getMarsPhotos() on init so we can display status immediately
   */
  init {
    getMarsPhotos()
  }

  /**
   * Gets Mars photos information from the Mars API Retrofit service and updates the
   * [MarsPhoto] [List] [MutableList]
   */
  private fun getMarsPhotos() {
    viewModelScope.launch {
      marsUiState = try {
        val listResult = MarsApi.retrofitService.getPhotos()
        MarsUiState.Success("Success: ${listResult.size} Mars photos retrieved")
      } catch (e: IOException) {
        MarsUiState.Error
      }
    }
  }
}