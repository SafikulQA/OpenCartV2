package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccPage;

public class TC002_LoginTest extends BaseTest{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() throws InterruptedException
	{
		logger.info("Test Case TC002_LoginTest Started");
		
		try {
			
		// Create object of HomePage
		HomePage hpage=new HomePage(driver);
		hpage.clickOnMyAccount();
		logger.info("Clicked on My Account");
		Thread.sleep(2000);
		hpage.clickOnLogin();
		logger.info("Clicked on Login");
		
		// Create object of LoginPage
		LoginPage lPage=new LoginPage(driver);
		
		logger.info("Entering Login Details");
		
		//Here we pass email and password from the properties file
		lPage.enterEmail(p.getProperty("email"));
		lPage.enterPassword(p.getProperty("password"));
		Thread.sleep(2000);
		lPage.clickOnLogin();
		
		// Create object of MyAccPage
		MyAccPage macc=new MyAccPage(driver);
		boolean targetPage=macc.isMyAccPageExists();
		System.out.println("My account page Diplayed : "+targetPage);
		
		logger.info("Validating my account page is displayed");
		
		Assert.assertTrue(targetPage);	//Assert.assertEquals(targetPage, true, "Login failed");
		macc.clickOnLogout();
		
	}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Test Case TC002_LoginTest Passes");
		
	
	}

}
