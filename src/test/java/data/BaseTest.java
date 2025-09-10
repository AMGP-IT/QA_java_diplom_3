package data;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;


import static data.DataTest.URL;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HeaderPage headerPage;
    protected RegistrationPage registrationPage;
    protected MainPage mainPage;
    protected RecoverPasswordPage recoverPasswordPage;
    protected ConstructorPage constructorPage;

    @Before
    public void startUp(){
        String browser = "chrome";

        switch (browser) {
            case "chrome":
                startBrowserChrome();
                break;
            case "yandex":
                startBrowserYandex();
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
        }

        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        registrationPage = new RegistrationPage(driver);
        mainPage = new MainPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
        constructorPage = new ConstructorPage(driver);
        driver.get(URL);
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public void startBrowserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Yandex Driver\\yandexdriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
    }

    public void startBrowserChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
    }
}
