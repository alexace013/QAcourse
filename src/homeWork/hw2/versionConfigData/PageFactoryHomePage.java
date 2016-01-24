package homeWork.hw2.versionConfigData;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryHomePage {

    Logger log = Logger.getLogger(PageFactoryHomePage.class);

    @FindBy(css = ".ellos.active")
    WebElement logoLink;

    @FindBy(css = "#showlogin>span")
    WebElement loginPageLink;

    @FindBy(css = "#ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername")
    WebElement loginFieldInput;

    @FindBy(css = "div#Content div.closeButton")
    WebElement buttonSpam;

    @FindBy(css = "#showlogout")
    WebElement linkLogOut;

//    @FindBy(css = "logoLink")
//    WebElement logoLink;
//
//    @FindBy(xpath = "loginPageLink")
//    WebElement loginPageLink;
//
//    @FindBy(xpath = "loginFieldInput")
//    WebElement loginFieldInput;
//
//    @FindBy(xpath = "buttonSpam")
//    WebElement buttonSpam;

    private WebDriver driver;

    public PageFactoryHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogoLink() {
        logoLink.click();
        log.info(String.format("click on %s", logoLink));
    }

    public void closeBlurb() {
        buttonSpam.click();
        log.info(String.format("dead blurb %s", buttonSpam));
    }

    public void switchToLoginPage() {

        loginPageLink.click();
        log.info(String.format("%s click", loginPageLink));

        if (loginFieldInput.isDisplayed()) {
            log.info(String.format("Switch to loginPage was CORRECT."));
        } else {
            log.info(String.format("Switch to loginPage was INCORRECT."));
        }

    }

    public void logOut() {

        linkLogOut.click();
        log.info(String.format("click on Log Out"));
    }

}
