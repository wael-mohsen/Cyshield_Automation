package WebAutomationTCs;

import Data.JsonReader;
import Drivers.ChromeDriverInit;
import Pages.IntroductionPage;
import Pages.RegisterFormPage;
import Pages.TestScenariosPage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvalidRegistration_InvalidEmail {
    JSONObject registrationData;
    ChromeDriverInit driver = new ChromeDriverInit();
    WebDriver chromeDriver = driver.initiateDriver();
    JsonReader jsonReader = new JsonReader();

    //Navigate to Test Scenarios Page
    @Test(priority = 1)
    public void testScenarios_click() {
        IntroductionPage introductionPage = new IntroductionPage(chromeDriver);
        while (!introductionPage.IntroductionPage_IsDisplayed()) {
            chromeDriver.navigate().refresh();
        }
        introductionPage.testScenariosBtn_Click();
    }

    //Navigate to Test Scenarios Page
    @Test(priority = 2)
    public void registerForm_click() {
        TestScenariosPage testScenariosPage = new TestScenariosPage(chromeDriver);
        while (!testScenariosPage.TestScenariosPage_IsDisplayed()) {
            chromeDriver.navigate().refresh();
        }
        testScenariosPage.registerFormBtn_Click();
    }

    //Fill the Registration Form
    @Test(priority = 3)
    public void fillRegistrationForm_InvalidEmail() throws IOException, ParseException {
        RegisterFormPage registerFormPage = new RegisterFormPage(chromeDriver);
        while (!registerFormPage.RegisterFormPage_IsDisplayed()) {
            chromeDriver.navigate().refresh();
        }
        registrationData = jsonReader.registrationData();
        registerFormPage.userId_Set((String) registrationData.get("userId"));
        registerFormPage.password_Set((String) registrationData.get("password"));
        registerFormPage.name_Set((String) registrationData.get("name"));
        registerFormPage.address_Set((String) registrationData.get("address"));
        registerFormPage.country_Set();
        registerFormPage.zipCode_Set((String) registrationData.get("zip"));
        registerFormPage.email_Set((String) registrationData.get("Invalidemail"));
        registerFormPage.sex_male_Set();
        registerFormPage.english_Set();
        registerFormPage.about_Set((String) registrationData.get("about"));
        registerFormPage.registerBtn_Click();
        String AlertMessage = registerFormPage.check_alert_displayed();
        Assert.assertEquals("You have entered an invalid email address!", AlertMessage);
    }

    //Close the driver after the complete the registration
    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
