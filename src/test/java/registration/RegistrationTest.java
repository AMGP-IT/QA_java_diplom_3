package registration;

import data.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static data.DataTest.*;
import static org.junit.Assert.assertTrue;

@DisplayName("Тесты на регистрацию")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Позитивный тест на регистрацию")
    @Description("Тест проверяет успешную регистрацию нового пользователя. " +
            "Сценарий: " +
            "* Переход в личный кабинет " +
            "* Переход к форме регистрации " +
            "* Заполнение всех обязательных полей корректными данными " +
            "* Отправка формы регистрации " +
            "* Проверка успешного завершения регистрации " +
            "Ожидаемые результаты: " +
            "* Успешное создание учетной записи " +
            "* Корректное перенаправление на страницу входа " +
            "* Отсутствие сообщений об ошибках " +
            "* Пользователь может успешно авторизоваться с указанными данными")
    public void testRegistrationSuccess(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillFieldsAndClickButtonRegistration(FIRST_NAME, EMAIL, PASSWORD);

        loginPage.waitLoadingLoginPage();
        assertTrue("Должен отображаться заголовок страницы авторизации", loginPage.getHeading().isDisplayed());
    }
}
