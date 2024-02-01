package WebAutomationTCs;

import Drivers.ChromeDriverInit;
import Data.JsonReader;
import Pages.IntroductionPage;
import Pages.RegisterFormPage;
import Pages.TestScenariosPage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

public class ValidRegistration {
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
    public void fillRegistrationForm_ValidData() throws IOException, ParseException {
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
        registerFormPage.email_Set((String) registrationData.get("email"));
        registerFormPage.sex_male_Set();
        registerFormPage.english_Set();
        registerFormPage.about_Set((String) registrationData.get("about"));
        registerFormPage.registerBtn_Click();
        registerFormPage.isAlertPresent();
    }

    //Close the driver after the complete the registration
    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
