package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class HomePage extends BasePage {
	
    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class

    // Step 1 -> Constructor to initialize WebDriver from BasePage
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Step 2 -> Locators for Home page elements
    
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement lnkMyAccount; // Dropdown for My Account options

    @FindBy(xpath = "//a[normalize-space()='Register']") // Link to registration page
    private WebElement lnkRegister;
    
    @FindBy(xpath = "//a[normalize-space()='Login']") // Link to login page
    private WebElement lnkLogin;
    
    @FindBy(xpath = "//input[@placeholder='Search']") // Product search input field
    private WebElement txtSearchboxElement;
    
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']") // Search button
    private WebElement btnSearchElement;

    // Step 3 -> Action Methods to interact with Home page elements
    
    // Clicks on the 'My Account' link to expand options like Register/Login.
    
    public void clickOnMyAccount() {
        lnkMyAccount.click();
    }
    
   
     // Clicks on the 'Register' option under My Account dropdown.
    
    public void clickOnRegister() {
        lnkRegister.click();
    }
   
    // Clicks on the 'Login' option under My Account dropdown.
    
    public void clickOnLogin() {
        lnkLogin.click();
    }

    
     // Enters a product name into the search box after clearing any existing text.
     // @param pName Name of the product to search
    
    public void enterProductName(String pName) {
        txtSearchboxElement.clear();
        txtSearchboxElement.sendKeys(pName);
    }
    
     //Clicks the search button to perform product search.
    
    public void clickSearch() {
        btnSearchElement.click();
    }
}
