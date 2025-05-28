package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ShoppingCartPage extends BasePage {

    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class
    
    // Step 1 -> Constructor to initialize WebDriver from BasePage
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    
    // Step 2 -> Locators for Shopping Cart page elements
    
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement btnItemsElement;  // Dropdown button to show items in the cart
    
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    private WebElement lnkViewCartElement;  // Link to navigate to detailed Cart page
    
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    private WebElement lblTotalPricElement;	// Label showing the total price for all items in the cart
    
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement btnCheckoutElement;  // Button to proceed to the checkout page
    
    // Step 3 -> Action Methods to interact with Shopping Cart page elements
    
    public void clickItemsToNavigateToCart()
    {
    	btnItemsElement.click();  // Click dropdown to view cart items summary
    }
    
    public void clickViewCart() 
    {
    	lnkViewCartElement.click();  // Click 'View Cart' link to go to full cart details page
	}
    
    public String getTotalPrice()
    {
    	// Retrieve and return the total price text displayed in cart summary
    	return lblTotalPricElement.getText();
    }
    
    public void clickCheckOut()
    {
    	btnCheckoutElement.click();  // Click checkout button to start order placement process
    }

}
