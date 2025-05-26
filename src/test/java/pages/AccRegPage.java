package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AccRegPage extends BasePage {

    //WebDriver driver; //Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
    
    // child class constructor -1 Mandatory step for every child page object class
    
    public AccRegPage(WebDriver driver) {
        super(driver);
    }

    //Locators -2
    @FindBy(xpath="//input[@id='input-firstname']")
    private WebElement txtFirstName;

    @FindBy(xpath="//input[@id='input-lastname']")
    private WebElement txtLastName;

    @FindBy(xpath="//input[@id='input-email']")
    private WebElement txtEmail;

    @FindBy(xpath="//input[@id='input-telephone']")
    private WebElement txtTelephone;

    @FindBy(xpath="//input[@id='input-password']")
    private WebElement txtPassword;  
    
    @FindBy(xpath="//input[@id='input-confirm']")
    private WebElement txtConfirmPassword;

    @FindBy(xpath="//input[@name='agree']")
    private WebElement chkPrivacyPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement txtSuccessMessage;

    //Action Methods -3
    public void enterFirstName(String firstname) {
        txtFirstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        txtLastName.sendKeys(lastname);
    }
    public void enterEmail(String email) {
        txtEmail.sendKeys(email);   
    }

    public void enterTelephone(String telephone) {
        txtTelephone.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String Password) {
        txtConfirmPassword.sendKeys(Password);
    }

    public void clickOnPrivacyPolicy() {
        chkPrivacyPolicy.click();
    }
    public void clickOnContinue() {
        btnContinue.click();

        // solution if above line is not working
        // btnContinue.submit();
    }

    public String getRegistrationSuccessMessage() {

        try
        {
        	return txtSuccessMessage.getText();
        }
        catch(Exception e)
        {
            return (e.getMessage());
        }
    }
    
    public void zoomOut() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='80%'");
            
}
}
