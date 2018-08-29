#!/bin/bash
set -e

AAPT="/home/efefer/Android/Sdk/build-tools/27.0.3/aapt"
DX="/home/efefer/Android/Sdk/build-tools/27.0.3/dx"
ZIPALIGN="/home/efefer/Android/Sdk/build-tools/27.0.3/zipalign"
APKSIGNER="/home/efefer/Android/Sdk/build-tools/27.0.3/apksigner"
PLATFORM="/home/efefer/Android/Sdk/platforms/android-27/android.jar"
ADB="/home/efefer/Android/Sdk/platform-tools/adb"


echo "Cleaning..."
rm -rf obj/*
rm -rf src/com/efefer/hello/R.java

echo "Generating R.java file..."
$AAPT package -f -m -J src -M AndroidManifest.xml -S res -I $PLATFORM 

echo "Compiling..."
#javac -d obj -classpath src -bootclasspath $PLATFORM -source 1.8 -target 1.8 src/com/efefer/hello/MainActivity.java
#javac -d obj -classpath src -bootclasspath $PLATFORM -source 1.8 -target 1.8 src/com/efefer/hello/R.java
#javac -d obj -classpath "src:libs/android-support-v7-appcompat.jar:libs/android-support-v4.jar" \
#-bootclasspath $PLATFORM src/com/efefer/hello/*.java
javac -d obj -classpath src -bootclasspath $PLATFORM src/com/efefer/hello/*.java

echo "Translating in Dalvik bytecode..."
$DX --dex --output=classes.dex obj

echo "Making APK..."
$AAPT package -f -m -F bin/hello.unaligned.apk -M AndroidManifest.xml -S res -I $PLATFORM
$AAPT add bin/hello.unaligned.apk classes.dex

echo "Aligning and signing APK..."
$APKSIGNER sign --ks mykey.keystore bin/hello.unaligned.apk
$ZIPALIGN -f 4 bin/hello.unaligned.apk bin/hello.apk

#if [ "$1" == "test" ]; then

echo "Launching..."
$ADB install -r bin/hello.apk

#	~/Android/Sdk/platform-tools/adb shell am start -n com.efefer.helloandroid/.MainActivity
#fi
