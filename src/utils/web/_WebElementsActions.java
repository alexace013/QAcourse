package utils.web;

import utils.ConfigData;
import org.openqa.selenium.interactions.Actions;
import utils.web.exceptions.NoElementFound;
import org.openqa.selenium.*;

import java.io.IOException;

public class _WebElementsActions {

    WebDriver driver;

    public _WebElementsActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * open page
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) throws IOException {
//        driver.findElement(ConfigurationData11.ui(inputLocator)).clear();
        driver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
    }

    /**
     * Insert value into text input HTML field and Click ENTER
     * for Field which used in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {

        try {
            driver.findElement(By.xpath(inputLocator)).clear();
            driver.findElement(By.xpath(inputLocator)).sendKeys(inputData);
            driver.findElement(By.xpath(inputLocator)).sendKeys(Keys.ENTER);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) throws IOException {
        driver.findElement(ConfigData.ui(buttonLocator)).click();
    }

    public void click(String link) throws IOException {
        driver.findElement(ConfigData.ui(link)).click();
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) throws IOException {
        driver.findElement(ConfigData.ui(linkLocator)).click();
    }

    public void moveToElementAndClick(String movToLocator, String clickToElement) throws IOException {

        WebElement webElement = null;

        try {
            webElement = driver.findElement(By.xpath(movToLocator));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        Actions actions = new Actions(driver);

        actions.moveToElement(webElement);
        actions.perform();
        clickButton(clickToElement);

    }

    public void selectCheckBox(String checkBoxLocator) {
        driver.findElement(By.xpath(checkBoxLocator)).clear();
    }

    /**
     * Select/deselect the checkbox, the second parameter "Y" or "N"
     */
    public void selectCheckBox(String checkBoxLocator, String isCheckBoxSelect) {

        if (driver.findElement(By.xpath(checkBoxLocator)).isSelected() & isCheckBoxSelect.equals("N")) {
            driver.findElement(By.xpath(checkBoxLocator)).click();
        }

        if (!driver.findElement(By.xpath(checkBoxLocator)).isSelected() & isCheckBoxSelect.equals("Y")) {
            driver.findElement(By.xpath(checkBoxLocator)).click();
        }

    }

    /**
     * Method is used to check that element is present on page
     */
    public boolean isElementPresentBy(String elementLocator) {

        if (!driver.findElement(By.xpath(elementLocator)).isDisplayed()) {
            return false;
        }

        return true;

    }

    public boolean isElementPresentConfig(String elementLocator) throws IOException {

        if (!driver.findElement(ConfigData.ui(elementLocator)).isDisplayed()) {
            return false;
        }

        return true;

    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresentAndAccept() {

        boolean alertPresence = false;

        try {
            Alert alert = driver.switchTo().alert();

            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            return alertPresence;
        }

        return alertPresence;

    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public String getAlertText() {

        String alertText;

        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            ex.printStackTrace();
        }

        return alertText;

    }

    /**
     * First method for refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clearAndInputWithBy(String inputLocator, String inputData) {
        driver.findElement(By.xpath(inputLocator)).clear();
        driver.findElement(By.xpath(inputLocator)).sendKeys(inputData);
    }

    public void clearAndInputWithConfigData(String inputLocator, String inputData) throws IOException {
        driver.findElement(ConfigData.ui(inputLocator)).clear();
        driver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
    }


}

