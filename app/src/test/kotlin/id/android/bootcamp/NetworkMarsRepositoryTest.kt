package id.android.bootcamp

import id.android.bootcamp.data.NetworkMarsPhotosRepository
import id.android.bootcamp.fake.FakeDataSource
import id.android.bootcamp.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {

  @Test
  fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
    val repository = NetworkMarsPhotosRepository(
      service = FakeMarsApiService()
    )
    assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
  }
}