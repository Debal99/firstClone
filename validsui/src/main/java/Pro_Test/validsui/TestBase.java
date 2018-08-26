package Pro_Test.validsui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase{
	
	public WebDriver driver;
	public String sutURL;
	public String username;
	public String password;
	
	public TestBase(){
		
	}
	
	
	
	public void loadData() throws IOException {
		File file = new File("C:\\Users\\Debal\\Desktop\\WSREPO\\validsui\\src\\test\\java\\data\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		sutURL = prop.getProperty("sutURL");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		
	}
	public void init() throws Exception {
		loadData();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Debal\\Desktop\\WSREPO\\validsui\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(sutURL);
		driver.manage().window().maximize();
	}
	public void takescreenshots() throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Debal\\Desktop\\WSREPO\\validsui\\Screenshots\\dest.png");
		FileUtils.copyFile(src, dest);
		
	}
	public void shutop() {
		driver.close();
	}
}
