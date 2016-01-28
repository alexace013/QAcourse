package homeWork.hw3.jUnitTest.tests;

import homeWork.hw3.jUnitTest.pages.HomePage;
import homeWork.hw3.jUnitTest.pages.RegistrationPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class LogInAndRegFixture extends BrowserFixture {

    protected static HomePage homePage;
    protected static RegistrationPage registrationPage;

    @BeforeClass
    public static void setUp() {

        driver.get(URL);
        log.info(String.format("\nstart test.\n"));

        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @AfterClass
    public static void tearDown() {
        log.info(String.format("end test."));
    }

}
