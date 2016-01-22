package homeWork.hw2.versionBy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        System.out.println("Browser open.");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("start test");
    }

    @Test
    public void positiveLogin() {

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.closeReklama();
        homePage.clickLoginLink(".//a[@id='showlogin']");

//        loginPage.goToRegisterPage("https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2f");
        loginPage.loginAs("alex_ace@ukr.net", "a1989");
        loginPage.submitLoginExpectingFailure();

    }

    @After
    public void tearDown() {
        System.out.println("end test");
        driver.quit();
    }

}
