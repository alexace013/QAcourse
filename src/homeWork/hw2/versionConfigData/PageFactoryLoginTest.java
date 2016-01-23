package homeWork.hw2.versionConfigData;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageFactoryLoginTest {

    Logger log = Logger.getLogger(PageFactoryLoginTest.class);

    private static String EMAIL = "alex_ace@ukr.net";
    private static String PASSWORD = "a1989";
    private static String URL = "http://www.ellos.se/";

    WebDriver driver;

    PageFactoryHomePage pageFactoryHomePage;
    PageFactoryLoginPage pageFactoryLoginPage;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        log.info(String.format("browser %s open successful.", driver.getClass().getName()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        log.info(String.format("start test."));

    }

    @Test
    public void testMethod1() throws IOException {

        pageFactoryHomePage = new PageFactoryHomePage(driver);
        pageFactoryHomePage.closeBlurb();
        pageFactoryHomePage.clickLogoLink();
        pageFactoryHomePage.switchToLoginPage();

        pageFactoryLoginPage = new PageFactoryLoginPage(driver);
        pageFactoryLoginPage.fillEmailFiled(EMAIL);
        pageFactoryLoginPage.fillPassFiled(PASSWORD);
        pageFactoryLoginPage.clickLoginButton();

        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @After
    public void tearDown() {
        log.info(String.format("end test."));
        driver.quit();
    }

}
