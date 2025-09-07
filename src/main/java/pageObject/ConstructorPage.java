package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import data.SectionsConstructor;

public class ConstructorPage {
    private final WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public static final By heading = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By bunsButton = By.xpath(".//span[text()='Булки']");
    public static final By saucesButton = By.xpath(".//span[text()='Соусы']");
    public static final By toppingsButton = By.xpath(".//span[text()='Начинки']");
    public static final By statusActiveSaucesButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    public static final By statusActiveBunsButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    public static final By statusActiveToppingsButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public void waitLoadingRecoverPasswordPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(heading));
    }

    @Step("Нажать кнопку выбора секции в конструкторе бургера")
    public void clickButton(SectionsConstructor button){
        switch (button){
            case BUNS:
                driver.findElement(bunsButton).click();
                break;
            case SAUCES:
                driver.findElement(saucesButton).click();
                break;
            case TOPPINGS:
                driver.findElement(toppingsButton).click();
                break;
            default:
                throw new IllegalArgumentException("Обращение к неизвестной кнопке: " + button);
        }
    }

    @Step("Получить статус кнопки секции в конструкторе бургера")
    public Boolean getStatusActiveButton(SectionsConstructor button) {
        switch (button) {
            case BUNS:
                return driver.findElement(statusActiveBunsButton).isDisplayed();
            case SAUCES:
                return driver.findElement(statusActiveSaucesButton).isDisplayed();
            case TOPPINGS:
                return driver.findElement(statusActiveToppingsButton).isDisplayed();
            default:
                throw new IllegalArgumentException("Обращение к неизвестной кнопке: " + button);
        }
    }
}
