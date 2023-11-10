package Pages;//specifies the package in which the BasePage class is defined.

import Utils.DriversManager;//Imports the DriversManager class, which is responsible for initializing and managing web drivers.
import org.openqa.selenium.By;//Imports the By class, which is used for locating web elements on a web page.

public class BasePage {
    public void click(By by){//This method takes a By locator as a parameter and performs a click action on the web element located by the specified locator.
        //Uses the WebDriver instance managed by DriversManager to find the element using the provided By locator and then performs a click action on it.
        DriversManager.getWebDriver().findElement(by).click();
    }
    public void writeText(By by, String text){//This method takes a By locator and a String text as parameters.
            //It is used to locate a web element using the specified By locator and then simulate entering the provided text into the element.
        DriversManager.getWebDriver().findElement(by).sendKeys(text);
    }
    public String readText(By by){//This method takes a By locator as a parameter and is used to locate a web element
            //using the specified By locator and retrieve the text content of the element.
        return DriversManager.getWebDriver().findElement(by).getText();//retrieves the text
    }
}