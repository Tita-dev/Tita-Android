plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    //navigation
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.example.tita"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures{
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures { //viewbinding
        viewBinding = true
    }
}


dependencies {
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.32")
    //noinspection GradleDependency,GradleDependency
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.32")
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.32")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    testImplementation("junit:junit:4.13.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    implementation("androidx.multidex:multidex:2.0.1")

    //모션레이아웃
    implementation("com.android.support.constraint:constraint-layout:2.0.4")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    // RxLifecycle
    implementation("com.trello.rxlifecycle3:rxlifecycle:3.1.0")
    implementation("com.trello.rxlifecycle3:rxlifecycle-android:3.1.0")
    implementation("com.trello.rxlifecycle3:rxlifecycle-components:3.1.0")

    // Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // koin
    implementation("org.koin:koin-androidx-scope:2.1.5")
    implementation("org.koin:koin-androidx-viewmodel:2.1.5")
    implementation("org.koin:koin-androidx-fragment:2.1.5")

    implementation("com.github.f0ris.sweetalert:library:1.6.2")

    implementation("androidx.room:room-runtime:2.2.6")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.2.6")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:2.2.6")

    //네이버 로그인
    implementation("com.naver.nid:naveridlogin-android-sdk:4.2.6")   // import from jcenter

    // naveridlogin dependencies
    implementation("androidx.appcompat:appcompat:1.0.0")
    implementation("androidx.legacy:legacy-support-core-utils:1.0.0")
    implementation("androidx.browser:browser:$1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}