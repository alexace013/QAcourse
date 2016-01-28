package web;

import homeWork.utils.ConfigurationData;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WebElementsActions implements WebInterface {

    private final static Logger log = Logger.getLogger("log4j.properties");
    private static WebDriverWait webDriverWait;
    private final ConfigurationData CONFIG;
    private WebDriver driver;

    public WebElementsActions(WebDriver driver) {

        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        CONFIG = ConfigurationData.getConfigurationData();
        log.info(String.format("created %s with '%s'",
                this.getClass().getCanonicalName(), driver.getClass().getCanonicalName()));

    }

    /**
     * open page
     */
    @Override
    public void openPage(String url) {
        driver.get(url);
        log.info(String.format("browser open page: %s" + url));
    }

    /**
     * Insert value into text input HTML field
     */
    @Override
    public void input(String inputLocator, String data) {

        try {
            driver.findElement(CONFIG.getLocator(inputLocator)).sendKeys(data);
            log.info(String.format("input '%s' and send '%s'", inputLocator, data));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }
    }

    @Override
    public void clear(String locator) {

        try {
            driver.findElement(CONFIG.getLocator(locator)).clear();
            log.info(String.format("clear element %s", locator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    @Override
    public void clearAndInput(String inputLocator, String inputData) {

        try {
            driver.findElement(CONFIG.getLocator(inputLocator)).clear();
            driver.findElement(CONFIG.getLocator(inputLocator)).sendKeys(inputData);
            log.info(String.format("clear '%s' and input %s", inputLocator, inputData));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("exception %s", e.getStackTrace()));
        }

    }

    /**
     * Insert value into text input HTML field and Click ENTER
     * for Field which used in the xpath expression
     */
    @Override
    public void clearAndInputAndClickEnter(String clickAndInputAndClickLocator, String data) {

        try {
            driver.findElement(CONFIG.getLocator(clickAndInputAndClickLocator)).clear();
            driver.findElement(CONFIG.getLocator(clickAndInputAndClickLocator)).sendKeys(data);
            driver.findElement(CONFIG.getLocator(clickAndInputAndClickLocator)).sendKeys(Keys.ENTER);
            log.info(String.format("clear '%s' and send '%s' and click ENTER.", clickAndInputAndClickLocator, data));

        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    @Override
    public void click(String clickLocator) {

        try {
            driver.findElement(CONFIG.getLocator(clickLocator)).click();
            log.info(String.format("click on: '%s'", clickLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    @Override
    public void clickTAB(String clickLocator) {

        try {
            driver.findElement(CONFIG.getLocator(clickLocator)).sendKeys(Keys.TAB);
            log.info(String.format("click TAB '%s'", clickLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    /**
     * Click a button
     */
    @Override
    public void clickButton(String buttonLocator) {

        try {
            driver.findElement(CONFIG.getLocator(buttonLocator)).click();
            log.info(String.format("click on button '%s'", buttonLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    /**
     * Click link
     */
    @Override
    public void clickLink(String linkLocator) {

        try {
            driver.findElement(CONFIG.getLocator(linkLocator)).click();
            log.info(String.format("click on link '%s'", linkLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("Exception %s", e.getStackTrace()));
        }

    }

    @Override
    public void moveToElementAndClick(String moveToLocator, String clickToElement) {

        WebElement element = null;

        try {
            element = driver.findElement(CONFIG.getLocator(moveToLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("exception %s", e.getStackTrace()));
        }

        Actions actions = new Actions(driver);
        log.info(String.format("created %s", actions.getClass().getCanonicalName()));
        actions.moveToElement(element);
        log.info(String.format("move to element '%s'", element.getClass().getCanonicalName()));
        actions.perform();
        clickButton(clickToElement);

    }

    /**
     * Select/deselect the checkbox, the second parameter "Y" or "N"
     */
    @Override
    public void selectCheckBox(String checkBoxLocator) {
        try {
            driver.findElement(CONFIG.getLocator(checkBoxLocator)).clear();
            log.info(String.format("select '%s'", checkBoxLocator));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("exception %s", e.getStackTrace()));
        }
    }

    @Override
    public void selectCheckBox(String checkBoxLocator, String isCheckBoxSelect) {

        try {
            if (driver.findElement(CONFIG.getLocator(checkBoxLocator)).isSelected() &
                    isCheckBoxSelect.equals(true)) {
                driver.findElement(CONFIG.getLocator(checkBoxLocator)).click();
                log.info(String.format("check box '%s' selected %b", checkBoxLocator, isCheckBoxSelect));
            }
            if (!driver.findElement(CONFIG.getLocator(checkBoxLocator)).isSelected() &
                    isCheckBoxSelect.equals(false)) {
                driver.findElement(CONFIG.getLocator(checkBoxLocator)).click();
                log.info(String.format("check box '%s' selected %b", checkBoxLocator, isCheckBoxSelect));
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("exception %s", e.getStackTrace()));
        }

    }

    /**
     * Method is used to check that element is present on page
     */
    @Override
    public boolean isElementPresent(String elementLocator) {

        try {
            if (!driver.findElement(CONFIG.getLocator(elementLocator)).isDisplayed()) {

                log.info(String.format("'%s' not present on page.", elementLocator));
                return false;

            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("exception %s", e.getStackTrace()));
        }

        log.info(String.format("'%s' is present on page.", elementLocator));
        return true;

    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    @Override
    public boolean isAlertPresentAndAccept() {

        boolean isAlert = false;

        try {

            Alert alert = driver.switchTo().alert();
            alert.accept();

            isAlert = true;

            log.info(String.format("Alert present on page."));

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            log.error(String.format("ConfigurationDataException %s", e.getMessage()));

            return isAlert;

        }

        log.info(String.format("Success. Alert no present on page."));

        return isAlert;

    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    @Override
    public String getAlertText() {

        String alertText;

        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            log.info(String.format("alert '%s'", alertText));
        } catch (NoAlertPresentException e) {
            alertText = "Alert is not found";
            e.printStackTrace();
            log.error(String.format("%s. %s", alertText, e.getStackTrace()));
        }

        return alertText;
    }

    /**
     * First method for refresh page
     */
    @Override
    public void refreshPage() {
        driver.navigate().refresh();
        log.info(String.format("Page refresh."));
    }

    @Override
    public void waitElementNotVisible(String elementLocator, int timeoutInS) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(CONFIG.getLocator(elementLocator)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean waitForElementPresent(String elementLocator) {

        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CONFIG.getLocator(elementLocator)));
            log.info("WaitForElement _" + elementLocator + "_ Present");
        } catch (IOException e) {
            log.error("Waiting for the appearance of the element _" + elementLocator + "_ was not successful " +
                    "WaitForElement _" + elementLocator + "_ Present");
            e.printStackTrace();
            return false;
        } catch (TimeoutException timeEx) {
            log.error(timeEx.getMessage());
            return false;
        }

        return true;

    }

}