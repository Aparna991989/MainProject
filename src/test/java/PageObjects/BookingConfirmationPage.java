package PageObjects;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingConfirmationPage extends Basepage {
static WebDriver driver;

public BookingConfirmationPage(WebDriver driver) {
	super(driver);
}

    // Locators for the Save/No Thanks dialog box
    @FindBy(xpath = "//button[contains(text(),'Save')]")
     WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(),'No thanks')]")
     WebElement noThanksButton;

    

    // Actions
    // Method to handle "Save/No Thanks" confirmation alert
    
    public  void handleSaveNoThanksAlert(boolean saveCard) {
        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Check action to perform
        if (saveCard) {
            alert.accept(); // Clicks "Save" (OK)
        } else {
            alert.dismiss(); // Clicks "No Thanks" (Cancel)
        }
    }

    // Method to get the title of the page for verification
    public  String getPageTitle() {
        return driver.getTitle();
    }


		
	
}
