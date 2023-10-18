package id.android.bootcamp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.android.bootcamp.network.MarsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {

  val repository: MarsPhotosRepository
}

class DefaultAppContainer : AppContainer {

  private val baseURL = "https://android-kotlin-fun-mars-server.appspot.com"

  private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(baseURL).build()

  private val retrofitService: MarsApiService by lazy {
    retrofit.create(MarsApiService::class.java)
  }

  override val repository: MarsPhotosRepository by lazy {
    NetworkMarsPhotosRepository(retrofitService)
  }
}