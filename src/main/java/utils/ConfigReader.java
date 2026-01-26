package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties
 */
public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    static {
        try {
            FileInputStream file = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}
