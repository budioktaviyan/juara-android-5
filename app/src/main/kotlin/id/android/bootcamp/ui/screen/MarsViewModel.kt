package id.android.bootcamp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.android.bootcamp.MarsPhotosApplication
import id.android.bootcamp.data.MarsPhotosRepository
import id.android.bootcamp.network.MarsPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MarsUiState {
  data class Success(val photos: List<MarsPhoto>) : MarsUiState
  data object Error : MarsUiState
  data object Loading : MarsUiState
}

class MarsViewModel(private val repository: MarsPhotosRepository) : ViewModel() {

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
        MarsUiState.Success(repository.getMarsPhotos())
      } catch (e: IOException) {
        MarsUiState.Error
      } catch (e: HttpException) {
        MarsUiState.Error
      }
    }
  }

  companion object {

    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
        val repository = application.container.repository
        MarsViewModel(repository = repository)
      }
    }
  }
}