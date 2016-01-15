package homeWork.hw1.testSeleniumIDE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestRozetka {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRozetka() throws Exception {
        driver.get(baseUrl + "/webhp?hl=ru");
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=24984 | ]]
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("rozetka");
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=24984 | ]]
        driver.findElement(By.id("vs0p1")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=24984 | ]]
        driver.findElement(By.linkText("LED-телевизоры")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=sections | ]]
        driver.findElement(By.xpath("//ul[@id='sort_21667']/li[2]/label/a/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=sections | ]]
        driver.findElement(By.xpath("//ul[@id='sort_22730']/li/label/a/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=sections | ]]
        driver.findElement(By.cssSelector("img[alt=\"LG 49LF630V\"]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=all_tabs | ]]
        driver.findElement(By.cssSelector("#mkxn14b7gg5na > a.m5xhmcl52upn2")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=all_tabs | ]]
        driver.findElement(By.id("mlkiuc9xv4xsn")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=all_tabs | ]]
        driver.findElement(By.linkText("Характеристики")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
