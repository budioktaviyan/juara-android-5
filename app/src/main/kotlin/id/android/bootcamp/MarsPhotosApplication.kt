package id.android.bootcamp

import android.app.Application
import id.android.bootcamp.data.AppContainer
import id.android.bootcamp.data.DefaultAppContainer

class MarsPhotosApplication : Application() {

  lateinit var container: AppContainer

  override fun onCreate() {
    super.onCreate()
    container = DefaultAppContainer()
  }
}