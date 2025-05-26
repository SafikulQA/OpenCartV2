package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class TC005_AddToCartPageTest extends BaseTest {
    
    @Test(groups = {"Sanity", "Master"})
    public void verify_productSearch() {
        
        logger.info("********** Starting TC005_AddToCartPageTest **********");
        
        try 
        {
            // Navigate to homepage and search for product
            HomePage hPage = new HomePage(driver);
            hPage.enterProductName("iPhone");
            logger.info("Entered product name: iPhone");
            hPage.clickSearch();
            logger.info("Clicked on search button");
            
            // Search result page actions
            SearchPage sPage = new SearchPage(driver);
            if (sPage.isProductExist("iPhone")) 
            {
                logger.info("Product found in search results");
                
                sPage.selectProduct("iPhone");
                logger.info("Selected product: iPhone");
                
                sPage.setQuantity("2");
                logger.info("Set quantity: 2");
                
                sPage.addToCart();
                logger.info("Clicked on Add to Cart");
            } 
            else 
            {
                logger.warn("Product not found in search results");
                Assert.fail("Product 'iPhone' not found");
            }
            
            // Validate confirmation message
            Assert.assertTrue(sPage.chkCnfMsg(), "Confirmation message not displayed");
            logger.info("Product successfully added to cart");

        } 
        catch (Exception e) 
        {
            logger.error("Exception occurred in TC005_AddToCartPageTest: " + e.getMessage());
            Assert.fail("Test failed due to exception");
        }

        logger.info("********** Finished TC005_AddToCartPageTest **********");
    }
}
