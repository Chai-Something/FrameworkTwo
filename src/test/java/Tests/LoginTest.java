package Tests;//Specifies the package in which the LoginTest class is defined.

import Pages.HomePage;//Import the HomePage class from the Pages package, this test class will work with these page objects.
import Pages.LoginPage;//Import the LoginPage class from the Pages package, this test class will work with these page objects.
import jdk.jfr.Description;//Imports the Description annotation, which is used to provide a description for the test methods.
import org.testng.Assert;//Import brings in the TestNG Assert class, which is used to perform assertions to validate test results.
import org.testng.annotations.Test;//Import brings in the TestNG Test annotation, which is used to mark methods as test methods.

import static Utils.ExtentReports.ExtentTestManager.startTest;

public class LoginTest extends BaseTest{//Defines the LoginTest class, which extends a class named BaseTest.
    // The above suggests that LoginTest inherits behavior from BaseTest.
    HomePage home = new HomePage();//Create instances of the HomePage class
    LoginPage login = new LoginPage();//Create instances of the LoginPage class
    //The above instances will be used to interact with the web pages during the test.

    @Test()//This is a TestNG annotation that marks a method as a test method.
    public  void invalidLogin(){//This method is the first test case
        startTest("Invalid Login Scenario", "Invalid Login Scenario with incorrect username and password.");
        //The home instance of the HomePage class is used to access the navigateToUrl and navigateToLoginPage methods.
        home.navigateToUrl();
        home.navigateToLoginPage();
        //calling the EnterLoginDetails method on the login instance of the LoginPage class, passing in the email and password.
        login.EnterLoginDetails("Email@ABC.com", "Password123");
        //using the TestNG Assert.assertEquals method to check if the login attempt is unsuccessful.
        //It verifies that the text returned by VerifyUnsuccessfulLoginTxt matches the expected text.
        Assert.assertEquals(login.VerifyUnsuccessfulLoginTxt(),"Login was unsuccessful. Please correct the errors and try again.", "Incorrect error message displayed");
    }

    @Test()
    public void validLogin(){
        startTest("Valid Login Scenario", "Valid Login Scenario with correct username and password.");
        home.navigateToUrl();
        home.navigateToLoginPage();
        login.EnterLoginDetails("cyiwana@inspiredtesting.com","Chai123");
        Assert.assertEquals(login.VerifySuccessfulLogin(),"cyiwana@inspiredtesting.com", "Not Logged in !");
    }

    @Test()
    public void invalidEmailLogin(){
        startTest("Invalid Email Scenario", "Valid Login Scenario with incorrect username and correct password.");
        home.navigateToUrl();
        home.navigateToLoginPage();
        login.EnterLoginDetails("cyiwana","Chai123");
        Assert.assertEquals(login.VerifyInvalidEmailTxt(),"Please enter a valid email address.", "Incorrect message displayed");
    }
}
