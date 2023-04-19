# SToast 🌄

[![](https://jitpack.io/v/smith8h/SToast.svg)](https://jitpack.io/#smith8h/SToast)
[![Build Status](https://travis-ci.org/niltonvasques/simplecov-shields-badge.svg?branch=master)](https://travis-ci.org/niltonvasques/simplecov-shields-badge)
![stability-stable](https://img.shields.io/badge/stability-stable-green.svg)
![minimumSDK](https://img.shields.io/badge/minSDK-21-f39f37)
![stable version](https://img.shields.io/badge/stable_version-2.0-blue)
![Repository size](https://img.shields.io/github/repo-size/smith8h/stoast)
<br>

Android custom toast with 2 types of toast
<br/>

**Content**
- [**Setup 📲**](#setup-)
- [**Documentation 📃**](#documentation-)
  - [**Adaptive**](#Adaptive-SToast) that changes its theme with device dark/light mode<br>
  - [**Mode**](#Mode-SToast) with 6 different modes.
- [**Usable Resources 🗄**](#usable-resources-)
- [**Donations :heart:**](#donations-)
<br/>

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
    implementation 'com.github.smith8h:SToast:2.5'
}
```

<br/>

# Documentation 📃
### Adaptive SToast
> It's useful when you use it in direct alerts.

<p align="center">
<img src="https://te.legra.ph/file/3383a5c2ea7b770e257f1.jpg" style="width: 80%;"/>
</p>

Create Adaptive SToast:
- `AdaptiveSToast.with(context)` pass a context.
- `.duration(AdaptiveSToast.LENGTH_LONG)` or `LENGTH_SHORT` (Optional | Default is short).
- `.icon(iconIntRes, colorInt)` **int resource drawable** for icon, and **int|String color** for icon color (Optional).
- `.title("title")` to set the title of toast.
- `.text("some text")` to set the message for the user.
- `.show()` to show the SToast.

Final code:
```java
AdaptiveSToast.with(this)
    .title("title")
    .text("text")
    
    /* for customization
    .icon(R.drawable.icon, getColor(R.color.color)) // or ↓
    OR .icon(R.drawable.icon, "hex color")
    .duration(AdaptiveSToast.LENGTH_LONG)
    */
    
    .show();
```

### Mode SToast
> It's useful when you use it to warn or notify the user about some actions.

<p align="center">
<img src="https://te.legra.ph/file/0b5e005fb10eda4125987.jpg" style="width: 80%;"/>
<br/>
This is DONE mode
</p>

Create new Mode SToast:
- `ModeSToast.with(context)` pass a context.
- `.mode(...)` to set the mode you can use **ModeSToast.MODE_OK**, **MODE_DONE**, **MODE_WARN**,- **MODE_ERROR**, **MODE_CONFUSE**, **MODE_INFO**, **MODE_HEART**
- `.duration(ModeSToast.LENGTH_LONG)` or `LENGTH_SHORT` (Optional | Default is short).
- `.title("title")` to set the title of toast.
- `.text("some text")` to set the message for the user.
- `show()` to show the SToast.

<br/>

Final Code:
```java
ModeSToast(this)
    .mode(ModeSToast.MODE_HEART)
    .title("Big Love!")
    .text("Thanks for your donation.")
    .show();
```

# Usable Resources 🗄
You can use the drawables of this lib in your app!<br>
import smith.lib.alerts.toast.R and use them 
`ok_img`, `true_img`, `false_img`, `warn_img`, `info_img`, `confuse_img`, `heart_img`
<br/>

# Donations ❤
> If you would like to support this project's further development, the creator of this projects or the continuous maintenance of the project **feel free to donate**.
Your donation is highly appreciated. Thank you!
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
