package homeWork.hw2.versionConfigData;

import homeWork.hw2.versionConfigData.configExeption.ConfigurationDataException;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationData {

    public static String uiMappingFile =
            "/media/alexander/HDD/Workspace/Projects/QA/QAcourse/src/homeWork/hw2/UIMapping.properties";
    public String mapFileName;
    private Properties properties;

    /**
     * @info DEFAULT constructor without parameters, where the properties are initialized
     */
    public ConfigurationData() {
        properties = new Properties();
    }

    /**
     * @param mapFileName must be passed the ObjectMap file (example: objectMap.properties)
     * @throws IOException if mapFileName incorrect or null
     * @info Constructor with parameter
     */
    public ConfigurationData(String mapFileName) {

        this(); // call the DEFAULT constructor
        this.mapFileName = mapFileName;

        try {
            FileInputStream input = new FileInputStream(this.mapFileName);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return If the attribute is lowerCase, then we will return the attribute,
     * or transform attribute to lowerCase
     * @info Method check, in which case is saved attribute locator
     */
    private static String checkLocatorCase(String locatorType) {
        return locatorType.equals(locatorType.toUpperCase()) ? locatorType.toLowerCase() : locatorType;
    }

    /**
     * @param key you need to pass a locator
     * @return Locator, which is converted to a string
     */
    private String getValueFromStaticFile(String key) throws IOException {
        properties.load(ConfigurationData.class.getResourceAsStream(uiMappingFile));
        return properties.getProperty(key);
    }

    /**
     * @return Locator, which is converted to a string
     */
    public String getValueFromFile(String key) throws IOException {
        properties.load(ConfigurationData.class.getResourceAsStream(mapFileName));
        return properties.getProperty(key);
    }

    public String getValueFromFile(String key, String fileName) throws IOException {
        this.mapFileName = fileName;
        properties.load(ConfigurationData.class.getResourceAsStream(this.mapFileName));
        return properties.getProperty(key);
    }

    /**
     * @param elementName you need to pass a link locator
     * @return Locator using the By class
     * @method GetLocator must will read the locator details from the
     * properties file and create locator (using the By class)
     */
    public By getLocator(String elementName) throws ConfigurationDataException {

        // Read value using the elementName as Key
        String locator = properties.getProperty(elementName);
        // Split the value which contains locator type and locator value
        String locatorType = locator.split("\"")[0];
        String locatorValue = locator.split("\"")[1];
        // A temporary variable to store the desired value
        By temp = null;

        switch (locatorType) {
            case "id":
                temp = By.id(locatorValue);
                break;
            case "name":
                temp = By.name(locatorValue);
                break;
            case "className":
                temp = By.className(locatorValue);
                break;
            case "linkText":
                temp = By.linkText(locatorValue);
                break;
            case "tagName":
                temp = By.tagName(locatorValue);
                break;
            case "cssSelector":
                temp = By.cssSelector(locatorValue);
                break;
            case "xpath":
                temp = By.xpath(locatorValue);
                break;
            case "partialLinkText":
                temp = By.partialLinkText(locatorValue);
                break;
            default:
                throw new ConfigurationDataException(
                        String.format("Locator type '%s'  not defined!", locatorType));
        }
        return temp;
    }

    /**
     * @param key you need to pass a link locator
     * @return Locator using the By class
     * @method ui must will read the locator details from the
     * properties file and create locator (using the By class)
     */
    public By ui(String key) throws IOException {

        String[] partsOfLocators = getValueFromStaticFile(key).split("\"");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String target = partsOfLocators[1];

        if (findMethod.equals("id")) {
            return By.id(target);
        } else if (findMethod.equals("xpath")) {
            return By.xpath(target);
        } else if (findMethod.equals("name")) {
            return By.name(target);
        } else if (findMethod.equals("linkText")) {
            return By.linkText(target);
        } else if (findMethod.equals("tagName")) {
            return By.tagName(target);
        } else if (findMethod.equals("className")) {
            return By.className(target);
        } else if (findMethod.equals("cssSelector")) {
            return By.cssSelector(target);
        } else {
            return By.partialLinkText(target);
        }

    }

}
