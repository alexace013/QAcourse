package homeWork.hw2.versionConfigData;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageFactoryLoginTest {

    static Logger log = Logger.getLogger(PageFactoryLoginTest.class);

    private static String EMAIL = "alex_ace@ukr.net";
    private static String PASSWORD = "a1989";
    private static String URL = "http://www.ellos.se/";

    private static WebDriver driver;

    static PageFactoryHomePage pageFactoryHomePage;
    static PageFactoryLoginPage pageFactoryLoginPage;

    @BeforeClass
    public static void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        log.info(String.format("BROWSER: [\"%s\"] open successful.", driver.getClass().getCanonicalName()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        log.info(String.format("\nstart test...\n"));
        pageFactoryHomePage = new PageFactoryHomePage(driver);
        pageFactoryLoginPage = new PageFactoryLoginPage(driver);

    }

    @Test
    public void positiveTest() throws IOException {

        pageFactoryHomePage.closeBlurb();
        pageFactoryHomePage.clickLogoLink();
        pageFactoryHomePage.switchToLoginPage();

        pageFactoryLoginPage.fillEmailFiled(EMAIL);
        pageFactoryLoginPage.fillPassFiled(PASSWORD);
        pageFactoryLoginPage.clickLoginButton();

        pageFactoryHomePage.logOut();

        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @Test
    public void testNegative0() throws IOException {

        pageFactoryHomePage.clickLogoLink();
        log.info(String.format("click logo\n"));
        pageFactoryHomePage.switchToLoginPage();
        log.info(String.format("switch to login page\n"));
        pageFactoryLoginPage.fillEmailFiled("." + EMAIL);
        log.info(String.format("input email: %s\n", EMAIL));
        pageFactoryLoginPage.fillPassFiled(PASSWORD);
        log.info(String.format("input pass: %s\n", PASSWORD));
        pageFactoryLoginPage.clickLoginButton();
        log.info(String.format("click on login button"));

        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @Test
    public void testNegative1() {

        pageFactoryLoginPage.fillEmailFiled("@" + EMAIL);
        pageFactoryLoginPage.fillPassFiled("");
        pageFactoryLoginPage.clickLoginButton();


        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @Test
    public void testNegative2() {

        pageFactoryLoginPage.fillEmailFiled("");
        pageFactoryLoginPage.fillPassFiled("pass");
        pageFactoryLoginPage.clickLoginButton();


        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @Test
    public void testNegative3() {

        pageFactoryLoginPage.fillEmailFiled("/");
        pageFactoryLoginPage.fillPassFiled2("");
        pageFactoryLoginPage.clickLoginButton();


        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @Test
    public void testNegative4() {

        pageFactoryLoginPage.fillEmailFiled("_");
        pageFactoryLoginPage.fillPassFiled("pass");
        pageFactoryLoginPage.clickLoginButton();


        if (pageFactoryLoginPage.isErrorMessage()) {
            Assert.assertTrue("error is NOT present.", pageFactoryLoginPage.isErrorMessage());
        }

    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        log.info(String.format("end test."));
    }

}
