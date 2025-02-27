

package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PageObjects.BookingConfirmationPage;
import PageObjects.BookingPage;
import PageObjects.LogOutPage;
import PageObjects.LoginPage;
import PageObjects.SearchHotelPage;
import TestBase.BaseClass;



public class LogOutPageTest  extends BaseClass{
   
	 @Test
	 public void testBookingConfirmationPage() throws InterruptedException {
		 
	 
	        	LoginPage loginPage = new LoginPage(driver)	;   
	       	 loginPage.enterUsername("AparnaViyyapu");
	            loginPage.enterPassword("Aparna99$");
	            loginPage.clickLogin();

	      	  SearchHotelPage  searchHotelPage = new SearchHotelPage(driver);
	      	  
	            searchHotelPage.selectLocation("Melbourne");
	            searchHotelPage.selectHotels("Hotel Sunshine");
	            searchHotelPage.selectRoomType("Standard");
	            searchHotelPage.selectNumberOfRooms("2 - Two");
	            searchHotelPage.selectCheckInDate("27/02/2025");
	            searchHotelPage.selectCheckOutDate("01/03/2025");
	            searchHotelPage.selectAdultsPerRoom("4 - Four");
	            searchHotelPage.selectChildrenPerRoom("2 - Two");
	           searchHotelPage.clickSearch();
	            searchHotelPage.clickradioButton();
	            searchHotelPage.clickContinue();
	            

	      	  BookingPage  bookingPage = new BookingPage(driver);
	      	  
	            bookingPage.enterFirstName("Aparna");
	            bookingPage.enterLastName("Viyyapu");
	            bookingPage.enterAddress("123 James Street,Melbourne");
	            bookingPage.enterCreditCard("1234567898765437");
	            bookingPage.selectCreditCardType("VISA");
	            bookingPage.selectExpiryDateMonthField("September");
	            bookingPage.selectExpiryDateYearField("2029");
	            bookingPage.enterCvvNumber("123");
	            bookingPage.clickBookNow();

	 }

BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage(driver);


public void testSaveCardAlert_SaveOption() {
    // Handle alert by choosing "Save"
    bookingConfirmationPage.handleSaveNoThanksAlert(true);

    // Assert that the page title contains "Booking Confirmation"
    Assert.assertTrue(bookingConfirmationPage.getPageTitle().contains("Booking Confirmation"),
            "The page title does not match the expected title after clicking Save.");
}


public void testSaveCardAlert_NoThanksOption() {
    // Handle alert by choosing "No Thanks"
    bookingConfirmationPage.handleSaveNoThanksAlert(false);

    // Assert that the page title contains "Booking Confirmation"
    Assert.assertTrue(bookingConfirmationPage.getPageTitle().contains("Booking Confirmation"),
            "The page title does not match the expected title after clicking No Thanks.");



           
     LogOutPage logoutPage = new LogOutPage(driver);
        logoutPage.clickLogout();
           
    
}

    

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
