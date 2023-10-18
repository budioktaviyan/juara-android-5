package id.android.bootcamp.fake

import id.android.bootcamp.network.MarsApiService
import id.android.bootcamp.network.MarsPhoto

class FakeMarsApiService : MarsApiService {

  override suspend fun getPhotos(): List<MarsPhoto> =
    FakeDataSource.photosList
}