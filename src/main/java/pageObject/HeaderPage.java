package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private final WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By personalCabinetButton = By.xpath(".//nav/a[@class='AppHeader_header__link__3D_hX']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public void clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
}
