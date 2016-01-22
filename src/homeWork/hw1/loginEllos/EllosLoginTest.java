package homeWork.hw1.loginEllos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EllosLoginTest {

    private WebDriver driver;
    private EllosMainPage mainPage;
    private EllosLoginPage loginPage;

    @Before
    public void setUp() throws IOException {
        driver = new FirefoxDriver();
        System.out.println("Browser open successful.");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("Start test. . .");
    }

    @Test
    public void positiveLogin() {
        mainPage = new EllosMainPage(driver);
        loginPage = new EllosLoginPage(driver);
        mainPage.clickLogo();
        mainPage.switchToLoginPage();
        loginPage.fillEmailField("alex_ace@ukr.net");
        loginPage.fillPasswordField("a1989");
        loginPage.pressLoginButton();
    }

//    @Example01
//    public void negativeLogin() throws IOException {
//
//        mainPage = new EllosMainPage(driver);
//        loginPage = new EllosLoginPage(driver);
//
//        mainPage.clickLogo();
//        mainPage.switchToLoginPage();
//
//        loginPage.fillLoginField("qwerty@ukr.net");
//        loginPage.fillPasswordField("12345");
//
//        loginPage.pressLoginButton();
//
//        Assert.assertTrue("Incorrect login to the system with fake log/pass",
//                loginPage.checkErrorShown("ErrorMess"));
//
//    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End test.");
    }

}
