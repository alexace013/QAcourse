package homeWork.hw3.jUnitTest.tests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFixture {

    protected final static Logger log = Logger.getLogger(BrowserFixture.class);
    protected final static String URL = "http://www.ellos.se/";
    protected final static String EMAIL = "alex_ace@ukr.net";
    protected final static String PASS = "a1989";
    protected static WebDriver driver;


    @BeforeClass
    public static void browserSetUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        log.info(String.format("BROWSER: [\"%s\"] open successful.", driver.getClass().getSimpleName()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void browserTearDown() {

        if (driver != null) {
            driver.quit();
        }

    }

}
