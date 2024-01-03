package id.android.bootcamp.fake

import id.android.bootcamp.network.MarsPhoto

object FakeDataSource {

  private const val idOne = "img1"
  private const val idTwo = "img2"
  private const val imgOne = "url.1"
  private const val imgTwo = "url.2"

  val photosList = listOf(
    MarsPhoto(
      id = idOne,
      imgSrc = imgOne
    ),
    MarsPhoto(
      id = idTwo,
      imgSrc = imgTwo
    )
  )
}