package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// This is parent of all the Page object classes
public class BasePage {

    protected WebDriver driver;
    
    /*
     protected means:

The driver variable is accessible inside the BasePage class,

And inside any class that extends BasePage (like HomePage, SearchPage),

But not accessible from unrelated classes outside this inheritance hierarchy

Avoid public
If you make driver public, any other class can access and change it directly.

This breaks encapsulation (a core principle of OOP) and can lead to bugs or misuse.
     */
    
//Parent class Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
}
