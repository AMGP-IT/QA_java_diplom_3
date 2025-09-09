package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");
    public static final By recoverPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");
    public static final By heading = By.xpath(".//h2[text()='Вход']");
    public static final By emailField = By.xpath(".//label[text()='Email']/../input");
    public static final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    public static final By logInButton = By.xpath(".//button[text()='Войти']");

    @Step("Нажать на ссылку страницы регистрации")
    public void clickRegistrationLink(){
        driver.findElement(registrationLink).click();
    }
    @Step("Нажать на ссылку страницы восстановления пароля")
    public void clickRecoverPasswordLink(){
        driver.findElement(recoverPasswordLink).click();
    }

    @Step("Заполнить поле email")
    public void fillEmailField(String text){
        driver.findElement(emailField).sendKeys(text);
    }

    @Step("Заполнить поле пароль")
    public void fillPasswordField(String text){
        driver.findElement(passwordField).sendKeys(text);
    }

    @Step("Нажать кнопку авторизации")
    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }

    @Step("Заполнить все поля")
    public void fillAllFields(String email, String password){
        fillEmailField(email);
        fillPasswordField(password);
    }

    @Step("Заполнить поля и нажать кнопку авторизации")
    public void fillFieldsAndClickButtonRegistration(String email, String password){
        fillAllFields(email, password);
        clickLogInButton();
    }

    @Step("Подождать появления заголовка страницы авторизации")
    public void waitLoadingLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    public WebElement getHeading(){
        return driver.findElement(heading);
    }

}
