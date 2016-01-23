package homeWork.hw2.versionConfigData;

import homeWork.hw2.versionConfigData.configExeption.ConfigurationDataException;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class WebElementsActions {

    Logger log = Logger.getLogger("log4j.rootLogger");
    private WebDriver driver;
    private ConfigurationData config;

    public WebElementsActions(WebDriver driver) {

        this.driver = driver;
        config = new ConfigurationData(ConfigurationData.uiMappingFile);
//        log.info(String.format("created %s", this.getClass().getName()));

    }

    public void openPage(String url) {
        driver.get(url);
        log.info(String.format("open page: %s" + url));
    }

    public void input(String inputLocator, String data) throws ConfigurationDataException {
        driver.findElement(config.getLocator(inputLocator)).sendKeys(data);
        log.info(String.format("input %s and send %s", inputLocator, data));
    }

    public void click(String clickLocator) throws ConfigurationDataException {
        driver.findElement(config.getLocator(clickLocator)).click();
        log.info(String.format("click on element: %s", clickLocator));
    }

    public void inputAndClickEnter(String inputAndClickLocator, String data) {

        try {

            driver.findElement(config.getLocator(inputAndClickLocator)).clear();
            driver.findElement(config.getLocator(inputAndClickLocator)).sendKeys(data);
            driver.findElement(config.getLocator(inputAndClickLocator)).sendKeys(Keys.ENTER);

            log.info(String.format("%s send %s and click enter.", inputAndClickLocator, data));

        } catch (ConfigurationDataException e) {

            e.printStackTrace();
            log.info(String.format("ConfigurationDataException %s", e.getMessage()));

        }

    }

    public void clickButton(String buttonLocator) throws ConfigurationDataException {
        driver.findElement(config.getLocator(buttonLocator)).click();
        log.info(String.format("click on %s", buttonLocator));
    }

    public void clickLink(String linkLocator) throws ConfigurationDataException {
        driver.findElement(config.getLocator(linkLocator)).click();
        log.info(String.format("click on %s", linkLocator));
    }

    public boolean isElementPresentBy(String elementLocator) throws ConfigurationDataException {

        if (!driver.findElement(config.getLocator(elementLocator)).isDisplayed()) {

            log.info(String.format("%s not present on page.", elementLocator));

            return false;

        }

        log.info(String.format("%s is present on page.", elementLocator));

        return true;

    }

    public boolean isAlertPresentAndAccept() {

        boolean isAlert = false;

        try {

            Alert alert = driver.switchTo().alert();
            alert.accept();

            isAlert = true;

            log.info(String.format("Alert present on page."));

        } catch (NoAlertPresentException e) {

            e.printStackTrace();
            log.info(String.format("ConfigurationDataException %s", e.getMessage()));

            return isAlert;

        }

        log.info(String.format("Success. Alert no present on page."));

        return isAlert;

    }

    public void clearAndInputWithConfigurationData(String inputLocator, String inputData)
            throws ConfigurationDataException {

        driver.findElement(config.getLocator(inputLocator)).clear();
        driver.findElement(config.getLocator(inputLocator)).sendKeys(inputData);

    }

}
