package WebAutomationTCs;

import Drivers.DriverInit;
import Data.JsonReader;
import Pages.IntroductionPage;
import Pages.RegisterFormPage;
import Pages.TestScenariosPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class ValidRegistration {
    JSONObject registrationData;
    DriverInit driver = new DriverInit();
    WebDriver webDriver;
    JsonReader jsonReader = new JsonReader();

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("Chrome")){
            webDriver = driver.initiateChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            webDriver = driver.initiateFirefoxDriver();
        }

        IntroductionPage introductionPage = new IntroductionPage(webDriver);
        while (!introductionPage.IntroductionPage_IsDisplayed()) {
            webDriver.manage().deleteAllCookies();
            webDriver.close();
            if(browser.equalsIgnoreCase("Chrome")){
                webDriver = driver.initiateChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                webDriver = driver.initiateFirefoxDriver();
            }
        }
    }

    @Feature("Valid Registration")
    @Description("Validate that the Page opened Successfully")
    @Test(priority = 1)
    public void testScenarios_click() {
        IntroductionPage introductionPage = new IntroductionPage(webDriver);
        introductionPage.testScenariosBtn_Click();
    }

    @Description("Click on Register Form Button")
    @Test(priority = 2)
    public void registerForm_click() {
        TestScenariosPage testScenariosPage = new TestScenariosPage(webDriver);
        while (!testScenariosPage.TestScenariosPage_IsDisplayed()) {
            webDriver.navigate().refresh();
        }
        testScenariosPage.registerFormBtn_Click();
    }

    @Description("Fill the Registration Form with Valid Data and Submit")
    @Test(priority = 3)
    public void fillRegistrationForm_ValidData() throws IOException, ParseException {
        RegisterFormPage registerFormPage = new RegisterFormPage(webDriver);
        while (!registerFormPage.RegisterFormPage_IsDisplayed()) {
            webDriver.manage().deleteAllCookies();
            webDriver.navigate().refresh();
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

    @Description("Quit the driver after the complete the registration")
    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }
}
