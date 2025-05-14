package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import baseClass.BaseTest;


import pages.AccRegPage;
import pages.HomePage;

public class TC001_AccRegTest extends BaseTest {
   
@Test(groups={"Regression","Master"})
    public void verify_AccReg() throws InterruptedException {

        logger.info("Test Case TC001_AccRegTest Started");

        try
        {
        // Create object of HomePage
        HomePage home = new HomePage(driver);
        
        home.clickOnMyAccount();
        logger.info("Clicked on My Account");
        home.clickOnRegister();
        logger.info("Clicked on Register");

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        // Create object of AccRegPage
        AccRegPage accReg = new AccRegPage(driver);

        logger.info("Entering Registration Details");
        
        accReg.enterFirstName(randomNameString());
        accReg.enterLastName(randomNameString());
        accReg.enterEmail(randomEmailString());
        accReg.enterTelephone(randomNumberString());

        //Here we store the password in a variable so that we can use it later for set confirm password filed also
        String password=randomPasswordString();
        accReg.enterPassword(password);
        accReg.enterConfirmPassword(password);

        Thread.sleep(2000);
        accReg.clickOnPrivacyPolicy();
        Thread.sleep(2000);
        accReg.clickOnContinue();
        Thread.sleep(2000);
        
        String confmsg=accReg.getRegistrationSuccessMessage();

        // Print the success message in the console
        System.out.println("Registration Success Message: " + confmsg);

        logger.info("Validating expected success message");
        
        if (confmsg.equals("Your Account Has Been Created!"))
         {
            Assert.assertTrue(true);
            logger.info("Test Case TC001_AccRegTest Passed");
        } 
        else 
        {
        	Assert.assertTrue(false);
            logger.error("Test Case TC001_AccRegTest Failed");
            logger.debug("Debug logs");
        }

        // Assert the expected message
       // Assert.assertEquals(confmsg, "Your Account Has Been Created");
        
        } 

    catch (Exception e)
    {
        Assert.fail();
    }
    logger.info("Test Case TC001_AccRegTest Completed");
    
}
}