package navigation;

import data.BaseTest;
import data.SectionsConstructor;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@DisplayName("Тест на переход по секциям в конструкторе бургера")
public class NavigationSectionInConstructorTest extends BaseTest {

    @Test
    @DisplayName("Тест на переход в секцию 'Соусы'")
    @Description("Тест проверяет корректность перехода в секцию 'Соусы' в конструкторе. " +
            "Сценарий: " +
            "* Переход в конструктор " +
            "* Ожидание загрузки страницы " +
            "* Нажатие на кнопку 'Соусы' " +
            "Ожидаемые результаты: " +
            "* Кнопка 'Соусы' становится активной ")
    public void testNavigateToSaucesSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.SAUCES);
        assertTrue("Ожидалось, что кнопка 'Соусы' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.SAUCES));
    }

    @Test
    @DisplayName("Тест на переход в секцию 'Начинки'")
    @Description("Тест проверяет корректность перехода в секцию 'Начинки' в конструкторе. " +
            "Сценарий: " +
            "* Переход в конструктор " +
            "* Ожидание загрузки страницы " +
            "* Нажатие на кнопку 'Начинки' " +
            "Ожидаемые результаты: " +
            "* Кнопка 'Начинки' становится активной ")
    public void testNavigateToToppingsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        assertTrue("Ожидалось, что кнопка 'Начинки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.TOPPINGS));
    }

    @Test
    @DisplayName("Тест на переход в секцию 'Булки'")
    @Description("Тест проверяет корректность перехода в секцию 'Булки' в конструкторе. " +
            "Сценарий: " +
            "* Переход в конструктор " +
            "* Ожидание загрузки страницы " +
            "* Переход через секцию 'Начинки' " +
            "* Нажатие на кнопку 'Булки' " +
            "Ожидаемые результаты: " +
            "* Кнопка 'Булки' становится активной ")
    public void testNavigateToBunsSection(){
        headerPage.clickConstructorButton();

        constructorPage.waitLoadingRecoverPasswordPage();
        constructorPage.clickButton(SectionsConstructor.TOPPINGS);
        constructorPage.clickButton(SectionsConstructor.BUNS);
        assertTrue("Ожидалось, что кнопка 'Булки' будет активна", constructorPage.getStatusActiveButton(SectionsConstructor.BUNS));
    }
}
