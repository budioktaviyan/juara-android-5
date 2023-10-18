package id.android.bootcamp.data

import id.android.bootcamp.network.MarsApi
import id.android.bootcamp.network.MarsPhoto

interface MarsPhotosRepository {

  suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository : MarsPhotosRepository {

  override suspend fun getMarsPhotos(): List<MarsPhoto> =
    MarsApi.retrofitService.getPhotos()
}