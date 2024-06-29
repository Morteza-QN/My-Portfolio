# If your project uses R8 or ProGuard add the following rules:
-dontskipnonpubliclibraryclassmembers
-ignorewarnings

-keep class androidx.appcompat.widget.SearchView { *; }
-keep class androidx.appcompat.widget.Toolbar { *** mMenuView; }
-keep class androidx.appcompat.widget.ActionMenuView { *** mPresenter; }
-keep class androidx.appcompat.widget.ActionMenuPresenter { *** mOverflowButton; }

-keep public class * extends androidx.core.view.ActionProvider {
    public <init>(android.content.Context);
}

-keepclassmembernames class kotlinx.** { volatile <fields>; }
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings { <fields>; }
-keepclassmembers class kotlin.Metadata { public <methods>; }

-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}

-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembernames class kotlinx.** { volatile <fields>; }

# glide
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep public class * extends com.bumptech.glide.module.AppGlideModule
#-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}