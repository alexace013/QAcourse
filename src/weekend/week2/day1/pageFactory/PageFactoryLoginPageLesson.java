package weekend.week2.day1.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPageLesson {

    WebDriver driver;

    @FindBy(xpath = ".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername']")
    WebElement emailField;

    @FindBy(xpath = ".//input[@id='LoginPasswordText']")
    WebElement passField;

    @FindBy(xpath = ".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginPassword']")
    WebElement passField2;

    @FindBy(xpath = ".//a[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginButton']")
    WebElement loginButton;

    @FindBy(xpath = ".//div[@id='serverValidationErrors']/ul")
    WebElement errorMessage;

    public PageFactoryLoginPageLesson(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmailFiled(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPassFiled(String password) {
        passField.click();
        passField2.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessage() {

        boolean res = false;

        try {
            if (errorMessage.isDisplayed()) {
                System.out.println("Error is present!!!");
                res = true;
            } else {
                System.out.println("Error is not present!");
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("ERROR MESSAGE: " + e.getMessage());
        }

        return res;

    }

}
