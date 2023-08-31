ABI=$(adb shell getprop ro.product.cpu.abi | tr -d '\r')

adb push libs/$ABI/minicap /data/local/tmp/

SDK=$(adb shell getprop ro.build.version.sdk | tr -d '\r')
adb push jni/minicap-shared/aosp/libs/android-$SDK/$ABI/minicap.so /data/local/tmp/


adb shell LD_LIBRARY_PATH=/data/local/tmp /data/local/tmp/minicap -P 1170x1872@585x936/0

adb forward tcp:1717 localabstract:minicap


nc localhost 1717

adb shell dumpsys window displays
adb shell wm size
