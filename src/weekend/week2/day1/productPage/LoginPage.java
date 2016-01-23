package weekend.week2.day1.productPage;

import org.openqa.selenium.WebDriver;
import utils.web._WebElementsActions;

import java.io.IOException;

public class LoginPage {

    WebDriver driver;
    _WebElementsActions web;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new _WebElementsActions(driver);
    }


    public void fillLoginField() throws IOException {
        web.clearAndInputWithConfigData("EmailField", "admin@gmail.com");
    }

    public void fillPasswordField() {
        try {
            web.click("PassField");
            web.input("PassField2", "admin12345");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pressLoginButton() {
        try {
            web.clickButton("LoginButton");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkErrorShown(String xpath) throws IOException {
        if (web.isElementPresentConfig(xpath)) {
            System.out.println("Error is present");
            return true;
        } else {
            System.out.println("Error is not present!");
            return false;
        }
    }
}
