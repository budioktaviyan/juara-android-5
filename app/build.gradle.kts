plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  namespace = "id.android.bootcamp"
  compileSdk = 34
  buildToolsVersion = "34.0.0"

  defaultConfig {
    applicationId = "id.android.bootcamp"
    minSdk = 29
    targetSdk = 34
    versionCode = 1
    versionName = "1.0.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables.useSupportLibrary = true
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures.compose = true
  composeOptions.kotlinCompilerExtensionVersion = "1.5.3"
  packaging {
    resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
  }
}

dependencies {
  implementation(platform("androidx.compose:compose-bom:2023.10.00"))

  implementation("androidx.activity:activity-compose:1.8.0")

  implementation("androidx.compose.material:material-icons-extended")
  implementation("androidx.compose.material3:material3")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")

  implementation("androidx.core:core-ktx:1.12.0")

  implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["version.lifecycle"]}")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${rootProject.extra["version.lifecycle"]}")

  androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")

  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")

  testImplementation("junit:junit:4.13.2")

  debugImplementation("androidx.compose.ui:ui-test-manifest")
  debugImplementation("androidx.compose.ui:ui-tooling")
}