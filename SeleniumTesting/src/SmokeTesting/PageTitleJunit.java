package SmokeTesting;

import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


public class PageTitleJunit {
	
	WebDriver driver;
	String webUrl = "https://demoqa.com/automation-practice-form";	
	@Test
	public void PageTitleTest() {
		System.out.println("Rrunning the test");

		  	 
		   driver.get(webUrl);
		   String actualTitle = driver.getTitle();
		   String expectedTitle = "DEMOQA";
		  Assert.assertEquals(expectedTitle, actualTitle);
		  //Assert.fail("Intentionally Failed");

	}
	
	@Before
	public void SetUp()
	{
		System.out.println("Setting up the test");
			driver = utilities.DriverFactory.open("google");
	}
	
	@After
	public void TearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}
}
