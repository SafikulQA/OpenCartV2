package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class MyAccPage extends BasePage{
	
	WebDriver driver;
	
	// child class constructor -1 Mandatory step for every child page object class
	public MyAccPage(WebDriver driver)
	{
	super(driver);
	}
	
	
	//Locators -2
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement masgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  //added in step-6
	private WebElement lnkLogout;

	
	
	
	//Action Methods -3
	
	public boolean isMyAccPageExists()
	{
		try {
		
			return (masgHeading.isDisplayed());		//if it is displayed return true
		}
		catch (Exception e) 
		{
			return false;
		}
		
	}
	
	public void clickOnLogout() 
	{
		lnkLogout.click();
	}
    
}
