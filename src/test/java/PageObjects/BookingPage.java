package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage extends Basepage {
WebDriver driver;

public BookingPage(WebDriver driver) {
	super(driver);
}
  @FindBy(id = "first_name")
		    WebElement firstNameField;

		   @FindBy(id = "last_name")
		   WebElement lastNameField;

		   @FindBy(id = "address")
		    WebElement addressField;

		   @FindBy(id = "cc_num")
		    WebElement creditCardNumberField;
		   
		   
		   @FindBy(id = "cc_type")
		   WebElement creditCardTypeField;
		   
		  @FindBy(id = "cc_exp_month") 
		  WebElement expiryDateMonthDropDown;
		  
		  
		  @FindBy(id = "cc_exp_year") 
		  WebElement expiryDateYearDropDown;
		  
		  @FindBy(id = "cc_cvv")
		  WebElement cvvNumberField;
		   
		@FindBy(id = "book_now")
		    WebElement bookNowButton;

	   
		public void enterFirstName(String firstName) {
	        firstNameField.sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        lastNameField.sendKeys(lastName);
	    }

	    public void enterAddress(String address) {
	        addressField.sendKeys(address);
	    }

	    public void enterCreditCard(String creditCardNumber) {
	        creditCardNumberField.sendKeys(creditCardNumber);
	    }
	    
	    public void selectCreditCardType(String creditCardType) {
	        creditCardTypeField.sendKeys(creditCardType);
	    }
	    public void selectExpiryDateMonthField(String expiryDateMonth) {
	        expiryDateMonthDropDown.sendKeys(expiryDateMonth);
	    }
	    public void selectExpiryDateYearField(String expiryDateYear) {
	    	expiryDateYearDropDown.sendKeys(expiryDateYear);
	    }
	    public void enterCvvNumber(String cvvNumber) {
	        cvvNumberField.sendKeys(cvvNumber);
	    }

	    public void clickBookNow() {
	        bookNowButton.click();
	    }
	    public void handleSaveCardPopup(String action) {
	        try {
	            // Switch to the alert
	            Alert alert = driver.switchTo().alert();
	            // Perform the desired action based on the parameter
	            if (action.equalsIgnoreCase("save")) {
	                alert.accept(); // Accepts the alert (click Save)
	            } else if (action.equalsIgnoreCase("no")) {
	                alert.dismiss(); // Dismisses the alert (click No Thanks)
	            }
	        } catch (Exception e) {
	            System.out.println("No alert pop-up appeared.");
	        }
	 
	    		
	    }
	}
	

	    
	    
	   