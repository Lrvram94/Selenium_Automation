package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ElementsTest extends BaseTest {

    @Test
    public void testTextBoxSubmission() {
        // Navigate to local test page (reliable)
        navigateTo(ConfigReader.getProperty("base.url") + ConfigReader.getProperty("textbox.path"));
        
        // Fill form fields (using Selenium's web form fields)
        elementsPage.sendKeys(elementsPage.fullNameField, "John Doe");
        elementsPage.sendKeys(elementsPage.emailField, "john.doe@example.com");
        elementsPage.sendKeys(elementsPage.currentAddressField, "123 Main St");
        
        // Verify fields are populated
        Assert.assertEquals(elementsPage.fullNameField.getAttribute("value"), "John Doe", 
                           "Full name field value mismatch");
        Assert.assertEquals(elementsPage.emailField.getAttribute("value"), "john.doe@example.com", 
                           "Email field value mismatch");
        Assert.assertEquals(elementsPage.currentAddressField.getAttribute("value"), "123 Main St", 
                           "Address field value mismatch");
    }

    @Test
    public void testFileDownloadUpload() { 
        navigateTo(ConfigReader.getProperty("base.url") + ConfigReader.getProperty("upload.path"));
    

        // Setup - get file path and clean up if exists
        String filePath = getDownloadFilePath("sampleFile.jpeg");
        deleteFile(filePath);
        
        // Download file
            elementsPage.downloadButton.click();
        
        // Wait for download to complete (up to 10 seconds)
        Assert.assertTrue(waitForFileToExist(filePath, 10), 
                         "File download timed out: " + filePath);
        
        // Verify file downloaded
        Assert.assertTrue(fileExists(filePath), "Downloaded file does not exist: " + filePath);

        // Upload the downloaded file
        elementsPage.uploadFileInput.sendKeys(filePath);
        
        // Verify upload by checking the input value attribute
        Assert.assertTrue(elementsPage.uploadFileInput.getAttribute("value").contains("sampleFile.jpeg"),
                         "File upload verification failed");
        
        // Cleanup downloaded file
        deleteFile(filePath);
    }

    @Test
    public void testAlertHandling() {
        navigateTo(ConfigReader.getProperty("base.url") + "/alerts");
        
        // Test immediate alert
        elementsPage.alertButton.click();
        String alertText = getAlertTextAndAccept();
        Assert.assertEquals(alertText, "You clicked a button", "Alert text mismatch");
    }

    @Test
    public void testTimerAlert() {
        navigateTo(ConfigReader.getProperty("base.url") + "/alerts");
        
        // Test 5-second timer alert
        elementsPage.timerAlertButton.click();
        
        // Wait for alert to appear (waits up to 10 seconds for 5-second delay)
        Alert alert = waitForAlert(10);
        Assert.assertNotNull(alert, "5-second timer alert did not appear within 10 seconds");
        
        // Verify alert text and accept
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds", 
                           "Timer alert text mismatch");
        alert.accept();
    }
        
}