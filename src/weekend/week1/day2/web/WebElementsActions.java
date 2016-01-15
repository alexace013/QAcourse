package weekend.week1.day2.web;

import org.openqa.selenium.interactions.Actions;
import weekend.week1.day2.exceptions.NoElementFound;
import org.openqa.selenium.*;

public class WebElementsActions {

    WebDriver driver;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Insert value into text input HTML field
     * */
    public void input(String inputLocator, String inputData) {
        driver.findElement(By.xpath(inputLocator)).clear();
        driver.findElement(By.xpath(inputLocator)).sendKeys(inputData);
    }

    /**
     * Insert value into text input HTML field and Click ENTER
     * for Field which used in the xpath expression
     * */
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
     * */
    public void clickButton(String buttonLocator) {

        try {
            driver.findElement(By.xpath(buttonLocator)).click();
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

    }

    /**
     * Click link
     * */
    public void clickLink(String linkLocator) {
        driver.findElement(By.xpath(linkLocator)).click();
    }

    public void moveToElementAndClick(String movToLocator, String clickToElement) {

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
     * */
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
     * */
    public boolean isElementPresent(String elementLocator) {

        if (!driver.findElement(By.xpath(elementLocator)).isDisplayed()) {
            return false;
        }

        return true;

    }

    /**
     * This method is used to agree messages on pop-up windows
     * */
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
     * */
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
     * */
    public void refreshPage() {
        driver.navigate().refresh();
    }

}
