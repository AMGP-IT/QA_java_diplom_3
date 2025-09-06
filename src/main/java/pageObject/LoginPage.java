package pageObject;

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

    public void clickRegistrationLink(){
        driver.findElement(registrationLink).click();
    }
    public void clickRecoverPasswordLink(){
        driver.findElement(recoverPasswordLink).click();
    }

    public void waitLoadingLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    public WebElement getHeading(){
        return driver.findElement(heading);
    }

}
