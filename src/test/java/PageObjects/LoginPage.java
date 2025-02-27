
package PageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage extends Basepage {
WebDriver driver;

public LoginPage(WebDriver driver) {
	super(driver);
}

	
	@FindBy(id = "username")
     WebElement usernameField;

    @FindBy(id = "password")
     WebElement passwordField;

    @FindBy(id = "login")
     WebElement loginButton;

    

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
