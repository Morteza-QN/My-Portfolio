@file:Suppress("UnstableApiUsage")

pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		maven("https://jitpack.io")
		maven("https://repository.jboss.org/maven2")
		maven("https://maven.google.com/")
		maven("https://plugins.gradle.org/m2/")
		mavenCentral()
	}
}

rootProject.name = "My Portfolio"
include(":app")