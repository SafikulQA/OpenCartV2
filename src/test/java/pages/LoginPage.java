package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LoginPage extends BasePage{
	
	//WebDriver driver; //Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
	
   // Constructor - Mandatory for every child page object class
    
    public  LoginPage(WebDriver driver) 
    {
            super(driver);
        }
    
//Locators -2
    @FindBy(xpath="//input[@id='input-email']")
    private WebElement txtEmailAddress;
    
    @FindBy(xpath="//input[@id='input-password']")
    private WebElement txtPassword;
    
    @FindBy(xpath="//input[@value='Login']")
    private WebElement btnLogin;
    
//Action Methods -3 
    
    public void enterEmail(String email)
    {
    	txtEmailAddress.sendKeys(email);
    }
    
    public void enterPassword(String password)
    {
    	txtPassword.sendKeys(password);
    }
    
    public void clickOnLogin()
    {
    	btnLogin.click();
    }
    

}

