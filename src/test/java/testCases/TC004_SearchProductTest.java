package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class TC004_SearchProductTest extends BaseTest {

    @Test(groups = {"Sanity", "Master"})
    public void verify_productSearch() {
        logger.info("Starting TC004_SearchProductTest");

        try {
            HomePage hPage = new HomePage(driver);

            // Step 1: Enter product name in the search box
            hPage.enterProductName("mac");
            logger.info("Entered product name: mac");

            // Step 2: Click on the search button
            hPage.clickSearch();
            logger.info("Clicked on Search button");

            // Step 3: Create SearchPage object and verify product presence
            SearchPage sPage = new SearchPage(driver);
            boolean isProductFound = sPage.isProductExist("MacBook");
            logger.info("Is 'MacBook' found in search results? : " + isProductFound);

            // Step 4: Assert the result
            Assert.assertTrue(isProductFound, "'MacBook' product was not found in the search results.");

        } catch (Exception e) {
            logger.error("Test execution failed due to: " + e.getMessage());
            Assert.fail("Exception during test execution: " + e.getMessage());
        }

        logger.info("Finished TC004_SearchProductTest");
    }
}
