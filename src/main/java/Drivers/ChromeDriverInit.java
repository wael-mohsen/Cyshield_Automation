package Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverInit {

    public WebDriver initiateDriver() {
//        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", chromePath);
//        ChromeDriver driver = new ChromeDriver();
//        Dimension d = new Dimension(1024,768);
//        driver.manage().window().setSize(d);
//        driver.get("http://automationpractice.com/index.php");
//        //driver.quit();

        WebDriver driver = null;
        WebDriverManager.chromedriver().browserVersion("121.0.6167.139").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        driver = new ChromeDriver(options);
        driver.get("https://testing.todorvachev.com/");
        return driver;
    }
}
