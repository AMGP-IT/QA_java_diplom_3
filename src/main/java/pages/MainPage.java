package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By logInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By heading = By.xpath(".//h1[text()='Соберите бургер']");

    @Step("Нажать кнопку войти в аккаунт на главной странице")
    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }

    @Step("Получить веб-элемент заголовка главной страницы")
    public WebElement getHeading(){
        return driver.findElement(heading);
    }

    @Step("Подождать появления заголовка главной страницы")
    public void waitLoadingRegistrationPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }
}
