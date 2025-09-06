package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By nameField = By.xpath(".//label[text()='Имя']/../input");
    public static final By emailField = By.xpath(".//label[text()='Email']/../input");
    public static final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    public static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By heading = By.xpath(".//h2[text()='Регистрация']");
    public static final By logInLink = By.xpath(".//a[text()='Войти']");


    public void fillNameField(String text){
        driver.findElement(nameField).sendKeys(text);
    }

    public void fillEmailField(String text){
        driver.findElement(emailField).sendKeys(text);
    }

    public void fillPasswordField(String text){
        driver.findElement(passwordField).sendKeys(text);
    }

    public void fillAllFields(String name, String email, String password){
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    public void clickLogInLink(){
        driver.findElement(logInLink).click();
    }

    public void waitLoadingRegistrationPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    public void fillFieldsAndClickButtonRegistration(String name, String email, String password){
        fillAllFields(name, email, password);
        clickRegistrationButton();
    }

    public WebElement getHeading(){
        return driver.findElement(heading);
    }
}

