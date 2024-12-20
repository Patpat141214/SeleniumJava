package UnitTesting;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.asserts.*;


public class PhilHealth_Field {
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
	
	@Test (priority = 2,dependsOnMethods = {"Url"})
	public void LogIn() {
		Reporter.log("Logging in with username: patche@admin", true);
		
		driver.findElement(By.id("Username")).sendKeys("patche@admin");
		driver.findElement(By.id("Password")).sendKeys("123123123");
		driver.findElement(By.id("submitBtn")).click();
		
		Reporter.log("Login submitted", true);
	}
	
   @Test(priority = 3, dependsOnMethods = {"LogIn"})
	public void Claim() {
	   Reporter.log("Navigating to Claims page...", true);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"claims-nav\"]/a/span[2]")).click();

        
        // Locate the <td> element with claim number 'CLAIMSTEST'
        WebElement claimCell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-field='ClaimNo' and text()='CLAIMSTEST']")));

        // Scroll the element into view before performing any actions
        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true);", claimCell);

        // Now, use Actions class to right-click on the element
        Actions actions = new Actions(driver);
        actions.contextClick(claimCell).perform();
        // Performs the right-click action
        Reporter.log("Right-clicked on claim cell for 'CLAIMSTEST'.", true);
        // Wait for the context menu to appear and ensure it's visible
        WebElement editOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-link k-menu-link' and text()='Edit']")));

        // Click the "Edit" option in the context menu
        editOption.click();
        
        Reporter.log("Clicked on 'Edit' option.", true);
        
        driver.findElement(By.id("confinementInformation")).click();
        driver.findElement(By.id("feesAndCharges")).click();
        
        
        
        //Start of eSOA Add Modal Prof Fee
        WebElement eSoa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-link k-header' and text()='E-SOA FEATURES']")));
        
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].scrollIntoView(true);", eSoa);
	       
	        
	        driver.findElement(By.xpath("//span[@class='k-link k-header' and text()='E-SOA FEATURES']")).click();
	        

	        try {
	            Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	       WebElement eSoaButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button' and contains(@class, 'k-grid-add') and text() = 'Add E-SOA Professional Fees and Charges']")));
	       
	       JavascriptExecutor JsEsoaButton = (JavascriptExecutor) driver;
	       JsEsoaButton.executeScript("arguments[0].scrollIntoView(true);", eSoaButton);	       	       
	       JsEsoaButton.executeScript("arguments[0].click();", eSoaButton);

	       try {
	           Thread.sleep(2000); // Pause for 5 seconds to wait for the page to load
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       
	       
	      WebElement phfield = driver.findElement(By.xpath("//label[@for='DocPhilhealth' and text()='Philhealth']"));
	      
	      try {
	    	  Assert.assertTrue(phfield.isDisplayed(), "PHfield Exist");
	    	  Reporter.log("PHfield is visible on the page.", true);
	      } catch(Exception e) {
	    	  Assert.assertFalse(phfield.isDisplayed(), "PHfield Not Exist");
	    	  Reporter.log("PHfield is not visible on the page.", true);
	      }
	   
	     
	       
	      driver.close();
	      Reporter.log("Test completed and browser closed.", true);

	} 
		
		
}
