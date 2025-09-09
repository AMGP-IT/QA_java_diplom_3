package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private final WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By personalCabinetButton = By.xpath(".//nav/a[@class='AppHeader_header__link__3D_hX']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    @Step("Нажать кнопку личный кабинет в шапке сайта")
    public void clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
    }
    @Step("Нажать конструктор в шапке сайта")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
}
