package Tests;//specifies the package in which the BaseTest class is defined.

import Utils.DriversManager;//Imports the DriversManager class from the Utils package. DriversManager is a utility class responsible for initializing and managing web drivers.
import Utils.Logs.Log;//Imports the Log class located in the Logs package within the Utils package. It's used for logging messages during the test execution.
import org.testng.annotations.AfterMethod;//Imports the AfterMethod annotation, used to mark a method as a teardown method that should run after each test method (annotated with @Test). It's used to perform cleanup tasks after each test.
import org.testng.annotations.BeforeMethod;//Imports the BeforeMethod annotation, which marks a method as a setup method that should run before each test method (annotated with @Test). It's used for setting up the test environment before running the actual test.
import org.testng.annotations.Parameters;//Imports the Parameters annotation, used to specify that the browserName parameter will be provided to the startTest method from the TestNG XML suite file. The browserName parameter is used to specify which web browser to use for testing.

import java.net.MalformedURLException;//is imported to handle exceptions related to malformed URLs.
    //This import is necessary because some methods might throw this exception when working with URLs.

public class BaseTest {
    @Parameters({"browserName"})//This annotation is used to specify that the browserName parameter will be
        // provided to this method from the TestNG XML suite file.
        //The browserName parameter will specify which web browser to use for testing.

    @BeforeMethod(alwaysRun = true)//This annotation marks the startTest method as a setup method that should run before
        //each test method (annotated with @Test). The alwaysRun = true attribute ensures that this method is executed even if the previous test method fails.
    public void startBrowser(String browserName) throws MalformedURLException {//This method takes a browserName parameter
            // and is responsible for setting up the WebDriver for test execution.
        System.setProperty("browser", browserName);//sets the system property "browser" with the value of the browserName parameter.
        DriversManager.initialiseDriver();// calls the initDriver method from the Drivers class to initialize the WebDriver based on the specified browser.
    }

    @AfterMethod(alwaysRun = true)//This annotation marks the endTest method as a teardown method that should run after each test method (annotated with @Test).
    //Like the @BeforeMethod, alwaysRun = true ensures that this method is executed even if the previous test method fails.
    public void closeBrowser(){//This method is responsible for tearing down the WebDriver after the test method execution.
        Log.info("Tests are ending! closing browser");
        DriversManager.getWebDriver().quit();// calls the quit method on the WebDriver instance obtained from the Drivers class, which closes the browser window and releases resources.
    }
}
