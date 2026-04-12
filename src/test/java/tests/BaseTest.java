package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverManager;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Elements;

/**
 * Base Test class that all test classes will extend
 * Handles setup and teardown of WebDriver
 */
public class BaseTest {
    protected WebDriver driver;
    protected Elements elementsPage;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        DriverManager.setDriver(browser);
        driver = DriverManager.getDriver();
        elementsPage = new Elements(driver);
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

    /**
     * Wait for a file to exist in the file system
     * @param filePath - full path to the file
     * @param timeoutSeconds - maximum wait time in seconds
     * @return true if file exists within timeout, false otherwise
     */
    protected boolean waitForFileToExist(String filePath, int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(Exception.class);
        
        try {
            wait.until(d -> new File(filePath).exists());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for an alert to be present
     * @param timeoutSeconds - maximum wait time in seconds
     * @return Alert object if present, null otherwise
     */
    protected Alert waitForAlert(int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get text from the current alert
     * @return alert text
     */
    protected String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Accept the current alert
     */
    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * Dismiss the current alert
     */
    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Get alert text and accept it in one operation
     * @return alert text before accepting
     */
    protected String getAlertTextAndAccept() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
