package homeWork.hw2.versionConfigData;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryHomePage {

    Logger log = Logger.getLogger(PageFactoryHomePage.class);

    @FindBy(css = "logoLink")
    WebElement logoLink;

    @FindBy(xpath = "loginPageLink")
    WebElement loginPageLink;

    @FindBy(xpath = "loginFieldInput")
    WebElement loginFieldInput;

    @FindBy(xpath = "buttonSpam")
    WebElement buttonSpam;

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

}
