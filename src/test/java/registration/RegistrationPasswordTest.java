package registration;

import data.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static data.DataTest.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
@DisplayName("Тесты на регистрацию с невалидным паролем")
public class RegistrationPasswordTest extends BaseTest {
    private final String password;

    public RegistrationPasswordTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    @DisplayName("Набор тестовых данных для проверки валидации пароля")
    @Description("Предоставляет варианты паролей короче 6 символов для проверки их валидности при регистрации")
    public static Object[][] getTextData() {
        return new Object[][] {
                {"1"},
                {"1234"},
                {"12345"}
        };
    }

    @Test
    @DisplayName("Тест на проверку некорректного пароля при регистрации")
    @Description("Тест проверяет валидацию пароля короче 6 символов при регистрации пользователя. " +
            "Сценарий: " +
            "* Переход в личный кабинет " +
            "* Переход к форме регистрации " +
            "* Заполнение всех полей с некорректным паролем " +
            "* Попытка регистрации " +
            "Ожидаемые результаты: " +
            "* Отображение сообщения об ошибке " +
            "* Регистрация не должна быть успешной")
    public void testInvalidPassword() {
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillAllFields(FIRST_NAME, EMAIL, password);
        registrationPage.clickRegistrationButton();

        assertTrue("Пароль (" + password + ") должен быть недействительным", registrationPage.getErrorMessagePassword().isDisplayed());
    }
}
