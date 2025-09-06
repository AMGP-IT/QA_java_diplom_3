package navigationTests;

import data.BaseTest;
import data.SectionsConstructor;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class NavigationSectionInConstructorTest extends BaseTest {

    @Test
    public void testNavigateToSaucesSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.SAUCES);
        assertTrue("Ожидалось, что кнопка 'Соусы' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.SAUCES));
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testNavigateToToppingsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        assertTrue("Ожидалось, что кнопка 'Начинки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.TOPPINGS));
    }

    @Test
    public void testNavigateToBunsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        constructorPage.clickButton(SectionsConstructor.BUNS);
        assertTrue("Ожидалось, что кнопка 'Булки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.BUNS));
    }
}
