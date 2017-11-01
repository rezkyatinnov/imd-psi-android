# IMD Global Services - Android Developer Test

this is a test for IMD as Android Dev

## Requirement
Build an Android app to display the PSI index of (East, West, North, South and
Central) Singapore. Use the data from https://data.gov.sg/dataset/psi and display it on a Map.

## Features
all features are based on User Stories written on Test Doc

* retrieve today data from API
* display the data on map
* display 24hourly today data on chart

## Dependencies
This project built with kyandroid. an android library created by myself to help me develop app faster. all the repetition i've been doing in android app development will be reduce with this library. this library handle the http connection using retrofit, localdata and session management with realm and also ReactiveX ready. please check kyandroid github for more detail

 * [Kyandroid 1.0.0-RC8](https://github.com/rezkyatinnov/kyandroid) Android Project Kickstarter, featuring Retrofit as Http client, Realm as local data storage and RxJava for ReactiveX Observer
 * [MPAndroidChart 3.0.2](https://github.com/PhilJay/MPAndroidChart) Chart View Library
 * [SmartTabLayout 1.6.1](https://github.com/ogaclejapan/SmartTabLayout) Customized TabLayout
 * [Play Service Maps](https://developers.google.com/android/guides/setup) to show Map with psi data

## Run 

* clone the project

```
git clone https://github.com/rezkyatinnov/imd-psi-android.git
```

* open the project in Android Studio
* run the project via connected device or emulator

## Screen Captures
![Splash](https://github.com/rezkyatinnov/imd-psi-android/blob/master/screencaptures/splash.png)
![Maps](https://github.com/rezkyatinnov/imd-psi-android/blob/master/screencaptures/map.png)
![Map Marker Info](https://github.com/rezkyatinnov/imd-psi-android/blob/master/screencaptures/map_info.png)
![Chart](https://github.com/rezkyatinnov/imd-psi-android/blob/master/screencaptures/chart.png)