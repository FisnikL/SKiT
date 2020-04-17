import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("fisnikl", "FisnikL123");
        assertTrue(new DashboardPage(driver).isLoaded());
    }

    @Test
    public void cannotLoginWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("fisnikl", "FisnikL");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Userid or Password did Not Match !!");
    }

    @Test
    public void cannotLoginWithInvalidUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("fisnik", "FisnikL123");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Userid or Password did Not Match !!");
    }

    @Test
    public void cannotLoginWithEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("", "FisnikL123");
        String errorMessage = loginPage.getErrorFromEmptyUsername();

        assertEquals("*", errorMessage);
    }

    @Test
    public void cannotLoginWithEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("fisnikl", "");
        String errorMessage = loginPage.getErrorFromEmptyPassword();
        assertEquals(errorMessage, "*");
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.forgotPassword();

        assertTrue(new ForgotPasswordPage(driver).isLoaded());
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
http://www.testyou.in/Login.aspx
