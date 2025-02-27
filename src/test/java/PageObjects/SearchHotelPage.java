package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class SearchHotelPage extends Basepage {
WebDriver driver;

public SearchHotelPage(WebDriver driver) {
	super(driver);
}

		@FindBy(id="location")
     WebElement locationDropdown;

		@FindBy(id="hotels")
	     WebElement hotelsDropDown;

    @FindBy(id="room_type")
     WebElement roomTypeDropdown;
    
    @FindBy(id="room_nos")
    WebElement numberOfRoomsDropdown;
    
    @FindBy(id="datepick_in")
    WebElement checkInDatePicker;
    
    @FindBy(id="datepick_out")
    WebElement checkOutDatePicker;
    
    @FindBy(id="adult_room")
    WebElement adultsPerRoomDropDown;
    
    @FindBy(id="child_room")
    WebElement childrenPerRoomDropDown;
   
    
    @FindBy(id="Submit")
     WebElement searchButton;
    
    @FindBy(id="radiobutton_0")
    WebElement radioButton;
   
    
    @FindBy(id="continue")
    WebElement continueButton;
    
    
   //Actions
   
   
  public void selectLocation(String location) {
        locationDropdown.sendKeys(location);
    }
    public void selectHotels(String hotels) {
        hotelsDropDown.sendKeys(hotels);
    }

    public void selectRoomType(String roomType) {
        roomTypeDropdown.sendKeys(roomType);
    }
    public void selectNumberOfRooms(String numberOfRooms) {
        numberOfRoomsDropdown.sendKeys(numberOfRooms);
    }
    public void selectCheckInDate(String checkIn) {
    	checkInDatePicker.sendKeys(checkIn);
    }
    
    public void selectCheckOutDate(String checkOut) {
        checkOutDatePicker.sendKeys(checkOut);
    }
    public void selectAdultsPerRoom(String adultsPerRoom) {
        adultsPerRoomDropDown.sendKeys(adultsPerRoom);
    }
    public void selectChildrenPerRoom(String childrenPerRoom) {
        childrenPerRoomDropDown.sendKeys(childrenPerRoom);
    }
    
    public void clickSearch() {
        searchButton.click();
    }
    
    public void clickradioButton() {
        radioButton.click();
    }
    
    public void clickContinue() {
        continueButton.click();
    }
} 
