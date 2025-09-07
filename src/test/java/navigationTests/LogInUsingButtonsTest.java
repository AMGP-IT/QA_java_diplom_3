package navigationTests;

import data.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Тесты на переход на страницу авторизации, будучи неавторизованным")
public class LogInUsingButtonsTest extends BaseTest {

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти в аккаунт'")
    public void testLoginFromMainPage(){
        mainPage.clickLogInButton();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Личный кабинет'")
    public void testLoginFromProfileButton(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти' в форме регистрации")
    public void testLoginFromRegistrationPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти' в форме восстановления пароля")
    public void testLoginFromRecoverPasswordPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRecoverPasswordLink();

        recoverPasswordPage.waitLoadingRecoverPasswordPage();
        recoverPasswordPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
    }
}
