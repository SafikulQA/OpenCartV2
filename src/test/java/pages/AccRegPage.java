package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AccRegPage extends BasePage {

    // WebDriver driver; // Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    // child class constructor Mandatory step for every child page object class

    // Step1 -> Constructor to initialize WebDriver from BasePage
	
    public AccRegPage(WebDriver driver) {
        super(driver);
    }

    // Step2 -> Locators for Account Registration page elements
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement txtFirstName; // First Name input field

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement txtLastName; // Last Name input field

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement txtEmail; // Email input field

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement txtTelephone; // Telephone input field

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement txtPassword; // Password input field  

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement txtConfirmPassword; // Confirm Password input field

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement chkPrivacyPolicy; // Privacy Policy checkbox

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue; // Continue button

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement txtSuccessMessage; // Success message after registration

    // Step3 -> Action Methods to interact with the elements

    public void enterFirstName(String firstname) {
        txtFirstName.sendKeys(firstname); // Enter first name
    }

    public void enterLastName(String lastname) {
        txtLastName.sendKeys(lastname); // Enter last name
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email); // Enter email address
    }

    public void enterTelephone(String telephone) {
        txtTelephone.sendKeys(telephone); // Enter telephone number
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password); // Enter password
    }

    public void enterConfirmPassword(String Password) {
        txtConfirmPassword.sendKeys(Password); // Enter confirm password
    }

    public void clickOnPrivacyPolicy() {
        chkPrivacyPolicy.click(); // Click privacy policy checkbox
    }

    public void clickOnContinue() {
        btnContinue.click(); // Click continue button

        // Alternative to submit the form if above line is not working
        // btnContinue.submit();
    }

    public String getRegistrationSuccessMessage() {
        try {
            return txtSuccessMessage.getText(); // Return success message text
        } catch(Exception e) {
            return (e.getMessage()); // Return exception message if element not found
        }
    }

    public void zoomOut() {
        JavascriptExecutor js = (JavascriptExecutor) driver; // Cast driver to JavascriptExecutor
        js.executeScript("document.body.style.zoom='80%'"); // Zoom out page to 80%
    }
}
