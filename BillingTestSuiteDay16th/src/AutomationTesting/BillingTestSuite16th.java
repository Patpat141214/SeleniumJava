package AutomationTesting;

import static org.testng.Assert.fail;

import java.text.DecimalFormat;
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
	  String totalClaims; // Class-level variable for TotalClaims
	    String formattedTotalAmount;
	    String billingPeriod;

	String link = "https://manager.easyclaimsph.com";
	
	
    @Test (priority = 0)
    public void LI01() {
    	Reporter.log("Start of Login Validation...)", true);
    	Reporter.log("Start of Test ID (LI01)", true);
    	Reporter.log("Navigating to URL...", true);
    	driver.get(link);   
    	WebElement usr = driver.findElement(By.id("Username"));
    	WebElement pass = driver.findElement(By.id("Password"));
    	WebElement loginBtn = driver.findElement(By.id("submitBtn"));  	
    	WebElement footer = driver.findElement(By.xpath("/html/body/div/div/div/div[3]"));
    	
    
    	if (usr.isDisplayed() && pass.isDisplayed() && loginBtn.isDisplayed() && footer.isDisplayed()) {
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
    public void LI02() {
         
    	Reporter.log("Start of Test ID (LI02)", true);
    	
    	Reporter.log("Inputting Valid Credential", true);    	
    	driver.findElement(By.id("Username")).sendKeys("patche1214");
    	driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
    	driver.findElement(By.id("submitBtn")).click();
    	
    	String homePage = driver.findElement(By.xpath("//div[@class='content-header' and text()='Home Page']")).getText();
    	
    	if (homePage.contentEquals("Home Page")) {    	 
    		Assert.assertTrue(true, "Login Validation Passed");
    		Reporter.log("Test ID (LI02) Passed ", true);
    		Reporter.log("End of Login Validation!", true);
    	}else {
    		Reporter.log("Test ID (LI02) Failed ", true);
    		Assert.fail();
    		
    	}


    	
   }
    
    
    
    @Test (priority = 2)
    public void BIL01() {
    	Reporter.log("Start of Billing Module Validation...", true);
    	Reporter.log("Navigate to Billing Module...", true);
    	driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Billing']")).click();    	
    	
    	try {
            Thread.sleep(5000);  // Pause for 2 seconds to wait for the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[3]/a[1]/span")));
        
 	   kebabIcon.click();
 	   
 	   Reporter.log("Kebab Icon successfully clicked", true);
 	   
 	   try {
	            Thread.sleep(5000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	   
 	   WebElement hoverElement = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
 	   
 	   Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        
        try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	   
     Reporter.log("Navigating to Hospital...", true)   ;
        
     WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
     
     textBox.sendKeys("H03021076");
     textBox.sendKeys(Keys.ENTER);
     
     try {
         Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
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
        Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    billingDateElement.click();
    
    try {
        Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    
    	
    	Reporter.log("Start of Test ID (BIL01)", true);
    	
    	billingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='Dec 16, 2024 - Dec 31, 2024']")).getText(); //Need to Change base on billing execution
    	       	       	    
    	   String ExpectedBillingPeriod = "Dec 16, 2024 - Dec 31, 2024";//Need to Change base on billing execution
    	     	   
    	   if (billingPeriod.contentEquals(ExpectedBillingPeriod)){   	 
    	 	 Reporter.log("Test ID (BIL01) Passed ", true);
    	 	Reporter.log("Billing Period is Valid which is: " + ExpectedBillingPeriod, true);
    		 Assert.assertTrue(true, "Billing Period is valid!");
    	 	  
    	   }
    	   else {
    		   Reporter.log("Billing period is Invalid", true);
      	 	 Reporter.log("Test ID (BIL01) Failed ", true);
    	 	  Assert.fail();
    	 	  
    	   }
    	       	       	    	          
    	   try {
    	       Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
    	   } catch (InterruptedException e) {
    	       e.printStackTrace();
    	   }
    	      	      	 	   
    	 }
    
    @Test (priority = 3)
    public void BIL02() {
    	Reporter.log("Start of Test ID (BIL02)", true);
    	 String billingDate = driver.findElement(By.xpath("//td[@data-field='BillingDate' and text()='Jan 01, 2025']")).getText();
    	 String ExpectedBillingDate = "Jan 01, 2025";//Need to Change base on billing execution
    	
    	 
    	 if (billingDate.contentEquals(ExpectedBillingDate)) {    		
 	 	 Reporter.log("Test ID (BIL02) Passed ", true);
 	 	Reporter.log("Billing Date is Valid which is: " + ExpectedBillingDate, true);
 	 	 Assert.assertTrue(true, "Billing Date is Valid");
    	 }
    	 else {
    		 Reporter.log("Test ID (BIL02) Failed ", true);
    		  Assert.fail();
    	 	 
    	 }
    	 
    	 
    }
    @Test (priority = 4)
    public void BIL03() {
    	Reporter.log("Start of Test ID (BIL03)", true);
    	totalClaims = driver.findElement(By.xpath("//td[@data-field='TotalClaims']")).getText();
    	 String serviceFee = driver.findElement(By.xpath("//td[@data-field='ServiceFee']")).getText();
    	 String totalAmount = driver.findElement(By.xpath("//td[@data-field='TotalAmount']")).getText();
    	 //String ExpectedBillingDate = "Dec 16, 2024";//Need to Change base on billing execution
    	
    	 totalClaims = String.format("%.2f", Double.parseDouble(totalClaims));

    	// Remove "Php" from serviceFee and convert it to a numeric format
    	serviceFee = serviceFee.replace("Php", "").trim();    	

    	double totalClaimsValue = Double.parseDouble(totalClaims);
    	double ServiceFeeValue = Double.parseDouble(serviceFee);
    	
    	double totalExpectedValue = totalClaimsValue * ServiceFeeValue;
    	
    	formattedTotalAmount = "Php " + String.format("%,.2f", totalExpectedValue);
    	

   	 if (totalAmount.contentEquals(formattedTotalAmount)) {
   		 Assert.assertTrue(true, "Total Amount is correct!");
   		 Reporter.log("Total Amouns is: " + formattedTotalAmount, true);
	 	     Reporter.log("Test ID (BIL03) Passed ", true);
   	 }
   	 else {
   		 Reporter.log("Test ID (BIL03) Failed ", true);
   		  Assert.fail();
   	 	 
   	 }
    	
    	 	 
    	 }
    
    @Test (priority = 5)
    public void BIL04() {
    	
   
    	Reporter.log("Start of Test ID (BIL04)", true);
    	 billingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='Dec 16, 2024 - Dec 31, 2024']")).getText(); //Need to Change base on billing execution
     	String soaDate = driver.findElement(By.xpath("//td[@data-field='SoaDate' and text()='Dec 31, 2024']")).getText(); //Need to Change base on billing execution
     	 String ExpectedBillingPeriod = "Dec 16, 2024 - Dec 31, 2024";
     	String expectedSoaDate = "Dec 31, 2024";

   	 if (billingPeriod.contentEquals(ExpectedBillingPeriod) && soaDate.contentEquals(expectedSoaDate)) {
   		 Reporter.log("Test ID (BIL04) Passed ", true);
   		Reporter.log("Soa Date is Valid which is: " + expectedSoaDate, true);
   		Reporter.log("End of Billing Module", true);
   		 Assert.assertTrue(true, "Soa Date is Valid!");
	 	
   	 }
   	 else {
   		 Reporter.log("Test ID (BIL04) Failed ", true);
   		  Assert.fail();
   	 	 
   	 }
    	
    	 	 
    	 }
    
    @Test (priority = 6)
    public void COL01() {
    	         
    	Reporter.log("Start of Collection Module Validation...", true);
    	Reporter.log("Navigate to Collection Module...", true);
    	driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Collection']")).click();    	
    	 try {
  	       Thread.sleep(5000);  // Pause for 7 seconds to wait for the page to load
  	   } catch (InterruptedException e) {
  	       e.printStackTrace();
  	   }
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	
    	 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[7]/a[1]/span")));
    	 
    	 kebabIcon.click();
    	 
    	 try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 	   
    	 WebElement hoverElement = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]"));
   	   
   	   Actions actions = new Actions(driver);
          actions.moveToElement(hoverElement).perform();
          
          WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
          
          textBox.sendKeys("H03021076");
          textBox.sendKeys(Keys.ENTER);
          
          try {
  	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
  	        } catch (InterruptedException e) {
  	            e.printStackTrace();
  	        }
          
          WebElement detailsBtn = driver.findElement(By.xpath("//*[@id=\"CollectionGrid\"]/div[3]/table/tbody/tr/td[24]/a[2]"));
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", detailsBtn);

          // Click the element
          detailsBtn.click();
          
          try {
	            Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
          
         
          driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
          WebElement billingPeriod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Billing Period:']/following-sibling::div")));
          WebElement totalClaims = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Claims:']/following-sibling::div")));
          String totalAmount = driver.findElement(By.xpath("//div[text()='Total Amount:']/following-sibling::div")).getText();

           
          String totalAmountFormatted = totalAmount.replace("PHP", "").trim();
          
          
          if (billingPeriod.getText().contentEquals(this.billingPeriod) && totalClaims.getText().contentEquals(this.totalClaims.replace(".00","")) && totalAmountFormatted.contentEquals(this.formattedTotalAmount.replace("Php","").trim())) {
       		 Reporter.log("Test ID (COL01) Passed ", true);
       	   		Reporter.log("Billing Period is Valid which is: " + billingPeriod.getText(), true);
       	   		Reporter.log("Total Claims is Valid which is: " + totalClaims.getText(), true);
       	   		Reporter.log("Total Amount is Valid which is: " + totalAmount, true);
       	   		 Assert.assertTrue(true, "Latest billing are all Valid!");
         }else {
      	   Reporter.log("Test ID (COL01) Failed ", true);
      		  Assert.fail();
       	  
         }
                               
          driver.switchTo().defaultContent();
     
    }
    @Test (priority = 7)
    public void COL02() {
    	 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    	driver.findElement(By.xpath("//span[@class='k-link' and text()='Payment']")).click();

    	 try {
	            Thread.sleep(3000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 
    	 driver.findElement(By.xpath("//button[contains(@class, 'k-button') and contains(@class, 'k-primary') and contains(@onclick, 'addPaymentWindow')]")).click();
    	 try {
	            Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 
         driver.findElement(By.xpath("/html/body/div[11]/div[2]/form/ul/li[1]/div/span[1]/span/span[1] and text()='Dec 16, 2024 - Dec 30, 2024'"));
    	 
    	 try {
	            Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	 
 	 
    	 driver.switchTo().defaultContent();
    	 
    	 
       
    	
    	
    	
    }
    
}
    
    


