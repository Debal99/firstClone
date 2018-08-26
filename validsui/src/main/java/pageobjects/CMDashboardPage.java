package pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class CMDashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//td//span[text()='Simple Case']")
	WebElement tabbedscreenflowlink;	
	
	@FindBy(xpath="//span[text()='My App']")
	WebElement applicationName;
	
	List<WebElement> simpleCase ;
	List<WebElement> simpleCaseID ;
	
	public CMDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void countNoOfSimpleCase(){
		driver.switchTo().frame("PegaGadget0Ifr");
		simpleCase = driver.findElements(By.xpath("//td//span[text()='Simple Case']"));
		simpleCaseID = driver.findElements(By.xpath("//td[@data-attribute-name='Case']//div//span//a"));
		HashMap<String,String> hm = new HashMap<String,String>();
		for(int i=0;i<simpleCase.size();i++) {
			hm.put(simpleCaseID.get(i).getText(),simpleCase.get(i).getText());
		}
		
		Set<Entry<String, String>> ent = hm.entrySet();
		for(Entry<String, String> m:ent) {
			System.out.println(m.getKey()+","+m.getValue());
		}
	}
	
	public String getApplicationName() {
	String appname;
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	driver.switchTo().frame("PegaGadget0Ifr");
	wait.until(ExpectedConditions.visibilityOf(applicationName));
	appname = applicationName.getText();
	return appname;
	}
}
