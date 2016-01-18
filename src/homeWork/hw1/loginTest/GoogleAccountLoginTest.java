package homeWork.hw1.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * write tests to login functional using WebElementsActions2 class
 */

public class GoogleAccountLoginTest {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        String url = "https://accounts.google.com";

        driver.get(url);

        driver.manage().window().maximize();

        String testedTitle = "Sign in - Google Accounts";

        String actualTitle = driver.getTitle();

        if (testedTitle.equals(actualTitle)) {
            System.out.println("Verification Successful - " +
                    "The correct title is displayed on the web page.");
        } else {
            System.out.println("Verification Failed - " +
                    "An incorrect title is displayed on the web page.");
        }

        // enter a valid username in the email textBox
        WebElement userName = driver.findElement(By.id("Email"));
        userName.clear();
        userName.sendKeys("TestSelenium1");

        WebElement clickButton = driver.findElement(By.id("next"));
        clickButton.click();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // enter a valid password in the password textbox
        WebElement password = driver.findElement(By.id("Passwd"));
        password.sendKeys("password123");

        // click on the Sign in button
        WebElement SignInButton = driver.findElement(By.id("signIn"));
        SignInButton.click();

        // close the web browser

        if (driver != null) {
            driver.close();
        }

        System.out.println("Test script executed successfully.");

        // terminate the program
        System.exit(0);

    }

}

