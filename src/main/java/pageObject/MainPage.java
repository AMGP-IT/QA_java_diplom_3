package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By logInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }
}
