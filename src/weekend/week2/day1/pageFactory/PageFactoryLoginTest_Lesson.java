package weekend.week2.day1.pageFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageFactoryLoginTest_Lesson {

    private static String EMAIL = "alex_ace@ukr.net";
    private static String PASSWORD = "a1989";

    WebDriver driver;
    PageFactoryMainPage_Lesson pageFactoryMainPage;
    PageFactoryLoginPage_Lesson pageFactoryLoginPage;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("Browser open successful.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("Start test...");

    }

    @Test
    public void testMethod1() throws IOException {

        pageFactoryMainPage = new PageFactoryMainPage_Lesson(driver);
        pageFactoryMainPage.closeBlurb();
        pageFactoryMainPage.clickLogoLink();
        pageFactoryMainPage.switchToLoginPage();

        pageFactoryLoginPage = new PageFactoryLoginPage_Lesson(driver);
        pageFactoryLoginPage.fillEmailFiled(EMAIL);
        pageFactoryLoginPage.fillPassFiled(PASSWORD);
        pageFactoryLoginPage.clickLoginButton();

        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @After
    public void tearDown() {
        System.out.println("end test.");
        driver.quit();
    }

}
