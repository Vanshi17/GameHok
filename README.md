# Android Project - GameHok

## Overview
This is the **GameHok** app, a gaming-focused Android application built using **Jetpack Compose** and **Retrofit** for API integration. The app provides users with an engaging home screen showcasing various games.

---

## Features Implemented ✅
- **Jetpack Compose UI**: Fully implemented using Jetpack Compose for a modern UI experience.
- **Retrofit for API Integration**: Used to fetch game data from a REST API.
- **Glide for Image Loading**: Efficient image loading using Landscapist-Glide.
- **Navigation Component**: Handles screen navigation within the app.
- **System UI Controller**: For customizing system bars and status bar appearance.
- **Home Screen Implemented**: Designed and developed only the home screen.

---

## Features Yet to be Implemented 🚧
- **Use Mock API** for testing and development.
- **Details Screen with Dummy Data** to enhance UI/UX.
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
[Download APK](#)

---

### Screenshots
<img src="https://github.com/user-attachments/assets/4a42bcd9-de78-4d39-ab4d-a514a22abc99" alt="Home Screen" width="200"/> 
<img src="https://github.com/user-attachments/assets/6a48434e-9173-4ceb-aeb2-cbc371e01282" alt="Home Screen" width="200"/> 
<img src="https://github.com/user-attachments/assets/9e2e0cd0-af5e-4fcc-b0fa-cdc0fcd1e437" alt="Home Screen" width="200"/> 
<img src="https://github.com/user-attachments/assets/337903ec-aa93-4e23-8e5b-fb7a2f23928b" alt="Home Screen" width="200"/> 
<img src="https://github.com/user-attachments/assets/924ae860-6023-42ea-906b-9d6371f813b6" width="200"/> 
<img src="https://github.com/user-attachments/assets/64fa209d-d698-4952-ba8d-a2c3e61660f0" alt="Home Screen" width="200"/> 

---

### Video Demo
<video src="https://github.com/user-attachments/assets/c394e26d-472a-437c-9d79-cffa996b6d4a" width="200" controls></video>

---

## How to Push to GitHub 🚀

### 1️⃣ Create a GitHub Repository
1. Go to [GitHub](https://github.com/) and create a new repository.
2. Copy the repository URL.

### 2️⃣ Initialize Git in Your Android Project
#### Using Android Studio
1. Open **VCS** > **Enable Version Control Integration**.
2. Select **Git** and click **OK**.
3. Go to **VCS** > **Commit** and commit your files.
4. Push the code to GitHub from **VCS** > **Git** > **Push**.

#### Using Terminal
```sh
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin <your-repository-URL>
git push -u origin main
```
Replace `<your-repository-URL>` with your GitHub repo link.

### 3️⃣ Push Future Updates
```sh
git add .
git commit -m "Updated feature XYZ"
git push origin main
```

---

## `.gitignore` Configuration 🚫
To prevent unnecessary files from being committed, include the following in your `.gitignore` file:

```
*.iml
.gradle
/local.properties
/.idea
/captures
/.cxx
.DS_Store
/build
/output.json
```

Now your project is ready for version control on GitHub! 🎉 Let me know if you need any further modifications. 😊
