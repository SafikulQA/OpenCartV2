package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
// child class constructor -1 Mandatory step for every child page object class
    
    public  LoginPage(WebDriver driver) 
    {
            super(driver);
        }
    
//Locators -2
    @FindBy(xpath="//input[@id='input-email']")
    private WebElement txtEmailAdders;
    
    @FindBy(xpath="//input[@id='input-password']")
    private WebElement txtPassword;
    
    @FindBy(xpath="//input[@value='Login']")
    private WebElement btnLogin;
    
//Action Methods -3 
    
    public void enterEmail(String email)
    {
    	txtEmailAdders.sendKeys(email);
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

