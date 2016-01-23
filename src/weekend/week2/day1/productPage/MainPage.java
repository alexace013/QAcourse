package weekend.week2.day1.productPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.web._WebElementsActions;

import java.io.IOException;

public class MainPage {

    WebDriver driver;
    _WebElementsActions web;
    Logger log = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new _WebElementsActions(driver);
    }

    public void clickLogo() throws IOException {
        web.clickLink("Logo");
        log.info("click on logo link");
    }

    public void switchToLoginPage() throws IOException {

        try {
            web.clickLink("LoginLink");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("click on LoginLink");

        if (web.isElementPresentConfig("EmailField")) {
            log.info("SwitchTo Login Page was correct");
        } else {
            log.error("SwitchTo Login Page was INCORRECT");
        }

    }

}
