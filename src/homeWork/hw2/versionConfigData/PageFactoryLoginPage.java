package homeWork.hw2.versionConfigData;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPage {

    Logger log = Logger.getLogger(PageFactoryLoginPage.class);

    @FindBy(css = "loginField")
    WebElement emailField;

    @FindBy(xpath = "passFieldInput1")
    WebElement passField1;

    @FindBy(xpath = "PassFieldInput2")
    WebElement passField2;

    @FindBy(xpath = "loginButton")
    WebElement loginButton;

    @FindBy(xpath = "errorMessage")
    WebElement errorMessage;

    private WebDriver driver;

    public PageFactoryLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        log.info(String.format("created %s", this.getClass().getName()));
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void fillEmailFiled(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        log.info(String.format("%s clear and send \"%s\"", emailField, email));
    }

    public void fillPassFiled(String password) {
        passField1.click();
        passField2.sendKeys(password);
        log.info(String.format("%s clear and send in %s \"%s\"",
                passField1, passField2, password));
    }

    public boolean isErrorMessage() {

        boolean res = false;

        try {

            if (errorMessage.isDisplayed()) {

                res = true;
                log.info(String.format("Error is present: %s", errorMessage));

            } else {

                log.info(String.format("Error is not present."));

            }

        } catch (org.openqa.selenium.NoSuchElementException e) {

            log.info(String.format("ERROR MESSAGE: %s", e.getMessage()));

        }

        return res;

    }

}
