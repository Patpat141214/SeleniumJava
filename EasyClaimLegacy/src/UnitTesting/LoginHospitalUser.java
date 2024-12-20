package UnitTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginHospitalUser {
	WebDriver driver;
	String browser =  "google";
	String browser1 =  "firefox";
	String webUrl = "http://172.30.1.26/Published_eSOA4";

	
	@Test (priority = 1)
	public void Url() {
		
		Reporter.log("Starting the test and opening the browser...", true);
		driver = Utilities.CrossBrowsing.open(browser);
		driver.get(webUrl);
		driver.manage().window().maximize();
		 Reporter.log("Browser opened and navigated to URL: " + webUrl, true);
	}
	
	@Test (priority = 2)
	public void LogIn() {
		Reporter.log("Logging in with username: patche@admin", true);
		
		driver.findElement(By.id("Username")).sendKeys("patche@admin");
		driver.findElement(By.id("Password")).sendKeys("123123123");
		driver.findElement(By.id("submitBtn")).click();
		
		Reporter.log("Login submitted", true);
	}
	
	@Test (priority = 3)
	public void CreateHopistal() {
		Reporter.log("Navigate to Control Panel", true);
		WebElement cntrolPanel = driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text hiddenOnToggle' and text()='Control Panel']"));	    
		cntrolPanel.click();
	}
}
