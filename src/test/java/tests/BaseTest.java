package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;

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
}
