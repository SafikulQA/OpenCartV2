package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SearchPage extends BasePage {
	
    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class

    // Step 1 -> Constructor to initialize WebDriver from BasePage
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Step 2 -> Locators for Search page elements
    
    @FindBy(xpath = "//img[@title]")	// For TC004 - Matches product images dynamically by title attribute
    private List<WebElement> searchProductElements;
    
    @FindBy(xpath = "//input[@id='input-quantity']")	// For TC005 - Quantity input box on product page
    private WebElement txtquantityElement;
    
    @FindBy(xpath = "//button[@id='button-cart']")	// TC005 - Add to cart button
    private WebElement btnAddToCartElement;
    
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")	// TC005 - Confirmation message displayed after adding to cart
    private WebElement cnfmsgElement;

    // Step 3 -> Action Methods to interact with Search page elements

    /** Checks if a product with the specified name exists in the search results */
    public boolean isProductExist(String productName) {
        for (WebElement product : searchProductElements) {
            if (product.getDomAttribute("title").equals(productName)) {
                return true;  // Product found
            }
        }
        return false;  // Product not found
    }

    /** Selects (clicks) a product by its name from the search results */
    public void selectProduct(String productName) {
        for (WebElement product : searchProductElements) {
            if (product.getDomAttribute("title").equals(productName)) {
                product.click();
                break; // Stop looping after clicking to avoid StaleElementReferenceException
            }
        }
    }

    /** Sets the product quantity after clearing any existing input */
    public void setQuantity(String qty) {
    	// Clear the quantity box before entering new value for TC005
        txtquantityElement.clear();
        txtquantityElement.sendKeys(qty);
    }

    /** Clicks the Add to Cart button */
    public void addToCart() {
        btnAddToCartElement.click();
    }

    /** Checks if the confirmation message is displayed after adding product to cart */
    public boolean chkCnfMsg() {
        try {
            return cnfmsgElement.isDisplayed();
        } catch (Exception e) {
            return false;  // Confirmation message not displayed or element not found
        }
    }
}
