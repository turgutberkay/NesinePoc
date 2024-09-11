package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverFactory {

    private static final ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized RemoteWebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static synchronized void setDriver(String udid, String systemPort) {
        // Emülatörün konumunu ayarla
        setEmulatorLocation(udid);
        // Konum ayarlandıktan sonra kısa bir bekleme süresi. Emulatorde kostugum ıcın emulatorun kendıne gelmesı gerek
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities;
        try {
            capabilities = getAndroidCaps(udid);
            AndroidDriver androidDriver = new AndroidDriver(new URL("http://0.0.0.0:" + systemPort +"/"), capabilities);
            driverThreadLocal.set(androidDriver);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        getDriver();
    }

    public static void clearDriver() {
        driverThreadLocal.remove();
    }

    public static DesiredCapabilities getAndroidCaps(String udid) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.pordiva.nesine.android");
        capabilities.setCapability("appActivity", "com.nesine.ui.taboutside.splash.SplashActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        return capabilities;
    }

    public static void setEmulatorLocation(String udid) {
        try {
            // Tüm cihazları listele
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String latitude = "41.0082"; // Ayarlamak istediğiniz enlem
            String longitude = "28.9784"; // Ayarlamak istediğiniz boylam

            while ((line = reader.readLine()) != null) {
                if (line.contains(udid)) {  // Belirtilen udid'e sahip emülatörü bul
                    String[] parts = line.split("\t");
                    String emulatorId = parts[0];  // emulator-5554 gibi kimlikleri alır

                    // ADB komutu ile hedef emülatör için lokasyonu ayarla
                    String command = String.format("adb -s %s emu geo fix %s %s", emulatorId, longitude, latitude);
                    Runtime.getRuntime().exec(command);
                    System.out.println("Location set for: " + emulatorId);
                    break;  // İlgili emülatörü bulduktan sonra döngüden çık
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
