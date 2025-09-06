package registrationTests;

import data.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static data.DataTest.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
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
