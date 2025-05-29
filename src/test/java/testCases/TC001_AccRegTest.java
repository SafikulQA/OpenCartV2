package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.AccRegPage;
import pages.HomePage;
import pages.MyAccPage;

public class TC001_AccRegTest extends BaseTest {

    @Test(groups = {"Regression", "Master"})
    public void verify_AccReg() throws InterruptedException {

        logger.info("Test Case TC001_AccRegTest Started");

        try {
            // Initialize HomePage object to interact with home page elements
            HomePage hPage = new HomePage(driver);
            
            hPage.clickOnMyAccount();
            logger.info("Clicked on 'My Account'");

            hPage.clickOnRegister();
            logger.info("Clicked on 'Register'");

            Thread.sleep(2000);  // Wait for the registration page to load

            // Zoom out the page to 80% to avoid UI issues during form filling
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='80%'");

            // Initialize AccRegPage object to access registration page elements
            AccRegPage accReg = new AccRegPage(driver);
            logger.info("Filling in registration details");

            // Enter random user data for registration
            accReg.enterFirstName(randomNameString());
            accReg.enterLastName(randomNameString());
            accReg.enterEmail(randomEmailString());
            accReg.enterTelephone(randomNumberString());

            // Generate and enter a random password for both password fields
            String password = randomPasswordString();
            accReg.enterPassword(password);
            accReg.enterConfirmPassword(password);

            Thread.sleep(2000);

            // Agree to the Privacy Policy
            accReg.clickOnPrivacyPolicy();
            logger.info("Checked 'Privacy Policy'");

            Thread.sleep(2000);

            // Submit the registration form
            accReg.clickOnContinue();
            logger.info("Clicked on 'Continue'");

            Thread.sleep(2000);

            // Get and log the registration success message
            String confmsg = accReg.getRegistrationSuccessMessage();
            logger.info("Registration success message: " + confmsg);

            // Verify that registration was successful by checking the success message
            Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Registration failed or message mismatch.");

            logger.info("Registration successful, now logging out");

            // Initialize MyAccPage object to perform logout operation
            MyAccPage macc = new MyAccPage(driver);
            
            macc.clickOnLogout();
            logger.info("Clicked on Logout");

        } catch (Exception e) {
            logger.error("Exception in TC001_AccRegTest: ", e.getMessage());
            Assert.fail("Test case failed due to an exception.", e);
        }

        logger.info("Test Case TC001_AccRegTest Passed and Completed");
    }
}
