package weekend.utils;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class ConfigData_Lesson {

    public static String uiMappingFile = "/weekend/utils/WeekendUIMapping.properties";

    public static String getValueFromFile(String key, String fileName) throws IOException {

        Properties properties = new Properties();

        properties.load(ConfigData_Lesson.class.getResourceAsStream(uiMappingFile));

        return properties.getProperty(key);

    }

    public static By ui(String key) throws IOException {

        String[] partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
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
