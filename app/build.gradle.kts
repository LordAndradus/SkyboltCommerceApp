plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "edu.utsa.cs3443.skyboltcommerceapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.utsa.cs3443.skyboltcommerceapp"
        minSdk = 23
        targetSdk = 34
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
        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_17
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_17
    }
    kotlinOptions{
        jvmTarget = "17"
    }

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
}

buildscript{
    repositories{

    }

    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.52")
        classpath("com.google.gms:google-services:4.4.2")
        val nav_version = "2.8.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}


dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    //Loading button
    implementation("com.github.leandroborgesferreira:loading-button-android:2.3.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //Circular images
    implementation("de.hdodenhof:circleimageview:3.1.0")

    //View page Indicator
    //implementation("io.github.vejei.viewpagerindicator:viewpagerindicator:1.0.0-alpha.1")

    //View Pager Indicator backup
    //implementation("com.github.vivchar:ViewPagerIndicator:1.1.3")

    //Step Viewer
    implementation("com.github.shuhart:stepview:1.5.1")

    //Android Ktx
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.3")

    //Dagger hilt
    kapt("com.google.dagger.hilt:hilt-compiler:2.52")
    implementation("com.google.dagger:hilt-android:2.52")

    //Firebase
    implementation("com.google.firebase:firebase-auth:23.1.0")
}