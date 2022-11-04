# SToast 🌄

[![](https://jitpack.io/v/smith8h/SToast.svg)](https://jitpack.io/#smith8h/SToast)
[![Build Status](https://travis-ci.org/niltonvasques/simplecov-shields-badge.svg?branch=master)](https://travis-ci.org/niltonvasques/simplecov-shields-badge)
![stability-stable](https://img.shields.io/badge/stability-stable-green.svg)
![minimumSDK](https://img.shields.io/badge/minSDK-21-f39f37)
![minimumSDK](https://img.shields.io/badge/stable_version-2.0-blue)
<br>

Android custom toast with 2 types of toast:<br>
- [**Adaptive**](#Adaptive-SToast) that changes its theme with device dark/light mode<br>
- [**Mode**](#Mode-SToast) with 6 different modes.

<br>

# Setup 📲
> **Step 1.** Add the JitPack repository to your build file.</br>
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
> **Step 2.** Add the dependency:
```gradle
dependencies {
    implementation 'com.github.smith8h:SToast:2.0'
}
```

<br>

# Documentation 📃
### Adaptive SToast
> It's useful when you use it in direct alerts.

<p align="center">
<img src="https://te.legra.ph/file/3383a5c2ea7b770e257f1.jpg" style="width: 80%;"/>
</p>

Create new Adaptive SToast:
- `new SToast.Adaptive(context, SToast.SHORT)` the constructor accepts a context and duration.
You can use `SToast.LONG` for longer duration.
Available methods:
- `setIconAndColor(...)` accepting resource drawable/mipmap for icon, and int color (you can use **Color.NAME** or from resources **getColor(R.color.name)**).
- `setTitle("title")` to set the title of toast.
- `setText("some text")` to set the message for the user.
- `show()` to show the SToast.
<br>

> Full Code Example
```java
new SToast.Adaptive(this, SToast.LONG)
    .setIconAndColor(R.drawable.ok_img)
    .setTitle("All Ok!")
    .setText("Scanning process completed.")
    .show();
```

### Mode SToast
> It's useful when you use it to warn or notify the user about some actions.

<p align="center">
<img src="https://te.legra.ph/file/0b5e005fb10eda4125987.jpg" style="width: 80%;"/>
<br>This is DONE mode
</p>

Create new Mode SToast:
- `new SToast.Mode(context, SToast.SHORT)` the constructor accepts a context and duration.
You can use `SToast.LONG` for longer duration.
Available methods:
- `setMode(...)` to set the mode you can use **SToast.MODE_OK** or **MODE_DONE, MODE_WARN, MODE_ERROR, MODE_CONFUSE, MODE_INFO, MODE_HEART**).
- `setTitle("title")` to set the title of toast.
- `setText("some text")` to set the message for the user.
- `show()` to show the SToast.
<br>

> Full Code Example
```java
new SToast.Mode(this, SToast.LONG)
    .setMode(SToast.MODE_HEART)
    .setTitle("Big Love!")
    .setText("Thanks for your donation.")
    .show();
```

# Usable Resources 🗄
> You can use the drawable resources of this lib in your app!<br>
> `ok_img`, `true_img`, `false_img`, `warn_img`, `info_img`, `confuse_img`, `heart_img`

# Donations ❤
> **These projects needs you!** If you would like to support projects' further development, the creator of all these projects or the continuous maintenance of projects **feel free to donate**. Your donation is highly appreciated. Thank you!
<br/>

You can **choose what you want to donate**, all donations are awesome!</br>
<br/>
[![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.me/husseinshakir)
[![Buy me a coffee](https://img.shields.io/badge/Buy_Me_A_Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://www.buymeacoffee.com/HusseinShakir)
[![Ko-fi](https://img.shields.io/badge/Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/husseinsmith)
<br/>

<p align="center">
  <img src="https://raw.githubusercontent.com/smith8h/smith8h/main/20221103_150053.png" style="width: 38%;"/>
  <br><b>With :heart:</b>
</p>
