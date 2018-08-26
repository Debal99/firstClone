package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
		
	WebDriver driver;
	
	@FindBy(id="txtUserID")
	WebElement loginUsername;
	
	@FindBy(id="txtPassword")
	WebElement loginPassword;
	
	@FindBy(id="sub")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username,String password) {
		loginUsername.sendKeys(username);
		loginPassword.sendKeys(password);
		loginButton.click();
	}

}
