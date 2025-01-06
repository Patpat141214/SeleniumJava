package AutomationTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SettingClass {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
	    driver = Utilities.CrossBrowsing.open("google");
	    driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	
}
}
