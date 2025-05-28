package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LoginPage extends BasePage {
	
	// WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class

    // Step1 -> Constructor to initialize WebDriver from BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    // Step2 -> Locators for Login page elements
    @FindBy(xpath="//input[@id='input-email']")
    private WebElement txtEmailAddress; // Email input field
    
    @FindBy(xpath="//input[@id='input-password']")
    private WebElement txtPassword; // Password input field
    
    @FindBy(xpath="//input[@value='Login']")
    private WebElement btnLogin; // Login button
    
    // Step3 ->  Action Methods to interact with Login page elements
    
    public void enterEmail(String email) {
    	txtEmailAddress.sendKeys(email); // Enter email address
    }
    
    public void enterPassword(String password) {
    	txtPassword.sendKeys(password); // Enter password
    }
    
    public void clickOnLogin() {
    	btnLogin.click(); // Click login button
    }
}
