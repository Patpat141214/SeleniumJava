package AutomationTesting;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BillingTestSuite16th extends SettingClass {


	String link = "https://manager.easyclaimsph.com";
	
	
    @Test (priority = 0)
    public void UILoginValidation() {
    	
    	Reporter.log("Start of Test ID (LI01)", true);
    	Reporter.log("Navigating to URL...", true);
    	driver.get(link);   
    	WebElement usr = driver.findElement(By.id("Username"));
    	WebElement pass = driver.findElement(By.id("Password"));
    	WebElement loginBtn = driver.findElement(By.id("submitBtn"));
    	WebElement version = driver.findElement(By.xpath("//div[@class='footer flex-baseline text-center' and contains(normalize-space(text()), 'Easy Claims Manager version')]"));
    	WebElement website = driver.findElement(By.xpath("//a[@href='http://www.eurolinkonline.com' and contains(normalize-space(text()), 'Eurolink Network International Corporation')]"));
    	WebElement accreCode = driver.findElement(By.xpath("//div[@class='footer flex-baseline text-center' and contains(normalize-space(text()), 'PhilHealth Accreditation Code ECS004031213001A')]"));
    	if (usr.isDisplayed() && pass.isDisplayed() && loginBtn.isDisplayed() && version.isDisplayed() && website.isDisplayed() && accreCode.isDisplayed()) {
    		Assert.assertTrue(true,"UI's ");
    		Reporter.log("All Elements are loaded!", true);
    		Reporter.log("Test ID (LI01) Passed ", true);
    	}else {
    		Reporter.log("Some elements are not loaded!", true);
    		Reporter.log("Test ID (LI01) Failed ", true);
    		Assert.fail();
    		
    	}
    	
    	
    
    	
    }
    
    @Test (priority = 1)
    public void ValidationOfLogin() {
         
    	Reporter.log("Start of Test ID (LI02)", true);
    	
    	Reporter.log("Inputting Valid Credential", true);    	
    	driver.findElement(By.id("Username")).sendKeys("patche1214");
    	driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
    	driver.findElement(By.id("submitBtn")).click();
    	
    	String homePage = driver.findElement(By.xpath("//div[@class='content-header' and text()='Home Page']")).getText();
    	
    	if (homePage.contentEquals("Home Page")) {    	 
    		Assert.assertTrue(true, "Login Validation Passed");
    		Reporter.log("Test ID (LI02) Passed ", true);
    	}else {
    		Reporter.log("Test ID (LI02) Failed ", true);
    		Assert.fail();
    		
    	}


    	
   }
    
    
    
    @Test (priority = 2)
    public void NavigateBillingModule() {
    
    	Reporter.log("Navigate to Billing Module...", true);
    	driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Billing']")).click();    	   	
}
    @Test (priority = 3)
    public void searchHospital() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[3]/a[1]/span")));
        
 	   kebabIcon.click();
 	   
 	   Reporter.log("Kebab Icon successfully clicked", true);
 	   
 	   try {
	            Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	   
 	   WebElement hoverElement = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
 	   
 	   Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        
        try {
	            Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	   
     Reporter.log("Navigating to Hospital...", true)   ;
        
     WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
     
     textBox.sendKeys("H03021076");
     textBox.sendKeys(Keys.ENTER);
     
     try {
         Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
         
     WebElement billingDateElement = driver.findElement(By.xpath("//a[@class='k-link' and text()='Billing Date']"));

     // Scroll horizontally using JavaScriptExecutor
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", billingDateElement);

     // Click the element
     billingDateElement.click();
     
     
    
    try {
        Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    billingDateElement.click();
    
    try {
        Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    
    }
    
    @Test (priority = 4)
    public void validateBillingPeriodColumn() {
    	
    	Reporter.log("Start of Test ID (BIL01)", true);
    	
    	 String billingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='Dec 01, 2024 - Dec 15, 2024']")).getText(); //Need to Change base on billing execution
    	       	       	    
    	   String ExpectedBillingPeriod = "Dec 01, 2024 - Dec 15, 2024";//Need to Change base on billing execution
    	     	   
    	   if (billingPeriod.contentEquals(ExpectedBillingPeriod)){
    	 	  Assert.assertTrue(true, "Billing Period is valid!");
    	 	 Reporter.log("Test ID (BIL01) Passed ", true);
    	 	  
    	   }
    	   else {
    		   Reporter.log("Billing period is Invalid", true);
      	 	 Reporter.log("Test ID (BIL01) Failed ", true);
    	 	  Assert.fail();
    	 	  
    	   }
    	       	       	    	          
    	   try {
    	       Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
    	   } catch (InterruptedException e) {
    	       e.printStackTrace();
    	   }
    	      	      	 	   
    	 }
    
    @Test (priority = 5)
    public void validateBillingDateColumn() {
    	Reporter.log("Start of Test ID (BIL02)", true);
    	 String billingDate = driver.findElement(By.xpath("//td[@data-field='BillingDate' and text()='Dec 16, 2024']")).getText();
    	 String ExpectedBillingDate = "Dec 16, 2024";//Need to Change base on billing execution
    	
    	 System.out.println(billingDate);
    	 
    	 if (billingDate.contentEquals(ExpectedBillingDate)) {
    		 Assert.assertTrue(true, "Billing Date is Valid");
 	 	 Reporter.log("Test ID (BIL02) Passed ", true);
    	 }
    	 else {
    		 Reporter.log("Test ID (BIL02) Failed ", true);
    		  Assert.fail();
    	 	 
    	 }
    	 
    }
    
    }


