package homeWork.hw3.jUnitTest.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.WebElementsActions;

public class RegistrationPage {

    private final static Logger log = Logger.getLogger("log4j.rootLogger");
    private WebDriver driver;
    private WebElementsActions web;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickAndInputLoginField(String login) {
        web.click("loginFieldInput");
        clearLoginField();
        web.input("loginFieldInput", login);
    }

    public boolean isUserLogIn() {
        return web.isElementPresent("logInLink");
    }

    public boolean isUserLogOut() {
        return web.isElementPresent("logOutLink");
    }

    public void clickAndInputLoginFieldAndClickTAB(String login) {
        web.click("loginFieldInput");
        clearLoginField();
        web.input("loginFieldInput", login);
        web.clickTAB("loginFieldInput");
    }

    public void clickAndInputPassFieldOne(String pass) {
        web.click("passFieldInput2");
        clearPassField();
        web.input("passFieldInput2", pass);
    }

    public void clickAndInputPassFieldAll(String pass) {
        web.click("passFieldInput1");
        clearPassField();
        web.input("passFieldInput2", pass);
    }

    public void inputPassField(String pass) {
        clearPassField();
        web.input("passFieldInput2", pass);
    }

    private void clickTAB_onLoginField() {
        web.clickTAB("loginFieldInput");
    }

    public void clickButtonLogIn() {
        web.click("loginButton");
    }

    public void clickLogText() {
        web.click("loginTextLink");
    }

    public void closeHelpBox() {
        web.click("closeHelpBox");
    }

    public boolean isErrorMessageNotEmptyFields() {
        return web.isElementPresent("errorMessage");
    }

    public boolean isErrorMessageEmptyFields() {
        return web.isElementPresent("errorMessageEmptyFields");
    }

    public boolean isErrorMessageOneFiledEmpty() {
        return web.isElementPresent("errorMessageOneFieldEmpty");
    }

    public boolean isHelpBoxActive() {
        return web.isElementPresent("closeHelpBox");
    }

    public boolean isHelpBoxPresent() {

        return web.waitForElementPresent("closeHelpBox");

    }

    private void clearLoginField() {
        web.clear("loginFieldInput");
    }

    private void clearPassField() {
        web.clear("passFieldInput2");
    }

}
