package weekend.week2.day1.productPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTests_Lesson {

    MainPage_Lesson mainPage;
    LoginPage_Lesson loginPage;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        System.out.println("Browser open successful");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//magic
        driver.get("http://www.ellos.se/");
        System.out.println("Start test");

    }

    @Test
    public void negativeLogin() throws Exception {
        mainPage = new MainPage_Lesson(driver);
        loginPage = new LoginPage_Lesson(driver);

        mainPage.clickLogo();
        mainPage.switchToLoginPage();

        loginPage.fillLoginField();
        loginPage.fillPasswordField();

        loginPage.pressLoginButton();

        Assert.assertTrue("Incorrect login to the system with fake log/pass", loginPage.checkErrorShown("ErrorMess"));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End test");
        driver.quit();
    }

}
