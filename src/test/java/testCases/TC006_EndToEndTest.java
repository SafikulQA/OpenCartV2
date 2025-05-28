package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseTest;

public class TC006_EndToEndTest extends BaseTest {
    
    @Test(groups = {"Sanity", "Regression", "Master"})
    public void endToendTest() 
    {
        logger.info("********** Starting TC005_AddToCartPageTest **********");
        
        //Soft Assertion
        SoftAssert myAssert=new SoftAssert();
        
        //Account Registration
        
        System.out.println("Account Registartion Started............");
}
}

