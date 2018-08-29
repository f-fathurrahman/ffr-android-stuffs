
```
adb shell logcat | grep -i Lifecycle
```

Lifecycle is the string `tag` we specify in `the MainActivity.java`.

Clear buffer of logcat

```
adb logcat -c
```