package registrationTests;

import data.BaseTest;
import org.junit.Test;

import static data.DataTest.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistrationSuccess(){
        headerPage.clickPersonalCabinetButton();

        loginPage.waitLoadingLoginPage();
        loginPage.clickRegistrationLink();

        registrationPage.waitLoadingRegistrationPage();
        registrationPage.fillFieldsAndClickButtonRegistration(FIRST_NAME, EMAIL, PASSWORD);

        loginPage.waitLoadingLoginPage();
    }
}
