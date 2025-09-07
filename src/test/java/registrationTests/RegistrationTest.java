package registrationTests;

import data.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static data.DataTest.*;

@DisplayName("Тесты на регистрацию")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Позитивный тест на регистрацию")
    public void testRegistrationSuccess(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillFieldsAndClickButtonRegistration(FIRST_NAME, EMAIL, PASSWORD);

        loginPage.waitLoadingLoginPage();
    }
}
