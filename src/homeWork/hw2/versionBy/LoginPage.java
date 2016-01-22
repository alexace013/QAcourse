package homeWork.hw2.versionBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static final String URL = "https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2f";

//    private static final String TITLE = "Mode & kläder online – köp dina kläder på nätet | Ellos";

    By loginLocator = By.xpath(".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername']");
    By passwordLocator1 = By.xpath(".//input[@id='LoginPasswordText']");
    By passwordLocator2 = By.xpath(".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginPassword']");
    By loginButton = By.xpath(".//a[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginButton']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, URL);
        this.driver = driver;

//        if (!URL.equals(driver.getCurrentUrl())) {
//            throw new IllegalStateException("This is not the login page");
//        }

    }

    public LoginPage typeLogin(String login) {
        driver.findElement(loginLocator).click();
        driver.findElement(loginLocator).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator1).click();
        driver.findElement(passwordLocator2).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButton).submit();
        return new HomePage(driver);
    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public HomePage loginAs(String login, String password) {
        typeLogin(login);
        typePassword(password);
        return submitLogin();
    }

    public void goToRegisterPage(String url) {
        driver.get(url);
    }

}
