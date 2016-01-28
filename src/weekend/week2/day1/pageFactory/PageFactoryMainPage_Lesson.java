package weekend.week2.day1.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryMainPage_Lesson {

    WebDriver driver;

    @FindBy(css = ".ellos.active")
    WebElement logoLink;

    @FindBy(css = "#showlogin>span")
    WebElement loginPageLink;

    @FindBy(css = "#ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername")
    WebElement loginField;

    @FindBy(css = "div#Content div.closeButton")
    WebElement buttonSpam;

    public PageFactoryMainPage_Lesson(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogoLink() {
        logoLink.click();
    }

    public void closeBlurb() {
        buttonSpam.click();
    }

    public void switchToLoginPage() {
        loginPageLink.click();

        if (loginField.isDisplayed()) {
            System.out.println("Switch to loginPage was CORRECT.");
        } else {
            System.out.println("Switch to loginPage was INCORRECT.");
        }

    }

}
