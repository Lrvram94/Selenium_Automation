package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements extends BasePage {

    // Form fields - DemoQA uses userName instead of fullName
    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    public Elements(WebDriver driver) {
        super(driver);
    }

    
}
