package navigationTests;

import data.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class LogInUsingButtonsTest extends BaseTest {
    @Before
    public void setUp(){
        
    }

    @Test
    public void testLoginFromMainPage(){
        mainPage.clickLogInButton();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    public void testLoginFromProfileButton(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    public void testLoginFromRegistrationPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
    }

    @Test
    public void testLoginFromRecoverPasswordPage(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRecoverPasswordLink();

        recoverPasswordPage.waitLoadingRecoverPasswordPage();
        recoverPasswordPage.clickLogInLink();

        loginPage.waitLoadingLoginPage();
    }
}
