# Wear OS Watch App

A simple **Wear OS application built with Jetpack Compose**.

The project currently contains a Wear OS watch application with a modular structure. Each screen is separated into its own Kotlin file, making it easy to add or modify features.

## Features

The watch app currently has four main options:

*  **Location** — Displays the current location with high accuracy.
*  **Panic** — Shows a confirmation screen before opening the dialer to call 911.
*  **Notifications** — Displays a list of sample notifications.
*  **Calendar** — Opens the calendar with the current date as the default.



The project also contains an **Android mobile module**. It currently does not contain any application functionality and is available for developers who want to add a companion mobile application.

## Requirements

* Android Studio
* Android SDK
* Kotlin
* Jetpack Compose
* A Wear OS emulator or physical Wear OS watch

## How to Run

### 1. Clone the repository

```bash
git clone <repository-url>
```

Then open the project in **Android Studio**.

### 2. Sync the project

Allow Android Studio to download the required Gradle dependencies and finish the Gradle sync.

### 3. Select the Wear OS module

Choose the Wear OS application configuration from the Run configuration dropdown.

### 4. Run on a Wear OS device

You can use either:

* A Wear OS emulator
* A physical Wear OS watch connected through ADB

Then click **Run ▶** in Android Studio.

## Using the Project

There are two ways to use this repository.

### Option 1 — Standalone Wear OS Application

You can use the repository as a **standalone Wear OS project**.

You can modify the existing watch screens or add new functionality directly to the Wear OS module.
The mobile module is not required for the watch application.

### Option 2 — Add a Mobile Application

The repository also contains an Android mobile module.

The mobile module currently contains no application-specific functionality, so you can use it to build a companion Android application.

For example:

```text
                 Project
                    │
          ┌─────────┴─────────┐
          │                   │
       Wear OS             Android
        Module             Mobile
          │                   │
      Watch App          Phone App
          │                   │
          └───────┬───────────┘
                  │
           Shared functionality
             can be added
```

You can therefore develop:

* A standalone Wear OS application
* A mobile + Wear OS application
* Additional communication between the phone and watch
* Shared functionality between the two modules

## Current Status

* Create .apk  file for watch using assemblereelase command.
* Register the apk with MASON 
* MASON controller provides commands, go through it 
* Check version compatibility as I am using Material3 and as MAson may have custom android, it may work or not. Change library accordingly.