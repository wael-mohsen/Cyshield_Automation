package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterFormPage {
    WebDriver driver;
    By userId = By.xpath("//input[@name='userid']");
    By password = By.xpath("//input[@name='passid']");
    By name = By.xpath("//input[@name='username']");
    By address = By.xpath("//input[@name='address']");
    By country = By.xpath("//option[@value='AF']");
    By zipCode = By.xpath("//input[@name='zip']");
    By email = By.xpath("//input[@name='email']");
    By sex_male = By.xpath("//input[@value='Male']");
    By sex_female = By.xpath("//input[@value='Female']");
    By english = By.xpath("//input[@name='languageQuestion']");
    By about = By.id("desc");
    By register = By.xpath("//input[@name='submit']");
    Boolean verifyTitle;
    WebDriverWait wait;

    public RegisterFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean RegisterFormPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Register Form – Selenium WebDriver with C#");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Register Form Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void userId_Set(String UserID) {
        driver.findElement(userId).sendKeys(UserID);
    }

    public void password_Set(String Password) {
        driver.findElement(password).sendKeys(Password);
    }

    public void name_Set(String Name) {
        driver.findElement(name).sendKeys(Name);
    }

    public void address_Set(String Address) {
        driver.findElement(address).sendKeys(Address);
    }

    public void country_Set() {
        driver.findElement(country).click();
    }

    public void zipCode_Set(String ZipCode) {
        driver.findElement(zipCode).sendKeys(ZipCode);
    }

    public void email_Set(String Email) {
        driver.findElement(email).sendKeys(Email);
    }

    public void sex_male_Set() {
        driver.findElement(sex_male).click();
    }

    public void sex_female_Set() {
        driver.findElement(sex_female).click();
    }

    public void english_Set() {
        driver.findElement(english).click();
    }

    public void about_Set(String About) {
        driver.findElement(about).sendKeys(About);
    }

    public boolean isAlertPresent(){
        try{
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    public String check_alert_displayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String text = alert.getText();
        System.out.println("Alert Text : " + text );

        //Press the OK button
        alert.accept();
        return text;
    }

    public void registerBtn_Click() {
        driver.findElement(register).click();
    }
}
