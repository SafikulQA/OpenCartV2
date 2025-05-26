package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.AccRegPage;
import pages.HomePage;

public class TC001_AccRegTest extends BaseTest {

    @Test(groups = {"Regression", "Master"})
    public void verify_AccReg() throws InterruptedException {

        logger.info("Test Case TC001_AccRegTest Started");

        try {
            // Create object of HomePage
            HomePage hPage = new HomePage(driver);

            hPage.clickOnMyAccount();
            logger.info("Clicked on My Account");
            
            hPage.clickOnRegister();
            logger.info("Clicked on Register");

            Thread.sleep(2000);

            // Zoom out page to 80% - useful for some UI issues
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='80%'");

            // Create object of AccRegPage
            AccRegPage accReg = new AccRegPage(driver);

            logger.info("Entering Registration Details");

            accReg.enterFirstName(randomNameString());
            accReg.enterLastName(randomNameString());
            accReg.enterEmail(randomEmailString());
            accReg.enterTelephone(randomNumberString());

            // Store password in variable to reuse for confirmation
            String password = randomPasswordString();
            accReg.enterPassword(password);
            accReg.enterConfirmPassword(password);

            Thread.sleep(2000);

            accReg.clickOnPrivacyPolicy();
            Thread.sleep(2000);

            accReg.clickOnContinue();
            Thread.sleep(2000);

            String confmsg = accReg.getRegistrationSuccessMessage();
            logger.info("Registration Success Message: " + confmsg);

            // Validate success message
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
            logger.info("Test Case TC001_AccRegTest Passed");

        } catch (Exception e) {
            logger.error("Exception in TC001_AccRegTest: ", e);
            Assert.fail();
        }

        logger.info("Test Case TC001_AccRegTest Completed");
    }
}
