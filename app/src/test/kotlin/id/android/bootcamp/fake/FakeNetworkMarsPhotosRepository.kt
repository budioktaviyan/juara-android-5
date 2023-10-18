package id.android.bootcamp.fake

import id.android.bootcamp.data.MarsPhotosRepository
import id.android.bootcamp.network.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
  override suspend fun getMarsPhotos(): List<MarsPhoto> =
    FakeDataSource.photosList
}