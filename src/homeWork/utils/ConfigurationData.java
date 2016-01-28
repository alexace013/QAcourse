package homeWork.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationData {

    private static final Logger log = Logger.getLogger("log4j.rootLogger");
    private static final String UI_MAPPING_PATH = "src/resources/UIMapping.properties";
    private static ConfigurationData config;
    private final Properties PROPERTIES;
    private Map<String, String> propertiesMap;

    private ConfigurationData() {

        this.PROPERTIES = new Properties();
        log.info(String.format("created %s", PROPERTIES.getClass().getSimpleName()));

        try {

            this.propertiesMap = loadPropertiesToMap();
            log.info(String.format("created %s", propertiesMap.getClass().getSimpleName()));

        } catch (IOException e) {

            e.printStackTrace();
            log.info(e.getMessage());

        }

    }

    public static ConfigurationData getConfigurationData() {

        if (config == null) {
            config = new ConfigurationData();

        }

        return config;

    }

    public By getLocator(String key) throws IOException {

        String[] partsOfLocators = getPropertyValue(key).split("\"");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String target = partsOfLocators[1];

        switch (findMethod) {

            case "id":
                return By.id(target);

            case "name":
                return By.name(target);

            case "class":
                return By.className(target);

            case "cssSelector":
                return By.cssSelector(target);

            case "xpath":
                return By.xpath(target);

            case "tagName":
                return By.tagName(target);

            case "linkText":
                return By.linkText(target);

            case "partialLinkText":
                return By.partialLinkText(target);

            default:
                throw new IOException(
                        String.format("Locator '%s'  not defined!", target));
        }

    }

    private Map<String, String> loadPropertiesToMap() throws IOException {

        if (Files.exists(Paths.get(UI_MAPPING_PATH))) {

            try (FileInputStream inputStream = new FileInputStream(UI_MAPPING_PATH)) {

                PROPERTIES.load(inputStream);
                return propertiesMap = new HashMap<String, String>((Map) PROPERTIES);

            }

        } else {

            throw new FileNotFoundException(
                    String.format("%s not found exception", UI_MAPPING_PATH.substring(13)));

        }

    }

    private String getPropertyValue(String key) {
        return propertiesMap.get(key);
    }

}
