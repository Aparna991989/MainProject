
package PageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogOutPage extends Basepage {
WebDriver driver;

public LogOutPage(WebDriver driver) {
	super(driver);
}
 

    // Web Elements
    @FindBy(id = "logout")
    WebElement logoutButton;


    // Actions
    
    
    public void clickLogout() {
        logoutButton.click();
    }
  

    
} 
    



