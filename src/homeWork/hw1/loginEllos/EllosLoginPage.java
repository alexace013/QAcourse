package homeWork.hw1.loginEllos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import weekend.utils.web.WebElementsActions_Lesson;

import java.io.IOException;

public class EllosLoginPage {

    WebDriver driver;
    WebElementsActions_Lesson web;

    Logger log = Logger.getLogger(EllosLoginPage.class);

    public EllosLoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions_Lesson(driver);
    }

    public void fillEmailField(String value) {
        web.clearAndInputWithBy("EmailField", value);
        log.info("input to EmailField - " + value);
    }

    public void fillPasswordField(String value) {
        try {
            web.clickLink("PassField");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            web.input("LoginButton", value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("input to PasswordField - " + value);
    }

    public void pressLoginButton() {
        try {
            web.clickButton("LoginButton");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkErrorShown(String locator) throws IOException {

        if (web.isElementPresentBy(locator)) {
            log.info("Error is present");
            return true;
        } else {
            log.error("Error is not present!");
            return false;
        }

    }

}
