# Android Project - GameHok

## Overview
This is the **GameHok** app, a gaming-focused Android application built using **Jetpack Compose** and **Retrofit** for API integration. The app provides users with an engaging home screen showcasing various games.

---

## Features Implemented ✅
- **Figma Design:** [View Figma Design](https://www.figma.com/design/lVh3pgtrOOgFewvSOlSg78/Assignment?node-id=0-1&p=f&t=HgsdVAZdgE3KipYr-0)
- **Jetpack Compose UI**: Fully implemented using Jetpack Compose for a modern UI experience.
- **Retrofit for API Integration**: Used to fetch game data from a REST API.
- **Glide for Image Loading**: Efficient image loading using Landscapist-Glide.
- **Navigation Component**: Handles screen navigation within the app.
- **API Integration**: Used the following API endpoints:
  - **Games List:** GET [https://67c9566f0acf98d07089d293.mockapi.io/games](https://67c9566f0acf98d07089d293.mockapi.io/games)
  - **Tournaments List:** GET [https://67c9566f0acf98d07089d293.mockapi.io/tournaments](https://67c9566f0acf98d07089d293.mockapi.io/tournaments)
    
---

## Features Yet to be Implemented 🚧
- **Details Screen with Dummy Data** using mock API.
- **Additional Details Screen for Games** for an expanded feature set.
- **Other Screens (besides Home Screen)** are yet to be designed and implemented.

---

## Dependencies 📦
Add the following dependencies in your `build.gradle`:

```kotlin
implementation("com.github.skydoves:landscapist-glide:2.2.9")
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.github.bumptech.glide:glide:4.15.1")
implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")
implementation("androidx.navigation:navigation-compose:2.7.4")
implementation("com.google.accompanist:accompanist-systemuicontroller:0.30.1")
```

---

## APK Download 📱
[Download APK](https://github.com/Vanshi17/GameHok/releases/download/v1/app-debug.apk)

---

### Screenshots 📸
<img src="https://github.com/user-attachments/assets/4a42bcd9-de78-4d39-ab4d-a514a22abc99" alt="Home Screen" width="200"/>
<img src="https://github.com/user-attachments/assets/6a48434e-9173-4ceb-aeb2-cbc371e01282" alt="Home Screen" width="200"/>
<img src="https://github.com/user-attachments/assets/9e2e0cd0-af5e-4fcc-b0fa-cdc0fcd1e437" alt="Home Screen" width="200"/>
<img src="https://github.com/user-attachments/assets/337903ec-aa93-4e23-8e5b-fb7a2f23928b" alt="Home Screen" width="200"/>
<img src="https://github.com/user-attachments/assets/924ae860-6023-42ea-906b-9d6371f813b6" width="200"/>
<img src="https://github.com/user-attachments/assets/64fa209d-d698-4952-ba8d-a2c3e61660f0" alt="Home Screen" width="200"/>

---

### Video Demo 🎥
<video src="https://github.com/user-attachments/assets/c394e26d-472a-437c-9d79-cffa996b6d4a" width="200" controls></video>

