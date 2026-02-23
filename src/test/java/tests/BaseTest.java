package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;
import java.io.File;

/**
 * Base Test class that all test classes will extend
 * Handles setup and teardown of WebDriver
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        DriverManager.setDriver(browser);
        driver = DriverManager.getDriver();
        // Each test will navigate to its own URL using TestUrls
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    /**
     * Helper method to navigate to a URL
     */
    protected void navigateTo(String url) {
        driver.get(url);
    }

    // File utility methods
    protected boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    protected void deleteFile(String filePath) {
        new File(filePath).delete();
    }

    protected String getDownloadFilePath(String fileName) {
        return System.getProperty("user.home") + File.separator + "Downloads" + File.separator + fileName;
    }
}
