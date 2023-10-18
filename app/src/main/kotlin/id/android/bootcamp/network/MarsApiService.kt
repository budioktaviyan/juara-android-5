package id.android.bootcamp.network

import retrofit2.http.GET

interface MarsApiService {

  @GET("photos")
  suspend fun getPhotos(): List<MarsPhoto>
}