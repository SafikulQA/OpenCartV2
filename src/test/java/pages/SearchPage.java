package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SearchPage extends BasePage {
	
	//WebDriver driver; //Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.

	// child class constructor -1 Mandatory step for every child page object class
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Locators -2
    @FindBy(xpath = "//img[@title]")	// For TC004 More generic to match any product
    private List<WebElement> searchProductElements;
    
    @FindBy(xpath = "//input[@id='input-quantity']")	//For TC005
    private WebElement txtquantityElement;
    
    @FindBy(xpath = "//button[@id='button-cart']")	//TC005
    private WebElement btnAddToCartElement;
    
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")	//TC005
    private WebElement cnfmsgElement;
    
    

    // Action Methods -3
    public boolean isProductExist(String productName) {
        for (WebElement product : searchProductElements) {
            if (product.getDomAttribute("title").equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void selectProduct(String productName) {
        for (WebElement product : searchProductElements) {
            if (product.getDomAttribute("title").equals(productName)) {
                product.click();
                break; // Important to stop loop after click bcz Prevents StaleElementReferenceException
            }
        }
    }

    public void setQuantity(String qty) {
    	
    	// For TC005 - enter quantity after clearing the search box
        txtquantityElement.clear();
        txtquantityElement.sendKeys(qty);
    }

    public void addToCart() {
        btnAddToCartElement.click();
    }

    public boolean chkCnfMsg() {
        try {
            return cnfmsgElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}