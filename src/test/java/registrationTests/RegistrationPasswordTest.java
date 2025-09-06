package registrationTests;

import data.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.DataTest.*;
import static org.junit.Assert.assertFalse;
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
                {""},
                {"1234"},
                {"12345"},
                {"123456"},
                {"1234567"},
                {"12345678"},
        };
    }

    @Test
    public void testInvalidPassword() {
        boolean result = true;
        boolean isPasswordValid = false;
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillAllFields(FIRST_NAME, EMAIL, password);
        registrationPage.clickRegistrationButton();

        new WebDriverWait(driver, Duration.ofSeconds(2));
        if (validatePassword(password)){
            isPasswordValid = true;
        }
        if (loginPage.getHeading().isDisplayed()) {
            result = false;
        }

        if (isPasswordValid) {
            assertFalse("Пароль (" + password + ") должен быть недействительным", result);
        } else {
            assertTrue("Пароль (" + password + ") должен быть недействительным", result);
        }
    }

    private boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }
}
