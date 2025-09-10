package navigation;

import data.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static data.DataTest.*;
import static org.junit.Assert.assertTrue;
import static steps.UserSteps.createUser;
import static steps.UserSteps.deleteUser;

@DisplayName("Тесты на переход на страницу авторизации, будучи неавторизованным")
public class LogInUsingButtonsTest extends BaseTest {
    UserModel userModel;

    @Before
    public void setUp(){
        userModel = new UserModel(EMAIL, PASSWORD, FIRST_NAME);
        createUser(userModel);
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти в аккаунт'")
    @Description("Тест проверяет корректность работы кнопки 'Войти в аккаунт' на главной странице. " +
            "Сценарий: " +
            "* Нажатие на кнопку 'Войти в аккаунт' " +
            "* Ожидание загрузки страницы авторизации " +
            "* Заполнение полей email и password " +
            "* Нажатие кнопки регистрации " +
            "Ожидаемые результаты: " +
            "* Успешная загрузка главной страницы после авторизации " +
            "* Отображение заголовка страницы ")
    public void testLoginFromMainPage(){
        mainPage.clickLogInButton();

        loginPage.waitLoadingLoginPage();
        loginPage.fillFieldsAndClickButtonRegistration(EMAIL, PASSWORD);

        mainPage.waitLoadingRegistrationPage();
        assertTrue("Должен отображаться заголовок страницы", mainPage.getHeading().isDisplayed());
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Личный кабинет'")
    @Description("Тест проверяет корректность работы кнопки 'Личный кабинет' в шапке сайта. " +
            "Сценарий: " +
            "* Нажатие на кнопку 'Личный кабинет' " +
            "* Ожидание загрузки страницы авторизации " +
            "* Заполнение полей email и password " +
            "* Нажатие кнопки регистрации " +
            "Ожидаемые результаты: " +
            "* Успешная загрузка главной страницы после авторизации " +
            "* Отображение заголовка страницы ")
    public void testLoginFromProfileButton(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.fillFieldsAndClickButtonRegistration(EMAIL, PASSWORD);

        mainPage.waitLoadingRegistrationPage();
        assertTrue("Должен отображаться заголовок страницы", mainPage.getHeading().isDisplayed());
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти' в форме регистрации")
    @Description("Тест проверяет корректность работы кнопки 'Войти' на странице регистрации. " +
            "Сценарий: " +
            "* Переход на страницу авторизации через кнопку личного кабинета " +
            "* Переход на страницу регистрации " +
            "* Нажатие на ссылку 'Войти' " +
            "* Заполнение полей email и password " +
            "* Нажатие кнопки регистрации " +
            "Ожидаемые результаты: " +
            "* Успешная загрузка главной страницы после авторизации " +
            "* Отображение заголовка страницы ")
    public void testLoginFromRegistrationPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
        loginPage.fillFieldsAndClickButtonRegistration(EMAIL, PASSWORD);

        mainPage.waitLoadingRegistrationPage();
        assertTrue("Должен отображаться заголовок страницы", mainPage.getHeading().isDisplayed());
    }

    @Test
    @DisplayName("Тест на переход по кнопке 'Войти' в форме восстановления пароля")
    @Description("Тест проверяет корректность работы кнопки 'Войти' на странице восстановления пароля. " +
            "Сценарий: " +
            "* Переход на страницу авторизации через кнопку личного кабинета " +
            "* Переход на страницу восстановления пароля " +
            "* Нажатие на ссылку 'Войти' " +
            "* Заполнение полей email и password " +
            "* Нажатие кнопки регистрации " +
            "Ожидаемые результаты: " +
            "* Успешная загрузка главной страницы после авторизации " +
            "* Отображение заголовка страницы ")
    public void testLoginFromRecoverPasswordPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRecoverPasswordLink();

        recoverPasswordPage.waitLoadingRecoverPasswordPage();
        recoverPasswordPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
        loginPage.fillFieldsAndClickButtonRegistration(EMAIL, PASSWORD);

        mainPage.waitLoadingRegistrationPage();
        assertTrue("Должен отображаться заголовок страницы", mainPage.getHeading().isDisplayed());
    }

    @After
    public void cleanUp(){
        if (userModel != null){
            deleteUser(userModel);
        }
    }
}
