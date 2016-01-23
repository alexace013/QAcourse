package homeWork.hw1.loginEllos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.web._WebElementsActions;

import java.io.IOException;

public class EllosMainPage {

    WebDriver driver;
    _WebElementsActions web;
    Logger log = Logger.getLogger(EllosMainPage.class);

    public EllosMainPage(WebDriver driver) {
        this.driver = driver;
        web = new _WebElementsActions(driver);
    }

    public void clickLogo() {

        try {
            web.clickLink("Logo");
            log.info("click on logo link");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchToLoginPage() {

        try {
            web.clickLink("LoginLink");
            log.info("click on LoginLink");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (web.isElementPresentBy("EmailField")) {
            log.info("SwitchTo Login Page was correct");
        } else {
            log.error("SwitchTo Login Page was INCORRECT");
        }

    }


}
