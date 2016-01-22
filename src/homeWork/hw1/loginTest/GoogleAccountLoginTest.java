package homeWork.hw1.loginTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * write tests to login functional using WebElementsActions2 class
 */

public class GoogleAccountLoginTest {

    private static final Logger log = Logger.getLogger(GoogleAccountLoginTest.class);

    private static void logDebug(String message) {

        if (log.isDebugEnabled()) {
            log.debug(message);
        } else {
            log.debug("debug is disabled");
        }

    }

    public static void main(String[] args) {

//        BasicConfigurator.configure();

/*        String path = System.getProperty("java.class.path");

        System.out.println(path);*/

        WebDriver driver = new FirefoxDriver();

        String url = "https://accounts.google.com";

        driver.get(url);

        log.info("driver get url:" + url);

        driver.manage().window().maximize();

        log.info("open browser. page source: " + driver.getPageSource());

        String testedTitle = "Sign in - Google Accounts";

        String actualTitle = driver.getTitle();

        if (testedTitle.equals(actualTitle)) {
            logDebug("Verification Successful - The correct title is displayed on the web page.");
//            System.out.println("Verification Successful - " +
//                    "The correct title is displayed on the web page.");
        } else {
            logDebug("Verification Failed - An incorrect title is displayed on the web page.");
//            System.out.println("Verification Failed - " +
//                    "An incorrect title is displayed on the web page.");
        }

        // enter a valid username in the email textBox
        WebElement userName = driver.findElement(By.id("Email"));
        userName.clear();
        String keyName = "alexace013@gmail.com";
        userName.sendKeys(keyName);
        log.info("web element " + userName + " send Keys: " + keyName);

        WebElement clickButton = driver.findElement(By.id("next"));
        clickButton.click();
        log.info("web element " + clickButton + " click");

        try {
            Thread.sleep(1000L);
            log.info("thread sleep");
        } catch (InterruptedException e) {
//            e.printStackTrace();
            log.error("InterruptedException", e);
        }

        // enter a valid password in the password textbox
        WebElement password = driver.findElement(By.id("Passwd"));
        String keyPass = "Alex19890714";
        password.sendKeys(keyPass);
        log.info("web element " + password + " send Keys: " + keyPass);

        // click on the Sign in button
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();
        log.info("web element " + signInButton + " click");

        // close the web browser

        if (driver != null) {
            driver.close();
            log.info("driver close");
        }

//        System.out.println("Example01 script executed successfully.");
        log.info("Example01 script executed successfully.");
        // terminate the program
        System.exit(0);

    }

}

