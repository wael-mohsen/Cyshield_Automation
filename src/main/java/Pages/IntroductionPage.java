package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class IntroductionPage {
    WebDriver driver;
    By testScenarios = By.id("menu-item-58");
    Boolean verifyTitle;

    public IntroductionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean IntroductionPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Selenium WebDriver with C# – Learn how to write tests with Selenium in C#");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Introduction Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void testScenariosBtn_Click() {
        driver.findElement(testScenarios).click();
    }
}
