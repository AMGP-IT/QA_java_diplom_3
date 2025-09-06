package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage {
    private WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By logInLink = By.xpath(".//a[text()='Войти']");
    public static final By heading = By.xpath(".//h2[text()='Восстановление пароля']");

    public void clickLogInLink(){
        driver.findElement(logInLink).click();
    }

    public void waitLoadingRecoverPasswordPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }
}
