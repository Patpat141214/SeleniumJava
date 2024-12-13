package SmokeTesting;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
WebDriver driver;
	
	@Test
	public void loginElementPresentTest() {
		System.out.println("Runnning Test");
		boolean submitPresent = false;
		
		
		List <WebElement> divElements = driver.findElements(By.tagName("div"));
		
		int numberOfDivElements = divElements.size();
		
		System.out.println("There are " + numberOfDivElements + " div tags on the page");		
		for(WebElement divElement : divElements) {
			
			System.out.println(divElement.getText());
			
			if(divElement.getText().equals("Submit")) {
				submitPresent = true;
				break;
			}
		}
		
		Assert.assertTrue(submitPresent);
		
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
