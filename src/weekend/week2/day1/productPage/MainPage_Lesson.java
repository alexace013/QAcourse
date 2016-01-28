package weekend.week2.day1.productPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import weekend.utils.web.WebElementsActions_Lesson;

import java.io.IOException;

public class MainPage_Lesson {

    WebDriver driver;
    WebElementsActions_Lesson web;
    Logger log = Logger.getLogger(MainPage_Lesson.class);

    public MainPage_Lesson(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions_Lesson(driver);
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
