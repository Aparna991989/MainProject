package Tests;


import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SearchHotelPage;
import TestBase.BaseClass;



public class SearchHotelTest extends BaseClass {
   
	 @Test(priority = 2)
   public void testSearchHotel() {
	        	
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
     
    }
     }

      
