package POM.SimpleLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
private WebDriver driver;

 By usernamefield = By.id("username");
 By passwordfield = By.id("password");
 By loginBtn = By.cssSelector("#login > button");
 By errorMsg = By.id("flash");
 By successMsg = By.cssSelector(".flash.success");


public loginPage(WebDriver driver) {
	this.driver = driver;
}

public String validateloginpagetitle() {
	return driver.getTitle();
}

public void enterUsername(String username) {
	driver.findElement(usernamefield).sendKeys(username);
}

public void enterPassword(String password) {
	driver.findElement(passwordfield).sendKeys(password);
}
	
public void clickloginBtn() {
	driver.findElement(loginBtn).click();
	
}
	
public String errorMsg() {
	return driver.findElement(errorMsg).getText();

}

public String SuccessMsg() {
	return driver.findElement(successMsg).getText();
}

}


