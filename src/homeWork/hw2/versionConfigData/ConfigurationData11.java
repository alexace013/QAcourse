package homeWork.hw2.versionConfigData;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationData11 {

    public static String uiMappingFile =
            "/media/alexander/HDD/Workspace/Projects/QA/QAcourse/src/homeWork/hw2/UIMapping.properties";

    public static String getValueFromFile(String key, String fileName) throws IOException {

        Properties properties = new Properties();

        properties.load(ConfigurationData11.class.getResourceAsStream(uiMappingFile));

        return properties.getProperty(key);

    }

    public static By ui(String key) throws IOException {

        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String target = partsOfLocators[1];

        By temp = null;

        switch (findMethod) {
            case "id":
                temp = By.id(target);
                break;
            case "name":
                temp = By.name(target);
                break;
            case "className":
                temp = By.className(target);
                break;
            case "linkText":
                temp = By.linkText(target);
                break;
            case "tagName":
                temp = By.tagName(target);
                break;
            case "cssSelector":
                temp = By.cssSelector(target);
                break;
            case "xpath":
                temp = By.xpath(target);
                break;
            case "partialLinkText":
                temp = By.partialLinkText(target);
                break;
            default:
                throw new IOException(
                        String.format("Locator type '%s'  not defined!", findMethod));
        }

        return temp;

    }

}
