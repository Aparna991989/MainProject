
package Tests;


import org.testng.Assert;

import org.testng.annotations.Test;
import PageObjects.LoginPage;
import TestBase.BaseClass;



public class LoginTest extends BaseClass {
    
          

    @Test(priority = 1)
    
    public void testValidLogin() throws Exception {
    	LoginPage loginPage = new LoginPage(driver);
    
        loginPage.enterUsername("AparnaViyyapu");
        loginPage.enterPassword("Aparna99$");
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("SearchHotel"), "Login failed");
        }

}
    
