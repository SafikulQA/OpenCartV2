package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class MyAccPage extends BasePage{
	
	//WebDriver driver; //Removed the unused instance variable WebDriver driver; since it's already inherited from BasePage.
	
	// Constructor - Mandatory for every child page object class
	public MyAccPage(WebDriver driver)
	{
	super(driver);
	}
	
	
	//Locators -2
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  //added in step-6
	private WebElement lnkLogout;

	
	
	
	//Action Methods -3

     /*	Checks if the My Account page is displayed by verifying the heading.
     @return true if displayed, false otherwise	*/
	
	public boolean isMyAccPageExists()
	{
		try {
		
			return (msgHeading.isDisplayed());		//if it is displayed return true
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
