package registrationTests;

import data.BaseTest;
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
    public static Object[][] getTextData() {
        return new Object[][] {
                {"1"},
                {"1234"},
                {"12345"}
        };
    }

    @Test
    @DisplayName("Негативный тест на регистрацию")
    public void testValidPassword() {
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillAllFields(FIRST_NAME, EMAIL, password);
        registrationPage.clickRegistrationButton();


        assertTrue("Пароль (" + password + ") должен быть недействительным", registrationPage.getErrorMessagePassword().isDisplayed());
    }
}
