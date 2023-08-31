ABI=$(adb shell getprop ro.product.cpu.abi | tr -d '\r')

adb push libs/$ABI/minitouch /data/local/tmp/

adb shell /data/local/tmp/minitouch

adb forward tcp:1111 localabstract:minitouch

nc localhost 1111