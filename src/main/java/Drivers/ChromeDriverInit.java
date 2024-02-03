package Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverInit {

    public WebDriver initiateDriver() {
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
}
