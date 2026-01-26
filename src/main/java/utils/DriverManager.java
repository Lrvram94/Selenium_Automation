package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

/**
 * Driver Manager class to handle WebDriver initialization and configuration
 */
public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String browserType) {
        WebDriver webDriver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.set(webDriver);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
