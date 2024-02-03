package Configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AndroidConfig {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability("platformName", "Android");
        Capabilities.setCapability("automationName", "uiautomator2");
        Capabilities.setCapability("deviceName", "Pixel_3a_API_34_extension_level_7_x86_64");
        Capabilities.setCapability("platformVersion", "14.0");
        Capabilities.setCapability("BROWSER_NAME", "chrome");

        URL url = new URL("https://testing.todorvachev.com/");

        AndroidDriver driver = new AndroidDriver(url, Capabilities);
        System.out.println("Application started");
    }
}