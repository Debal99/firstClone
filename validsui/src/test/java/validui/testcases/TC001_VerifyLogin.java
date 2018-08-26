package validui.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pro_Test.validsui.TestBase;
import pageobjects.CMDashboardPage;
import pageobjects.LoginPage;

public class TC001_VerifyLogin extends TestBase {
	
	LoginPage loginpage; 
	CMDashboardPage cmd;
	
	@BeforeTest
	public void launchportal() throws Exception {
		init();	
		loginpage = new LoginPage(driver);
		cmd = new CMDashboardPage(driver);
		//hello
	}

	
	@Test
	public void login() {
		loginpage.login(username,password);	
		cmd.countNoOfSimpleCase();
	}

	
	@AfterTest
	public void logoff() {
		shutop();
	}
	
	
}
