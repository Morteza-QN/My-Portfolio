plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.parcelize)
	alias(libs.plugins.ksp)
	alias(libs.plugins.hilt)
}

android {
	namespace = "me.mqn.portfolio"
	compileSdk = 34

	defaultConfig {
		applicationId = "me.mqn.portfolio"
		minSdk = 25
		targetSdk = 34

		val major = 0
		val minor = 0
		val patch = 1

		versionCode = (100_000 * major) + (1_000 * minor) + (patch)
		versionName = "${major / 100_000}.${minor / 1_000}.$patch"
		// versionCode = 1
		// versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		// buildConfigField("String", "APPLICATION_ID", "\"ir.adorateb.medicina\"")
	}

	buildTypes {
		release {
			buildConfigField("String", "BASE_URL", "\"https://api.example.com/\"")
			// buildConfigField("String", "API_KEY", appProperties.getProperty("API_KEY_MAIN"))
			buildConfigField("String", "BUILD_TYPE", "\"RELEASE\"")
			// resValue("string", "app_name", "AdoreX")
			applicationIdSuffix = ".release"
			isDebuggable = false
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
		debug {
			buildConfigField("String", "BASE_URL", "\"https://api.example.com/\"")
			// buildConfigField("String", "API_KEY", appProperties.getProperty("API_KEY_DEVELOP"))
			buildConfigField("String", "BUILD_TYPE", "\"DEBUG\"")
			// resValue("string", "app_name", "AdoreXdebug")
			applicationIdSuffix = ".debug"
			isDebuggable = true
			isMinifyEnabled = false
			// isCrunchPngs = false
			// ext.set("enableCrashlytics", false)
			// ext.set("alwaysUpdateBuildId", false)
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro",
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_17.toString()
	}
	buildFeatures {
		viewBinding = true
		buildConfig = true
	}
	lint {
		abortOnError = true
		warningsAsErrors = false
		checkDependencies = true
		// baseline = file("lint-baseline.xml")
		// lintConfig = file("lint.xml")
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
	sourceSets {
		val kotlinAdditionalSourceSets = project.file("src/main/kotlin")
		findByName("main")?.java?.srcDirs(kotlinAdditionalSourceSets)
		getByName("androidTest").assets.srcDir("$projectDir/schemas")
	}
	// hilt {
	// 	enableAggregatingTask = true
	// }
}

dependencies {

	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	// testImplementation(libs.junit)
	// androidTestImplementation(libs.androidx.junit)
	// androidTestImplementation(libs.androidx.espresso.core)

	// region hilt - dependency injection
	implementation(libs.hilt.android)
	ksp(libs.hilt.android.compiler)
	ksp(libs.hilt.compiler)
}