package Pages;//specifies the package in which the HomePage class is defined.

import Utils.DriversManager;//Imports the DriversManager class, which is responsible for initializing and managing web drivers.
import Utils.Logs.Log;//Imports the Log class, used for logging messages during the test execution.
import org.openqa.selenium.By;//Imports the By class, which is used for locating web elements on a web page.
import org.testng.Assert;//Imports TestNG's Assert class, which is used for making assertions and verifying conditions during test execution.

public class HomePage extends BasePage{//defines the HomePage class, which extends the BasePage class.
        //It indicates that the HomePage class inherits behavior and properties from the BasePage class, following the page object design pattern.
    //Header Links - These elements represent links in the header of the page
    private final By registrationLink = By.className("ico-register");
    private final By loginLink = By.className("ico-login");
    private final By shoppingCartLink = By.xpath("//a[@class='ico-cart']//span[@class='cart-label']");
    private final By wishLink = By.xpath("//a[@class='ico-wishlist']//span[@class='cart-label']");
    private final By SearchTxtBox = By.id("");
    private final By SearchBtn = By.id("");
    //Navigation Buttons - These elements represent navigation buttons
    private final By booksNavBtn = By.id("");
    private final By computersNavBtn = By.id("");
    private final By ElectronicsNavBtn = By.id("");
    private final By apparelShoesNavBtn = By.id("");
    private final By DigitalDownloadsNavBtn = By.id("");
    private final By JewelryNavBtn = By.id("");
    private final By GiftCardNavBtn = By.id("");
    //Categories side navigation links

    //Manufactures

    //popular Tags

    //Home page
    private final By welcomeTxt = By.className("topic-html-content-header");
    //Newsletter

    //Community pool

    //featured products

    //footer navigation links
    public void navigateToUrl(){
        String baseURL = "https://demowebshop.tricentis.com/";//Defining the base URL as a string.
        Log.info("Navigating to " + baseURL);//logs an informational message indicating that the script is navigating to the specified URL.
        DriversManager.getWebDriver().get(baseURL);//retrieves the web driver instance using DriversManager, and the get method is used to open the specified URL in the web browser.
        Assert.assertEquals(readText(welcomeTxt),"Welcome to our store", "Unable to find text");//verifies that the text located by the welcomeTxt element
    }
    public void navigateToRegistrationPage(){
        Log.info("Click Login Page ");//logs an informational message indicating that the script is about to click the Registration page link.
        click(registrationLink);//performs a click action on the element located by the registrationLink locator. This action will take the user to the login page.

    }
    public void navigateToLoginPage(){
        Log.info("Click Login Page ");
        click(loginLink);

    }
    public void navigateToShoppingCartPage(){
        Log.info("Click Login Page ");
        click(shoppingCartLink);

    }
    public void navigateToWIshListPage(){
        Log.info("Click Login Page ");
        click(wishLink);

    }
}
