package data;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

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
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        } else {
            System.out.println("Такой браузер ещё не поддерживается :(");
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
        driver.quit();
    }

    public void startBrowserYandex() {

    }

    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
}
