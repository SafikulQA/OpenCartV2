package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccPage;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseTest {
	
	//we need to specify dataProvider inside the @Test annotation and pass the dataProvider name from dataProvider class from utilities package
	// and also need to add additional staff because the dataProider method is not present in the same or this class or package 
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")	//getting DataProvider from different class
	public void verify_LoginDDT(String email, String pwd, String expres) throws InterruptedException 
	{
		logger.info("Starting TC003_LoginDDT");
		
		try
		{
		//create object of HomePage
		HomePage hPage=new HomePage(driver);
		hPage.clickOnMyAccount();
		logger.info("Clicked on My Account");
		Thread.sleep(2000);
		hPage.clickOnLogin();
		logger.info("Clicked on Login");
		
		// Create object of LoginPage
		LoginPage lPage=new LoginPage(driver);
		
		logger.info("Entering Login Details");
		
		//Here we pass email and password from the properties file
		lPage.enterEmail(email);
		lPage.enterPassword(pwd);
		Thread.sleep(2000);
		lPage.clickOnLogin();
		
		// Create object of MyAccPage
		MyAccPage macc=new MyAccPage(driver);
		boolean targetPage=macc.isMyAccPageExists();
		
		System.out.println("My account page Diplayed : "+targetPage);
		
		/*
	 	data is valid - login success - test pass - logout
	 	 				login failed - test fail
	 	
	   */
		
		if(expres.equalsIgnoreCase("Valid"))	//data is Valid
		{
			if(targetPage==true)	//login is successful
			{
				// assertion always should be after the action method because after the assertion no statement  will be executed
				
				macc.clickOnLogout();	//logout
				Assert.assertTrue(true);	//test is passed
				      
				
			}
			else	//login failed
			{
				Assert.assertTrue(false);	//test is failed
			}
		}
		
		/*	
		 	data is invalid - login success - test fail - logout
		    login failed - test pass 
		  
		 */
		
		if(expres.equalsIgnoreCase("Invalid"))	//data is Invalid
		{
			if(targetPage==true)	//login is successful
			{
				// assertion always should be after the action method because after the assertion no statement  will be executed
				
				macc.clickOnLogout();	//logout
				Assert.assertTrue(false);	//test is failed
			}
			else 
			{
				Assert.assertTrue(true);	//test passed
			}
					
		}
		
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		
		Thread.sleep(3000);
		logger.info("Successfully completed TC003_LoginDDT");

		
	}
	
	

}
