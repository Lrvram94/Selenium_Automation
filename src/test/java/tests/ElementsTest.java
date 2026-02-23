package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements;
import utils.TestUrls;

public class ElementsTest extends BaseTest {

    @Test
    public void testTextBoxSubmission() {
        // Navigate to local test page (reliable)
        System.out.println("Navigating to: " + TestUrls.DEMOQA_TEXT_BOX);
        navigateTo(TestUrls.DEMOQA_TEXT_BOX);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());
        
        Elements textBoxPage = new Elements(driver);
        
        // Fill form fields (using Selenium's web form fields)
        textBoxPage.sendKeys(textBoxPage.fullNameField, "John Doe");
        textBoxPage.sendKeys(textBoxPage.emailField, "john.doe@example.com");
        textBoxPage.sendKeys(textBoxPage.currentAddressField, "123 Main St");
        
        // Verify fields are populated
        Assert.assertEquals(textBoxPage.fullNameField.getAttribute("value"), "John Doe", 
                           "Full name field value mismatch");
        Assert.assertEquals(textBoxPage.emailField.getAttribute("value"), "john.doe@example.com", 
                           "Email field value mismatch");
        Assert.assertEquals(textBoxPage.currentAddressField.getAttribute("value"), "123 Main St", 
                           "Address field value mismatch");
    }
}