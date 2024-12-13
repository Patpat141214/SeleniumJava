package SmokeTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	
	WebDriver driver;
	
	@Test
	public void loginElementPresentTest() {
		System.out.println("Runnning Test");
		
		
		boolean firstName =  driver.findElement(By.id("firstName")).isDisplayed();
		boolean lastName = driver.findElement(By.id("lastName")).isDisplayed();
		
		
		  Assert.assertTrue("First Name Present", firstName);
		Assert.assertTrue("Last Name is not present", lastName);
		
		
	}
	
	@BeforeMethod
	public void setUp ()
	{
		System.out.println("Starting Test");
		driver = utilities.DriverFactory.open("google");

		String webUrl = "https://demoqa.com/automation-practice-form";
		
		driver.get(webUrl);
	}
	
	public void tearDown() {
		System.out.println("Closing Test");
		driver.close();
	}
}
