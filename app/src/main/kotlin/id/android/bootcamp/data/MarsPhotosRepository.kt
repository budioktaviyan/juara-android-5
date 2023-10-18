package id.android.bootcamp.data

import id.android.bootcamp.network.MarsApiService
import id.android.bootcamp.network.MarsPhoto

interface MarsPhotosRepository {

  suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(private val service: MarsApiService) : MarsPhotosRepository {

  override suspend fun getMarsPhotos(): List<MarsPhoto> =
    service.getPhotos()
}