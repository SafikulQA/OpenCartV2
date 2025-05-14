package baseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeMethod(groups = { "Sanity", "Regression", "Master" })
    @Parameters({ "os", "browser" })
    public void setup(String os, String browser) throws IOException {
        // Load config.properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        // Initialize log4j2 logger
        logger = LogManager.getLogger(this.getClass().getName());

        // Remote execution (Selenium Grid)
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), chromeOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), edgeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), firefoxOptions);
                    break;
                default:
                    System.out.println("Please provide a correct browser name");
                    return;
            }
        }
        // Local execution
        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (browser.toLowerCase())
            {
                case "chrome":	driver = new ChromeDriver();	break;
                   
                case "edge":	driver = new EdgeDriver();	break; 
                    
                case "firefox":	driver = new FirefoxDriver();	break;
                    
                default: System.out.println("Please provide a correct browser name");	 return;
                	   	
            }
        }

        driver.manage().deleteAllCookies();
        driver.get(p.getProperty("appURL")); // Read URL from properties file
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(groups = { "Sanity", "Regression", "Master" })
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Generate random strings
    public String randomNameString() {
        return RandomStringUtils.randomAlphabetic(5).toUpperCase();
    }

    public String randomEmailString() {
        return RandomStringUtils.randomAlphanumeric(7) + "@gmail.com";
    }

    public String randomNumberString() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomPasswordString() {
        return RandomStringUtils.randomAlphanumeric(7) + "@";
    }

    // Capture screenshot
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
