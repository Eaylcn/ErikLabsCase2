# Trendyol Mobil Test Otomasyonu

Bu proje, **Appium** ve **Cucumber** kullanarak **Trendyol** mobil uygulaması üzerinde test senaryolarının otomasyonu için geliştirilmiştir. **Page Object Model (POM)** kullanılarak daha temiz ve sürdürülebilir bir test yapısı oluşturulmuştur.

## Gereksinimler

- **Trendyol APK**: Testlerde kullanılan Trendyol uygulaması aşağıdaki bağlantıdan indirilebilir:
  - [Trendyol APK İndir](https://apkpure.com/tr/trendyol-online-alışveriş/trendyol.com)

- **Virtual Device (Android Emulator)**: 
  - **Android Studio** kullanarak bir Android emülatörü oluşturmanız gerekmektedir.
  
- **Appium Server**: 
  - Appium'u cihazla bağlantı kurmak ve testleri çalıştırmak için kullanıyoruz. Appium server'ı kurmak için:
    ```bash
    npm install -g appium
    appium
    ```

## Kurulum ve Çalıştırma

1. **APK Yükleme**:
   - APK dosyasını cihazınıza veya emülatöre yüklemek için şu komutu kullanın:
     ```bash
     adb install-multiple config.arm64_v8a.apk config.xxhdpi.apk trendyol.com.apk  
     ```

2. **Appium Sunucusu Başlatma**:
   - Appium'u yükledikten sonra, Appium sunucusunu başlatmak için aşağıdaki komutu çalıştırın:
     ```bash
     appium
     ```

3. **Emülatör/ Cihaz Ayarları**:
   - Android emülatörünüzü veya bağlı cihazınızı Appium ile eşleştirin ve test senaryolarını çalıştırın.

## Testlerin Çalıştırılması

- Testleri çalıştırmak için Maven kullanarak projenin kök dizininde şu komutu çalıştırın:
  ```bash
  mvn clean install
