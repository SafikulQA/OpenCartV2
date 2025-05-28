package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class MyAccPage extends BasePage {
	
    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class

    // Step 1 -> Constructor to initialize WebDriver from BasePage
    public MyAccPage(WebDriver driver) {
        super(driver);
    }
	
    // Step 2 -> Locators for My Account page elements

    @FindBy(xpath = "//h2[normalize-space()='My Account']") // Heading of My Account page
    private WebElement msgHeading;
	
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") // Logout link (added in step-6)
    private WebElement lnkLogout;

    // Step 3 -> Action Methods to interact with My Account page elements

    /**
     * Verifies if the My Account page is displayed.
     * Checks the presence of the heading to confirm page load.
     * @return true if heading is visible, false otherwise
     */
    public boolean isMyAccPageExists() {
        try {
            return msgHeading.isDisplayed();  // Return true if heading is found
        } catch (Exception e) {
            return false;  // Return false if heading not found (e.g., page didn't load properly)
        }
    }

    /**
     * Clicks on the Logout link to log the user out of the account.
     */
    public void clickOnLogout() {
        lnkLogout.click();
    }
}
