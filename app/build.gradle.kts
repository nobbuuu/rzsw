plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
}

android {
    namespace = "com.blackview.search"
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        applicationId = "com.blackview.search"
        minSdk = BuildConfig.minSdkVersion
        targetSdk = BuildConfig.targetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures.aidl = true
    buildFeatures.viewBinding = true

}

dependencies {
    implementation(fileTree("libs") { include("*.jar", "*.aar") })
    implementation(project(":base"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.banner)
    implementation(ThreeParty.XRecyclerView)
    implementation(ThreeParty.AutoSize)
    testImplementation(libs.junit)
    testImplementation(libs.material)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(AndroidX.room.roomRuntime)
    implementation(AndroidX.room.roomKtx)
    kapt(AndroidX.room.roomCompiler)
}