package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccPage;

import java.time.Duration;

public class TC002_LoginTest extends BaseTest {

    @Test(groups = {"Sanity", "Master"})
    public void verify_Login() {
        logger.info("Test Case TC002_LoginTest Started");

        try {
            // Initialize HomePage object
            HomePage hPage = new HomePage(driver);

            // Click on 'My Account' menu
            hPage.clickOnMyAccount();
            logger.info("Clicked on My Account");

            // Wait for Login link using direct locator
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))); // Use your actual locator here

            // Click on Login
            hPage.clickOnLogin();
            logger.info("Clicked on Login");

            // Initialize LoginPage object
            LoginPage lPage = new LoginPage(driver);

            logger.info("Entering Login Credentials");

            // Enter email and password from properties file
            lPage.enterEmail(p.getProperty("email"));
            lPage.enterPassword(p.getProperty("password"));

            // Click on login button
            lPage.clickOnLogin();
            logger.info("Clicked on Login Button");

            // Initialize MyAccPage object and validate login success
            MyAccPage macc = new MyAccPage(driver);
            boolean targetPage = macc.isMyAccPageExists();
            logger.info("My Account page displayed: " + targetPage);

            // Assertion to confirm successful login
            Assert.assertTrue(targetPage, "Login failed: My Account page not displayed");
            
            logger.info("Login successful, now logging out");
            // Logout from the account
            macc.clickOnLogout();
            logger.info("Clicked on Logout");

        } catch (Exception e) {
            logger.error("Test Case TC002_LoginTest failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred in TC002_LoginTest", e);
        }

        logger.info("Test Case TC002_LoginTest Passed and Completed");
    }
}
