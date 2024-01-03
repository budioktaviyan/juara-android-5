package id.android.bootcamp

import id.android.bootcamp.fake.FakeDataSource
import id.android.bootcamp.fake.FakeNetworkMarsPhotosRepository
import id.android.bootcamp.rules.TestDispatcherRule
import id.android.bootcamp.ui.screen.MarsUiState
import id.android.bootcamp.ui.screen.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

  @get:Rule
  val testDispatcher = TestDispatcherRule()

  @Test
  fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
    val marsViewModel = MarsViewModel(
      repository = FakeNetworkMarsPhotosRepository()
    )
    assertEquals(
      MarsUiState.Success(FakeDataSource.photosList),
      marsViewModel.marsUiState
    )
  }
}