# Grazer Code Test

## 📌 Project Overview
This is an Android app built with **Kotlin** using Jetpack Compose. It showcases a **simple authentication flow** and a **user list retrieval** using the Grazer API. The goal of this project is to demonstrate clean architecture, modularization, and best practices in Android development.

---
## 🏗️ Tech Stack & Libraries Used

- **Kotlin** - Main programming language
- **Jetpack Compose** - UI framework
- **Hilt** - Dependency Injection
- **Retrofit** - API networking
- **Jetpack Navigation** - Managing app navigation
- **Kotlin Coroutines & Flow** - Asynchronous programming
- **Compose Material 3** - UI Components
- **Data Store** - Secure token storage

---
## 🛠️ Architecture
The project follows **MVVM (Model-View-ViewModel)** architecture to ensure scalability and testability.

📂 **Project Structure:**
```
app/
├── data/        # API calls, repositories
├── domain/      # Use cases, business logic
├── presentation/ # UI Screens & ViewModels
└── navigation/  # App Navigation (NavHost)
```
---
## 📌 Possible Improvements
- ✅ Add Unit & UI Tests (JUnit, Espresso, Mockk)
- ✅ Add Room database for offline storage
- ✅ App modularization (WIP in corresponding branch)
