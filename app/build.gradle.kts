plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}
android {
    namespace = "com.example.carepoint"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.carepoint"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-storage:21.0.0")
    implementation("com.google.firebase:firebase-messaging:24.0.0")
    implementation("com.github.mukeshsolanki:android-otpview-pinview:2.1.2")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.Ajinkrishnak:CountryCodePicker:1.0.2")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.pgreze:android-reactions:1.6")
    implementation ("com.google.firebase:firebase-firestore:25.1.0")
    implementation ("com.hbb20:ccp:2.5.0")
    implementation("com.google.firebase:firebase-dynamic-links:21.0.0")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("com.google.firebase:firebase-database:21.0.0")
    implementation ("com.google.firebase:firebase-firestore:25.1.1")
}