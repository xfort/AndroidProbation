# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/Mac/MacWork/android/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keepattributes **
-keepattributes Signature
-keepattributes *Annotation*

-keepattributes JNINamespace
-keepattributes CalledByNative
-keepattributes EnclosingMethod
-keepattributes JavascriptInterface

-keep class org.xwalk.**{ *; }
-keep interface org.xwalk.**{ *; }

-keep class org.crosswalk.engine.** { *; }
-keep class org.chromium.** { *; }

-keep class org.crosswalkproject.**{ *; }
-keep class SevenZip.**{*;}

-keepclasseswithmembers class org.chromium.** {*;}

-keep @org.chromium.base.UsedBy* class *
-keepclassmembers class * {
    @org.chromium.base.UsedBy* *;
}

-keep @org.chromium.base.annotations.JNINamespace* class *
-keepclassmembers class * {
    @org.chromium.base.annotations.CalledByNative* *;
}

-dontnote org.chromium.net.AndroidKeyStore
-dontnote org.chromium.net.UrlRequest$ResponseHeadersMap
-dontwarn org.chromium.**


-keep class org.apache.cordova.**{*;}
-keepclasseswithmembers class org.apache.cordova.**{*;}

-keepclassmembers class com.xiushuang.xprobation.utils.JSHandler {
   public *;
}