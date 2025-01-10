package AutomationTesting;

import static org.testng.Assert.fail;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bsh.This;

public class BillingTestSuite16th extends SettingClass {
	  String totalClaims; // Class-level variable for TotalClaims
	    String formattedTotalAmount;
	    //String billingPeriod = "Dec 16, 2024 - Dec 31, 2024" ;
	    //String billingDate = "Jan 01, 2025";
     	//String expectedSoaDate = "Dec 31, 2024";

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
    
    
    @Parameters({"billingPeriod"})
    @Test (priority = 2)
    public void BIL01(String billingPeriod) {
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
    	
    	String BillingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='"+billingPeriod+"']")).getText(); //Need to Change base on billing execution
    	       	       	        	     	   
    	   if (BillingPeriod.contentEquals(billingPeriod)){   	 
    	 	 Reporter.log("Test ID (BIL01) Passed ", true);
    	 	Reporter.log("Billing Period is Valid which is: " + BillingPeriod, true);
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
    
    @Parameters({"billingDate"})
    @Test (priority = 3)
    public void BIL02(String billingDate) {
    	Reporter.log("Start of Test ID (BIL02)", true);
    	 String BillingDate = driver.findElement(By.xpath("//td[@data-field='BillingDate' and text()='"+billingDate+"']")).getText();
    	
    	 
    	 if (BillingDate.contentEquals( billingDate)) {    		
 	 	 Reporter.log("Test ID (BIL02) Passed ", true);
 	 	Reporter.log("Billing Date is Valid which is: " + BillingDate, true);
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
    
    @Parameters({"billingPeriod", "expectedSoaDate"})
    @Test (priority = 5)
    public void BIL04(String billingPeriod, String expectedSoaDate) {
    	
   
    	Reporter.log("Start of Test ID (BIL04)", true);
    	 String BillingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='"+billingPeriod+"']")).getText(); //Need to Change base on billing execution
     	String soaDate = driver.findElement(By.xpath("//td[@data-field='SoaDate' and text()='"+expectedSoaDate+"']")).getText(); //Need to Change base on billing execution


   	 if (BillingPeriod.contentEquals(billingPeriod) && soaDate.contentEquals(expectedSoaDate)) {
   		 Reporter.log("Test ID (BIL04) Passed ", true);
   		Reporter.log("Soa Date is Valid which is: " + soaDate, true);
   		Reporter.log("End of Billing Module", true);
   		 Assert.assertTrue(true, "Soa Date is Valid!");
	 	
   	 }
   	 else {
   		 Reporter.log("Test ID (BIL04) Failed ", true);
   		  Assert.fail();
   	 	 
   	 }
    	
    	 	 
    	 }
    
    @Parameters({"billingPeriod"})
    @Test (priority = 6)
    public void COL01(String billingPeriod) {
    	Reporter.log("Start of Test ID (COL01)", true);         
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
          


       // Try to locate the "Unlock" button
       List<WebElement> unlockButtons = driver.findElements(By.xpath("//a[contains(@class, 'k-button k-button-icontext k-grid-details') and text()='Unlock']"));

       // Check if the "Unlock" button is present
       if (!unlockButtons.isEmpty()) {
           Reporter.log("'Unlock' button found. Clicking to unlock...", true);

           // Click the "Unlock" button
           WebElement unlockBtn = unlockButtons.get(0); // Since it's a single button
           	unlockBtn.click();
           	
           try {
               Thread.sleep(2000); // Wait for the button to change state
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       // Locate the "Details" button (after unlocking or directly)
       WebElement detailsBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
           By.xpath("//a[contains(@class, 'k-button k-button-icontext k-grid-details') and text()='Details']")));

       // Ensure the button is visible and enabled
       if (detailsBtn.isDisplayed() && detailsBtn.isEnabled()) {
           Reporter.log("'Details' button found. Clicking to proceed...", true);

           // Scroll to the "Details" button
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", detailsBtn);

           // Click the "Details" button
           detailsBtn.click();
           Reporter.log("Successfully clicked 'Details' button. Proceeding to the new tab...", true);
       } else {
           Reporter.log("'Details' button is not clickable. Test failed.", true);
           Assert.fail("Could not click the 'Details' button.");
       }
          
        
                          
          try {
	            Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
          
         
          driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
          WebElement BillingPeriod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Billing Period:']/following-sibling::div")));
          WebElement totalClaims = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Claims:']/following-sibling::div")));
          String totalAmount = driver.findElement(By.xpath("//div[text()='Total Amount:']/following-sibling::div")).getText();

           
          String totalAmountFormatted = totalAmount.replace("PHP", "").trim();
          
          
          if (BillingPeriod.getText().contentEquals(billingPeriod) && totalClaims.getText().contentEquals(this.totalClaims.replace(".00","")) && totalAmountFormatted.contentEquals(this.formattedTotalAmount.replace("Php","").trim())) {
       		 Reporter.log("Test ID (COL01) Passed ", true);
       	   		Reporter.log("Billing Period is Valid which is: " + BillingPeriod.getText(), true);
       	   		Reporter.log("Total Claims is Valid which is: " + totalClaims.getText(), true);
       	   		Reporter.log("Total Amount is Valid which is: " + totalAmount, true);
       	   		 Assert.assertTrue(true, "Latest billing are all Valid!");
         }else {
      	   Reporter.log("Test ID (COL01) Failed ", true);
      		  Assert.fail();
       	  
         }
                               
          driver.switchTo().defaultContent();
     
    }
    
    @Parameters({"billingPeriod"})
    @Test (priority = 7)
    public void COL02(String billingPeriod) {
    	Reporter.log("Start of Test ID (COL02)", true);     
    	 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    	driver.findElement(By.xpath("//span[@class='k-link' and text()='Payment']")).click();

    	 try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 
    	 driver.findElement(By.xpath("//button[contains(@class, 'k-button') and contains(@class, 'k-primary') and contains(@onclick, 'addPaymentWindow')]")).click();
    	 try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
     
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input' and text()='Select Billing']")));
         firstOption.click();
        
         WebElement billingPeriodOption = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("//li[@class='k-item' and text()='"+billingPeriod+"']")));
        	billingPeriodOption.click();
        	
        	

         String BillingPeriod = driver.findElement(By.xpath("//span[@class='k-input'and text()='"+billingPeriod+"']")).getText();
        
         if (BillingPeriod.toLowerCase().contentEquals(billingPeriod.toLowerCase())) {
       		 Reporter.log("Test ID (COL02) Passed ", true);
       	   		Reporter.log("Billing Period is Valid which is: " + BillingPeriod, true);
       	   	
       	   		 Assert.assertTrue(true, "Billing Period is Valid!");
         }else {
      	   Reporter.log("Test ID (COL02) Failed ", true);
      		  Assert.fail();
       	  
         }
                                
         driver.switchTo().defaultContent();   	
    	 try {
	            Thread.sleep(2000);  // Pause for 5 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	 
   
    	
    	
    }
    
    @Test (priority = 8)
    public void COL03() {
    	Reporter.log("Start of Test ID (COL03)", true);    
    	
    	 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    	 WebElement curBalance = driver.findElement(By.xpath("//input[@class='k-formatted-value k-input']"));
    	 String balanceText = curBalance.getAttribute("title");
    	 String balanceFormattedText = balanceText.replace("₱", "Php ").trim();
    	   if (balanceFormattedText.contentEquals(this.formattedTotalAmount)) {
         		 Reporter.log("Test ID (COL03) Passed ", true);
         	   		Reporter.log("Current Balance is correct which is: " + balanceFormattedText , true);        	
         	   	Reporter.log("End of Collection Module", true);
         	   		Assert.assertTrue(true, "Current Balance is correct!");
           }else {
        	   Reporter.log("Test ID (COL03) Failed ", true);
        	   Assert.fail();
         	  
           }
    	   driver.switchTo().defaultContent();   	
    	    driver.navigate().back();
    	  
    	       	    	      	  
    	 try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 
    }
    
    @Parameters({"statementDate"})
    @Test (priority = 9)
    public void AR01(String statementDate) {
    	Reporter.log("Start of Test ID (AR01)", true);    
    	Reporter.log("Navigating to Account Receivable Module...", true);    
    	Reporter.log("Start of Account Receivable Module Validation...", true);
    	WebElement navReports = driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Reports']"));
    	
    	 Actions actions = new Actions(driver);
         actions.moveToElement(navReports).perform();
    	
         WebElement AccReceivable = driver.findElement(By.xpath("//span[@class='context-menu-itemText' and text()='Accounts Receivable']"));
         AccReceivable.click();
         
     	  
         	try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
         	
         	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	
 	 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[3]/a[1]/span")));
 	 
 	 kebabIcon.click();
 	 
 	 try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	 	   
 	 WebElement hoverFilter = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
	   
	   Actions actions1 = new Actions(driver);
       actions1.moveToElement(hoverFilter).perform();
       
       WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
       
       textBox.sendKeys("H03021076");
       textBox.sendKeys(Keys.ENTER);
       
       try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
       
       String StatementDate = driver.findElement(By.xpath("//td[text()='"+statementDate+"']")).getText();
	    
       if (StatementDate.contentEquals(statementDate)) {
   		 Reporter.log("Test ID (AR01) Passed ", true);
   	   		Reporter.log("Statement Date is correct which is: " + StatementDate , true);        	
   	   		Assert.assertTrue(true, "Statement Date is correct!");
     }else {
  	   Reporter.log("Test ID (AR01) Failed ", true);
  	   Assert.fail();
   	  
     }
       
    }
    
    @Parameters({"billingPeriod"})
    @Test (priority = 10)
    public void AR02(String billingPeriod) {
    	Reporter.log("Start of Test ID (AR02)", true);    
    	 
    	String getBillingPeriod = driver.findElement(By.xpath("//td[text()='"+billingPeriod+"']")).getText();
    	 if (getBillingPeriod.contentEquals(billingPeriod)) {
       		 Reporter.log("Test ID (AR02) Passed ", true);
       	   		Reporter.log("Billing Period is correct which is: " + billingPeriod , true);        	
       	   		Assert.assertTrue(true, "Billing Period is correct");
         }else {
      	   Reporter.log("Test ID (AR02) Failed ", true);
      	   Assert.fail();
       	  
         }
       
    }
    
}
    
    


