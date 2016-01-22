package homeWork.hw2.versionBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String URL = "http://www.ellos.se/";

    private WebDriver driver;

    /**
     * user name
     * */
    @FindBy
    private WebElement userName;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, URL);
        this.driver = driver;
    }

    public void clickLoginLink(String linkLogger) {
        driver.findElement(By.xpath(linkLogger)).click();
    }

    public void closeReklama() {
        driver.findElement(By.cssSelector("div#Content div.closeButton")).click();
    }

}
