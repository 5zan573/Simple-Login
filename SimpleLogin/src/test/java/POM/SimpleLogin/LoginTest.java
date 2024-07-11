package POM.SimpleLogin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
	
	loginPage LoginPage;
	
	@BeforeMethod
	public void setUp() {
		super.setUp();
		
		LoginPage = new loginPage(driver);
	}
	
	@Test
	public void testlogin() throws InterruptedException {
		LoginPage.enterUsername("tomsmith");
		LoginPage.enterPassword("SuperSecretPassword!");
		LoginPage.clickloginBtn();
		
		String expectedMsg = "You logged into a secure area!";
		String actualMsg = LoginPage.SuccessMsg();
		Assert.assertTrue(actualMsg.contains(expectedMsg),"Login was not Sucessful.");
		
		}
	
    @Test
	public void testInvalidUsername() {
    	LoginPage.enterUsername("tom");
    	LoginPage.enterPassword("SuperSecretPassword!");
    	LoginPage.clickloginBtn();
		LoginPage.errorMsg();
		Assert.assertTrue(LoginPage.errorMsg().contains("Your username is invalid!"));
		
	}
    
    @Test
    public void testInvalidPassword() {
    	LoginPage.enterUsername("tomsmith");
    	LoginPage.enterPassword("InvalidPassword");
    	LoginPage.clickloginBtn();
    	LoginPage.errorMsg();
    	Assert.assertTrue(LoginPage.errorMsg().contains("Your password is invalid!"));
    }
    
    @Test
    public void testEmptyfields() {
    	LoginPage.clickloginBtn();
    	Assert.assertTrue(LoginPage.errorMsg().contains("Your username is invalid!"));
    }
    
	@Test
	public void verifytitleTest() {
		String title = LoginPage.validateloginpagetitle();
		Assert.assertEquals(title, "The Internet");
	}
	
}
