package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class HomePage extends BasePage {
	
	//WebDriver driver; //Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // Constructor - mandatory for every child page object class
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement lnkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']") // For Account Registration Test
    private WebElement lnkRegister;
    
    @FindBy(xpath = "//a[normalize-space()='Login']") // For Login Test
    private WebElement lnkLogin;
    
    @FindBy(xpath = "//input[@placeholder='Search']") // For Search Product Test
    private WebElement txtSearchboxElement;
    
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']") // For Search Product Test
    private WebElement btnSearchElement;

    // Action Methods
    public void clickOnMyAccount() {
        lnkMyAccount.click();
    }
    
    // For TC001
    public void clickOnRegister() {
        lnkRegister.click();
    }
    
    // For TC002
    public void clickOnLogin() {
        lnkLogin.click();
    }

    
    public void enterProductName(String pName) {
    	
    	// For TC004 - enter product name after clearing the search box
        txtSearchboxElement.clear();
        txtSearchboxElement.sendKeys(pName);
    }
    
    // For TC004
    public void clickSearch() {
        btnSearchElement.click();
    }
}
