package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class TestScenariosPage {
    WebDriver driver;
    By registerForm = By.xpath("//a[contains(text(),'Register Form')]");
    Boolean verifyTitle;

    public TestScenariosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean TestScenariosPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Test Scenarios – Selenium WebDriver with C#");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Test Scenario Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void registerFormBtn_Click() {
        driver.findElement(registerForm).click();
    }
}
