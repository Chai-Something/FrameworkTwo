package Utils;//specifies the package in which the DriversManager class is defined.

import Utils.Logs.Log;//Imports the Log class from the Utils.Logs package, which is used for logging messages.
import io.github.bonigarcia.wdm.WebDriverManager;//Imports the WebDriverManager, a library that simplifies the management of web driver binaries.
import org.openqa.selenium.WebDriver;//Imports the WebDriver interface, which represents the web browser instance.
import org.openqa.selenium.chrome.ChromeDriver;//Imports the ChromeDriver class, which implements the WebDriver interface and is used to automate interactions with the Chrome browser.
import org.openqa.selenium.edge.EdgeDriver;//Imports the EdgeDriver class, used to automate interactions with the Microsoft Edge browser.
import org.openqa.selenium.firefox.FirefoxDriver;//Imports the FirefoxDriver class, used to automate interactions with the Firefox browser.

/*
 * The code dynamically initializes the appropriate WebDriver based on the specified browser or falls back to Chrome if the browser is not recognized.
 */

public class DriversManager {
    private static WebDriver driver;//Declares a static private variable named driver, which will store the WebDriver instance.
        //It's declared as static to ensure there's only one instance of the driver across all instances of the DriversManager class.
    public static WebDriver getWebDriver(){//A public static method named getWebDriver(), which returns the WebDriver instance.
            //This method is used to get the active WebDriver instance.
        return driver;
    }
    public static WebDriver initialiseDriver(){//A public static method named initialiseDriver(), responsible for initializing the WebDriver instance
            //based on the browser specified in the system properties.
        String browser = System.getProperty("browser");//retrieves the value of the "browser" system property.
            //The property should be set when running the program to specify the desired browser.
        Log.info("initialising "+ browser + " Driver");//logs an informational message using the Log class. It records which browser driver is being initialized.
        switch (browser.toUpperCase()){//a switch statement that processes the value of the "browser" system property in uppercase.
            case "CHROME"://If the specified browser is "CHROME," we sets up the ChromeDriver using WebDriverManager and initializes it as driver.
                WebDriverManager.chromedriver().setup();//using WebDriverManager to set up the ChromeDriver. It ensures that the required ChromeDriver binary is downloaded and configured for use in the project.
                driver = new ChromeDriver();//Initializes the driver as a new instance of the ChromeDriver, which is used for automated testing in the Chrome browser.
                break;
            case "EDGE"://If the specified browser is "EDGE," we sets up the EdgeDriver using WebDriverManager and initializes it as driver.
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "FIREFOX"://If the specified browser is "FIREFOX," we sets up the FirefoxDriver using WebDriverManager and initializes it as driver.
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default://If the specified browser is not recognized or missing, we log a warning message and initializing the ChromeDriver.
                Log.warn("Unable to find "+ browser);//logs a warning message indicating that the browser wasn't found or specified correctly.
                Log.info("initialising Chrome Driver");//logs an informational message that indicates the fallback behavior, which is initializing the ChromeDriver.
                WebDriverManager.chromedriver().setup();//WebDriverManager is used to set up the ChromeDriver, even if the browser is not recognized.
                driver = new ChromeDriver();//It initializes the driver as a new instance of the ChromeDriver as the default choice for browser testing.
        }
        driver.manage().window().maximize();//maximizes the browser window after initializing the driver.
        return driver;//The method returns the initialized WebDriver instance.
    }
}
/*
 * The DriversManager class is a utility class that simplifies WebDriver management and initialization.
 * It allows you to specify the browser to use via system properties and provides logging information about the initialization process.
 * The getWebDriver method allows other parts of the code to access the active WebDriver instance.
 */