package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By logInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    @Step("Нажать кнопку войти в аккаунт на главной странице")
    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }
}
