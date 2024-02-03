package Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverInit {

    public WebDriver initiateChromeDriver() {
        WebDriver driver;
        WebDriverManager.chromedriver().browserVersion("121.0.6167.139").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        driver = new ChromeDriver(options);
        driver.get("https://testing.todorvachev.com/");
        return driver;
    }

    public WebDriver initiateFirefoxDriver() {
        WebDriver driver;
        WebDriverManager.firefoxdriver().browserVersion("122.0").setup();
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("enable-automation");
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        driver = new FirefoxDriver(options);
        driver.get("https://testing.todorvachev.com/");
        return driver;
    }
}
