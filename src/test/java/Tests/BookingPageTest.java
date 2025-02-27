
package Tests;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SearchHotelPage;
import TestBase.BaseClass;

import PageObjects.BookingPage;


public class BookingPageTest  extends BaseClass {
   
	 @Test
	 public void testBookingPage() throws InterruptedException {
		 
	 
	        	LoginPage loginPage = new LoginPage(driver)	;   
	       	 loginPage.enterUsername("AparnaViyyapu");
	            loginPage.enterPassword("Aparna99$");
	            loginPage.clickLogin();

	      	  SearchHotelPage  searchHotelPage = new SearchHotelPage(driver);
	      	  
	            searchHotelPage.selectLocation("Melbourne");
	            searchHotelPage.selectHotels("Hotel Sunshine");
	            searchHotelPage.selectRoomType("Standard");
	            searchHotelPage.selectNumberOfRooms("2 - Two");
	            searchHotelPage.selectCheckInDate("27/2/2025");
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
}
