package Pages;//specifies the package in which the LoginPage class is defined.

import Utils.ExtentReports.ExtentTestManager;
import Utils.Logs.Log;//Imports the Log class located in the Logs package within the Utils package. It's used for logging messages during the test execution.
import org.apache.logging.log4j.internal.LogManagerStatus;
import org.openqa.selenium.By;//Imports the By class, which is used for locating web elements on a web page.
    //It provides various methods for locating elements by different criteria, such as ID, class name, XPath, etc.

public class LoginPage extends BasePage{//Defines the LoginPage class, which extends a class named BasePage.
    // The above suggests that LoginPage inherits behavior from BasePage.
    private final By emailField = By.id("Email");//Declares a private constant By object named emailField,
        //used to locate the email input field on the login page using its ID attribute.
    private final By passwordField = By.id("Password");
    private final By loginBtn = By.className("login-button");//Declares a private constant By object named loginBtn,
        //used to locate the login button on the login page using its class name.
    private final By loggedInEmailAccLinkTxt = By.xpath("//div[@class='header-links']//a[@class='account']");
    //Declares a private constant By object named loggedInEmailAccLinkTxt, used to locate an element on the login page using it a xpath.
    private final By loginErrorTxt = By.xpath("//div[@class='validation-summary-errors']//span");
    private final By invalidEmailTxt = By.className("field-validation-error");


    //This method is used to enter login details, It uses the provided email and password parameters and interacts with
        //the respective input fields and the login button on the page. Logging is also performed to track this action.
    public void EnterLoginDetails(String email, String password){
        Log.info("Entering Login details");
        writeText(emailField, email);
        ExtentTestManager.getTest().pass("Successfully entered Email: " + email);
        writeText(passwordField, password);
        ExtentTestManager.getTest().pass("Successfully entered password: " + password);
        click(loginBtn);
        ExtentTestManager.getTest().pass("Successfully clicked Login Button");
    }
    //This method is used to verify a successful login by reading and returning the text from the element displaying
        //the logged-in user's email. Logging is used to provide information about this verification step.
    public String VerifySuccessfulLogin(){
        Log.info("Verifying Successful Login Text");
        ExtentTestManager.getTest().pass("Successfully verified '"+readText(loggedInEmailAccLinkTxt)+"' is displayed");
        return readText(loggedInEmailAccLinkTxt);
    }
    //This method is used to verify an unsuccessful login by reading and returning the text from the element that displays login error messages.
        //Logging is used to provide information about this verification step.
    public String VerifyUnsuccessfulLoginTxt(){
        Log.info("Verifying Unsuccessful Login Text");
        ExtentTestManager.getTest().pass("Successfully verified '"+readText(loginErrorTxt)+"' is displayed");
        return readText(loginErrorTxt);
    }
    public String VerifyInvalidEmailTxt(){
        Log.info("Verifying Unsuccessful Login Text");
        ExtentTestManager.getTest().pass("Successfully verified '"+readText(invalidEmailTxt)+"' is displayed");
        return readText(invalidEmailTxt);
    }
}
