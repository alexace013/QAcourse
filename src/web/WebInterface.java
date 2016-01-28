package web;

public interface WebInterface {

    void openPage(String url);

    void input(String inputLocator, String inputData);

    void clear(String locator);

    void clearAndInput(String inputLocator, String inputData);

    void clearAndInputAndClickEnter(String inputLocator, String inputData);

    void click(String link);

    void clickTAB(String clickLocator);

    void clickButton(String buttonLocator);

    void clickLink(String linkLocator);

    void moveToElementAndClick(String movToLocator, String clickToElement);

    void selectCheckBox(String checkBoxLocator);

    void selectCheckBox(String checkBoxLocator, String isCheckBoxSelect);

    boolean isElementPresent(String elementLocator);

    boolean isAlertPresentAndAccept();

    String getAlertText();

    void refreshPage();

    void waitElementNotVisible(String elementLocator, int timeoutInS);

    boolean waitForElementPresent(String elementLocator);

}
