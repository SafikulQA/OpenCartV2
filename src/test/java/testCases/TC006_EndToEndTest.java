package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseTest;
import pages.*;

public class TC006_EndToEndTest extends BaseTest {

    @Test(groups = {"Sanity", "Regression", "Master"})
    public void endToendTest() throws InterruptedException {

        // Start of End-to-End Test Case
        logger.info("********** Starting TC006_EndToEndTest **********");
        SoftAssert myAssert = new SoftAssert();  // Initialize Soft Assertion
        
        
        

        // ---------------- Test1: Account Registration ----------------
        
        

        System.out.println("Test Case TC001_AccRegTest Started.......");
        logger.info("Test Case TC001_AccRegTest Started");

        HomePage hPage = new HomePage(driver);  // Create Home Page object
        hPage.clickOnMyAccount();  // Click on 'My Account' menu
        hPage.clickOnRegister();   // Click on 'Register' option

        Thread.sleep(2000);  // Wait for registration page to load

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.body.style.zoom='80%'");  // Zoom out for better visibility

        AccRegPage accReg = new AccRegPage(driver);  // Create Account Registration page object
        accReg.enterFirstName(randomNameString());  // Enter First Name
        accReg.enterLastName(randomNameString());   // Enter Last Name
        accReg.enterEmail(randomEmailString());     // Enter unique Email
        accReg.enterTelephone(randomNumberString()); // Enter Phone Number

        String password = randomPasswordString();   // Generate random password
        accReg.enterPassword(password);             // Enter Password
        accReg.enterConfirmPassword(password);      // Confirm Password

        Thread.sleep(2000);
        accReg.clickOnPrivacyPolicy();              // Accept Privacy Policy
        Thread.sleep(2000);
        accReg.clickOnContinue();                   // Click on 'Continue' to register

        Thread.sleep(2000);
        String confmsg = accReg.getRegistrationSuccessMessage();  // Capture confirmation message
        logger.info("Registration success message: " + confmsg);

        myAssert.assertEquals(confmsg, "Your Account Has Been Created!", "Registration failed or message mismatch.");

        MyAccPage macc = new MyAccPage(driver);  // My Account Page object
        macc.clickOnLogout();                    // Logout after successful registration

        logger.info("Test Case TC001_AccRegTest Passed and Completed");
        Thread.sleep(3000);
        
        
        

        // ---------------- Test2: Account Login ----------------
        
        

        System.out.println("Test Case TC002_LoginTest Started........");
        logger.info("Test Case TC002_LoginTest Started........");

        hPage.clickOnMyAccount();  // Click on 'My Account'
        hPage.clickOnLogin();      // Click on 'Login'

        LoginPage lPage = new LoginPage(driver);  // Create Login Page object
        lPage.enterEmail(p.getProperty("email"));     // Enter Email
        lPage.enterPassword(p.getProperty("password"));// Enter Password
        lPage.clickOnLogin();                         // Click Login

        boolean targetPage = macc.isMyAccPageExists();  // Check if My Account page is displayed
        myAssert.assertTrue(targetPage, "Login failed: My Account page not displayed");

        logger.info("Test Case TC002_LoginTest Passed and Completed........");
        Thread.sleep(3000);
        
        
        

        // ---------------- Test4: Search Product ----------------
        
        

        System.out.println("Test Case TC004 Search Product Test Started.......");
        logger.info("Test Case TC004 Search Product Test Started.......");

        hPage.enterProductName(p.getProperty("searchProductName"));  // Enter product to search (e.g., MacBook)
        hPage.clickSearch();                                          // Click on Search button
        
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("document.body.style.zoom='80%'");  // Zoom out for better visibility

        SearchPage sPage = new SearchPage(driver);  // Create Search Page object
        boolean isProductFound = sPage.isProductExist(p.getProperty("searchProductName")); // Check if product exists

        myAssert.assertTrue(isProductFound, "'MacBook' product was not found in the search results.");
        logger.info("Test Case TC004 Search Product Test Passed and Completed.......");
        Thread.sleep(3000);
        
        
        

        // ---------------- Test5: Add to Cart ----------------
        
        
/*
        System.out.println("Test Case TC005 Add to Cart Items Started.....");
        logger.info("Test Case TC005 Add to Cart Items Started.....");

        if (sPage.isProductExist(p.getProperty("searchProductName"))) {
            sPage.selectProduct(p.getProperty("searchProductName"));  // Click on the product
            sPage.setQuantity("2");                                   // Set quantity to 2
            sPage.addToCart();                                        // Click Add to Cart
        }
        Thread.sleep(3000);

        myAssert.assertTrue(sPage.chkCnfMsg(), "Confirmation message not displayed");
        logger.info("Test Case TC005 Add to Cart Items Passed and Completed.....");
        
        
        

        // ---------------- Test6: Checkout Product ----------------
        
        

        System.out.println("Checkout Product Started......");
        logger.info("Checkout Product Started......");

        AddToCartPage addCartPage = new AddToCartPage(driver);  // Add to Cart page object
        addCartPage.clickItemsToNavigateToCart();               // Click cart icon
        addCartPage.clickViewCart();                            // Click View Cart

        Thread.sleep(3000);
        String totalPrice = addCartPage.getTotalPrice();        // Get total cart price
        System.out.println("Total Price of Add to Cart: " + totalPrice);

        myAssert.assertEquals(totalPrice, "$1,204.00");         // Verify total price

        addCartPage.clickCheckOut();                            // Proceed to checkout
        Thread.sleep(3000);

        CheckoutPage chkPage = new CheckoutPage(driver);        // Checkout page object

        // Fill Billing Details
        chkPage.enterFirstName(randomNameString());
        chkPage.enterLastName(randomNameString());
        chkPage.enterAddress1("address1");
        chkPage.enterAddress1("address2");  // Duplicate; consider replacing with enterAddress2()
        chkPage.enterCity("Kolkata");
        chkPage.enterPostCode("741126");
        chkPage.selectCountry("India");
        chkPage.selectState("West Bengal");
        chkPage.clickOnContinueAfterBillingAddress();           // Proceed from billing section

        chkPage.setCommentsAboutYourOrderElement("Testing");    // Add order comment
        chkPage.selectTermsAndCondition();                      // Accept terms
        chkPage.clickOnContinueAfterPaymentMethod();            // Proceed from payment method

        Boolean paymentWarning = chkPage.isPaymentWarningDisplayed(); // Check payment error message
        System.out.println("Is Warning Message Displayed? " + paymentWarning);
        myAssert.assertEquals(paymentWarning, true);            // Confirm warning shown due to missing payment method

        logger.info("Checkout Product Completed......");

        myAssert.assertAll();  // Check all soft assertion results
        logger.info("********** Completed TC006_EndToEndTest **********");
        
        */
    }
}
