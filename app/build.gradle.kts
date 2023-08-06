plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.alternova.lego"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.alternova.lego"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //SPLASH
    implementation("androidx.core:core-splashscreen:${Versions.splashScreen}")

    //COROUTINES
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}")

    //VIEW MODEL
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelVersion}")

    //LIVEDATA
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedataVersion}")

    //EXTENSION FOR LIFE CYCLE SCOPES IN ACTIVITIES & FRAGMENTS
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecyleRuntimeVersion}")

    //EXTENSION KTX FOR VIEW MODELS IN ACTIVITIES AND FRAGMENTS
    implementation("androidx.activity:activity-ktx:${Versions.viewmodelActivityVersion}")
    implementation("androidx.fragment:fragment-ktx:${Versions.viewmodelFragmentVersion}")

    //NAVIGATION
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navVersion}")
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}")

    //HILT
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")
    implementation("androidx.hilt:hilt-navigation-fragment:${Versions.hiltNavigationVersion}")

    implementation("androidx.room:room-runtime:${Versions.roomVersion}")
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")
    implementation("androidx.room:room-ktx:${Versions.roomVersion}")

    //GLIDE
    implementation("com.github.bumptech.glide:glide:${Versions.glideVersion}")
    annotationProcessor("com.github.bumptech.glide:compiler:${Versions.glideVersion}")

    //LOTTIE
    implementation("com.airbnb.android:lottie:${Versions.lottieVersion}")

    //RETROFIT
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //INTERCEPTOR
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    //FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-auth-ktx") //AUTH


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}