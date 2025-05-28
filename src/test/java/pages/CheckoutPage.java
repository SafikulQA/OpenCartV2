package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BasePage;

public class CheckoutPage extends BasePage {

    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor - Mandatory step for every child page object class

    // Step 1 -> Constructor to initialize WebDriver from BasePage
    public CheckoutPage(WebDriver driver) {
        super(driver); // Pass driver to BasePage constructor
    }

    // Step 2 -> Locators for checkout page elements

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    private WebElement txtFirstNameElement; // First name input field

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    private WebElement txtLastNamElement; // Last name input field

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    private WebElement txtAddress1Element; // Address line 1 input field

    @FindBy(xpath = "//input[@id='input-payment-address-2']")
    private WebElement txtAddress2Element; // Address line 2 input field

    @FindBy(xpath = "//input[@id='input-payment-city']")
    private WebElement txtCityElement; // City input field

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    private WebElement txtPostCodeElement; // Postal code input field

    @FindBy(xpath = "//select[@id='input-payment-country']")
    private WebElement dropCountryElement; // Country dropdown list

    @FindBy(xpath = "//select[@id='input-payment-zone']")
    private WebElement dropStateElement; // State/region dropdown list

    @FindBy(xpath = "//input[@id='button-payment-address']")
    private WebElement btnContinueDeliveryAddressElement; // Continue button after entering billing address

    @FindBy(xpath = "//textarea[@name='comment']")
    private WebElement txtCommentsAboutYourOrderElement; // Textarea to enter order comments

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement chkBoxTermsElement; // Checkbox to agree with terms & conditions

    @FindBy(xpath = "//input[@id='button-payment-method']")
    private WebElement btnContinuePaymentElement; // Continue button for payment method

    @FindBy(xpath = "//div[@class='alert alert-warning alert-dismissible']")
    private WebElement txtPaymentWarningMsgElement; // Warning message for missing payment method

    // Step 3 -> Action methods to interact with checkout page elements

    public void setFirstName(String firstname) {
        txtFirstNameElement.sendKeys(firstname); // Enter first name
    }

    public void setLastName(String lastname) {
        txtLastNamElement.sendKeys(lastname); // Enter last name
    }

    public void setAddress1(String address1) {
        txtAddress1Element.sendKeys(address1); // Enter address line 1
    }

    public void setAddress2(String address2) {
        txtAddress2Element.sendKeys(address2); // Enter address line 2 (optional)
    }

    public void setCity(String city) {
        txtCityElement.sendKeys(city); // Enter city
    }

    public void setPostCode(String pin) {
        txtPostCodeElement.sendKeys(pin); // Enter postal code
    }

    public void setCountry(String country) {
        new Select(dropCountryElement).selectByVisibleText(country); // Select country from dropdown
    }

    public void setState(String state) {
        new Select(dropStateElement).selectByVisibleText(state); // Select state/region from dropdown
    }

    public void clickOnContinueAfterBillingAddress() {
        btnContinueDeliveryAddressElement.click(); // Click continue after filling billing address
    }

    public void setCommentsAboutYourOrderElement(String ordermsg) {
        txtCommentsAboutYourOrderElement.sendKeys(ordermsg); // Enter any additional comments about the order
    }

    public void selectTermsAndCondition() {
        chkBoxTermsElement.click(); // Select the terms and conditions checkbox
    }

    public void clickOnContinueAfterPaymentMethod() {
        btnContinuePaymentElement.click(); // Click to proceed after choosing payment method
    }

    public boolean isPaymentWarningDisplayed() {
        try {
            // Wait for the warning message to appear (max 10 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement warning = wait.until(ExpectedConditions.visibilityOf(txtPaymentWarningMsgElement));

            String warningText = warning.getText(); // Capture the warning message text
            System.out.println("Warning message displayed: " + warningText); // Print for debug purposes

            // Return true if the expected warning is shown
            return warningText.contains("Warning: Payment method required!");
        } catch (Exception e) {
            System.out.println("Warning message not displayed or not found."); // Fallback in case of timeout
            return false;
        }
    }
}
