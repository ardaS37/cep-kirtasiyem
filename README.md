# Cep Kırtasiyem

An Android prototype for a stationery-directory experience. The application connects to a data source to retrieve and display stationery-related information.

## Technology

- Java
- Android SDK 34
- Minimum Android SDK 24 (Android 7.0)
- Gradle wrapper included

## Build

Open the project in Android Studio, or use the Gradle wrapper:

```bash
./gradlew assembleDebug
```

On Windows:

```bat
gradlew.bat assembleDebug
```

Build artifacts and local Android SDK settings are not tracked.

## Security

This public source snapshot contains no production database credentials, advertising identifiers, signing keys, or release artifacts. `ConnectionConfig` intentionally has an empty connection URL.

For production use, access data through an authenticated backend API. Do not embed database endpoints, usernames, passwords, or advertising credentials in an Android client or commit them to source control.
