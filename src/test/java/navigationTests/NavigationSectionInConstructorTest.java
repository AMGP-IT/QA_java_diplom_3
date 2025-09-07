package navigationTests;

import data.BaseTest;
import data.SectionsConstructor;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@DisplayName("Тест на переход по секциям в конструкторе бургера")
public class NavigationSectionInConstructorTest extends BaseTest {

    @Test
    @DisplayName("Тест на переход в секцию 'Соусы'")
    public void testNavigateToSaucesSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.SAUCES);
        assertTrue("Ожидалось, что кнопка 'Соусы' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.SAUCES));
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Тест на переход в секцию 'Начинки'")
    public void testNavigateToToppingsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        assertTrue("Ожидалось, что кнопка 'Начинки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.TOPPINGS));
    }

    @Test
    @DisplayName("Тест на переход в секцию 'Булки'")
    public void testNavigateToBunsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        constructorPage.clickButton(SectionsConstructor.BUNS);
        assertTrue("Ожидалось, что кнопка 'Булки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.BUNS));
    }
}
