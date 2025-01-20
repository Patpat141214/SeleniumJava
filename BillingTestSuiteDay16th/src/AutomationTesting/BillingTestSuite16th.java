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
	  String totalClaims; 
	    String formattedTotalAmount;
        String freeTrials;
        String totalClaimsWithFreeFormatted;
        String serviceFee;
        double vatableValue = 1.12;
        String vatableSales;
        double vat = 0.12;
        String valAddedTax;
        String amountDue;
        String allCurrentBalance;
        String formattedAllCurrentBalance;
        double totalBalance = 0.0;
        

	
	@Parameters({"link"})
    @Test (priority = 0)
    public void LI01(String link) {
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
    
    
    @Parameters({"billingPeriod", "Hospital"})
    @Test (priority = 2)
    public void BIL01(String billingPeriod, String Hospital) {
    	Reporter.log("Start of Billing Module Validation...", true);
    	Reporter.log("Navigate to Billing Module...", true);
    	driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Billing']")).click();    	
    	
    	try {
            Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
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
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	   
     Reporter.log("Navigating to Hospital...", true)   ;
        
     WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
     
     textBox.sendKeys(Hospital);
     textBox.sendKeys(Keys.ENTER);

     try {
         Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
        Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    billingDateElement.click();
    
    try {
        Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
    	       Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
    	freeTrials = driver.findElement(By.xpath("//td[@data-field='TotalFreeClaims']")).getText();
    	totalClaims = driver.findElement(By.xpath("//td[@data-field='TotalClaims']")).getText();
    	 serviceFee = driver.findElement(By.xpath("//td[@data-field='ServiceFee']")).getText();
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
   		 Reporter.log("Total Amount is: " + formattedTotalAmount, true);
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
   		Reporter.log("End of Billing Module Validation", true);
   		 Assert.assertTrue(true, "Soa Date is Valid!");
	 	
   	 }
   	 else {
   		 Reporter.log("Test ID (BIL04) Failed ", true);
   		  Assert.fail();
   	 	 
   	 }
    	
    	 	 
    	 }
    
    @Parameters({"billingPeriod", "Hospital", "statementDate"})
    @Test (priority = 6)
    public void COL01(String billingPeriod, String Hospital, String statementDate) {
    	Reporter.log("Start of Test ID (COL01)", true);         
    	Reporter.log("Start of Collection Module Validation...", true);
    	Reporter.log("Navigate to Collection Module...", true);
    	driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Collection']")).click();    	
    	 try {
  	       Thread.sleep(5000);  // Pause for 5 seconds to wait for the page to load
  	   } catch (InterruptedException e) {
  	       e.printStackTrace();
  	   }
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	
    	 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[7]/a[1]/span")));
    	 
    	 kebabIcon.click();
    	 
    	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 	   
    	 WebElement hoverElement = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]"));
   	   
   	   Actions actions = new Actions(driver);
          actions.moveToElement(hoverElement).perform();
          
          WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
          
          textBox.sendKeys(Hospital);
          textBox.sendKeys(Keys.ENTER);
          
          try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }          
          
          driver.findElement(By.xpath("//a[@class='k-button k-button-icontext k-grid-history' and text()='History']")).click();
          
          try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }          
          
          driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
          
          try {
	            Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }          
          
          //currentBalance = driver.findElement(By.xpath("//td[@data-field='CurrentBalance']")).getText();      
          allCurrentBalance = String.format("//tr[td[@data-field='StatementDate' and text()='"+statementDate+"']]/td[@data-field='CurrentBalance']", statementDate);
          List<WebElement> currentBalances = driver.findElements(By.xpath(allCurrentBalance));

          // Print or process the current balances

       // Step 3: Process and sum up all the balances
       for (WebElement balance : currentBalances) {
           // Remove "Php" and commas, then parse the balance to a double
           String balanceText = balance.getText().replace("Php", "").replace(",", "").trim();
           totalBalance += Double.parseDouble(balanceText);           
       }
         formattedAllCurrentBalance = "₱ " + String.format("%,.2f", totalBalance);
        
         
          driver.switchTo().defaultContent();
          
          try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }          
          
          driver.navigate().back();
          
          try {
     	       Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
     	   } catch (InterruptedException e) {
     	       e.printStackTrace();
     	   }
          
          driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Collection']")).click();   
          
          try {
    	       Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
    	   } catch (InterruptedException e) {
    	       e.printStackTrace();
    	   }
           	
       	 WebElement kebabIcon1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[7]/a[1]/span")));
       	 
       	 kebabIcon1.click();
       	 
       	 try {
   	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
   	        } catch (InterruptedException e) {
   	            e.printStackTrace();
   	        }
       	 	   
       	 WebElement hoverElement1 = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]"));
      	   
      	   Actions actions1 = new Actions(driver);
             actions1.moveToElement(hoverElement1).perform();
             
             WebElement textBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
             
             textBox1.sendKeys(Hospital);
             textBox1.sendKeys(Keys.ENTER);
             
             try {
   	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
   	        } catch (InterruptedException e) {
   	            e.printStackTrace();
   	        }          
     
          
          try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
               Thread.sleep(3000); // Wait for the button to change state
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
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	 
    	 driver.findElement(By.xpath("//button[contains(@class, 'k-button') and contains(@class, 'k-primary') and contains(@onclick, 'addPaymentWindow')]")).click();
    	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
    	 System.out.println(balanceFormattedText + " " + this.formattedTotalAmount);
    	   if (balanceFormattedText.contentEquals(this.formattedTotalAmount)) {
         		 Reporter.log("Test ID (COL03) Passed ", true);
         	   		Reporter.log("Current Balance is correct which is: " + balanceFormattedText , true);        	
         	   	Reporter.log("End of Collection Module Validation", true);
         	   		Assert.assertTrue(true, "Current Balance is correct!");
           }else {
        	   Reporter.log("Test ID (COL03) Failed ", true);
        	   Assert.fail();
         	  
           }
    	   
    	   
    	   
    	   driver.switchTo().defaultContent();   	
    	    driver.navigate().back();
    	  
    	       	    	      	  
    	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 
    }
    
    @Parameters({"statementDate", "Hospital"})
    @Test (priority = 9)
    public void AR01(String statementDate, String Hospital) {
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
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 	 	   
 	 WebElement hoverFilter = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
	   
	   Actions actions1 = new Actions(driver);
       actions1.moveToElement(hoverFilter).perform();
       
       WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
       
       textBox.sendKeys(Hospital);
       textBox.sendKeys(Keys.ENTER);
       
       try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
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
    
    @Test (priority = 10)
    public void AR03() {
    	Reporter.log("Start of Test ID (AR03)", true);    
    	     	    
    	String getAmountDue = driver.findElement(By.xpath("//td[@data-field='TotalAmount' and text()='"+this.formattedTotalAmount+"']")).getText();

    	if (this.formattedTotalAmount.contentEquals(getAmountDue)) {
      		 Reporter.log("Test ID (AR03) Passed ", true);
      	   		Reporter.log("Total Amount in Billing : " + this.formattedTotalAmount , true);    
      	   	Reporter.log("Total Amount in Account Receivable: " + getAmountDue , true);     
      		Reporter.log("End of Account Receivable Validation " + getAmountDue , true);     
      	   		Assert.assertTrue(true, "Both Total Amount is correct");
      	   		
        }else {
     	   Reporter.log("Test ID (AR03) Failed ", true);
     	   Assert.fail();
      	  
        }
    	
     
    }
    
    @Parameters({"billingPeriod", "Hospital"})
    @Test (priority = 11)
    public void SOA01(String billingPeriod, String Hospital) {
    	Reporter.log("Start of Test ID (SOA01)", true);    
    	Reporter.log("Navigating to Statement of Account...", true);    
    	Reporter.log("Start of Statement of Account Validation...", true);
    	
    	WebElement navReportsSOA = driver.findElement(By.xpath("//span[@class='flex-grow commandbar-item-text' and text()='Statement Of Account']"));
    	navReportsSOA.click();
    	
    	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
	 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[1]/a[1]/span")));
	 
	 kebabIcon.click();
	 
	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 	   
	 WebElement hoverFilter = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
	   
	   Actions actions1 = new Actions(driver);
    actions1.moveToElement(hoverFilter).perform();
    
    WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
    
    textBox.sendKeys(Hospital);
    textBox.sendKeys(Keys.ENTER);
    
    try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    
    	amountDue = driver.findElement(By.xpath("//tr[2]/td[@data-field='TotalAmountDue']")).getText();
    	
    	
    	String getBillingPeriod = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='"+billingPeriod+"']")).getText();

    	if (billingPeriod.contentEquals(getBillingPeriod)) {
      		 Reporter.log("Test ID (SOA01) Passed ", true);
      		Reporter.log("Billing Period is correct which is: " + getBillingPeriod , true);        	  
      	   		Assert.assertTrue(true, "Billing Period is Correct");
      	   		
        }else {
     	   Reporter.log("Test ID (SOA01) Failed ", true);
     	   Assert.fail();
      	  
        }
    
}
    
    @Parameters({"billingDate"}) 
    @Test (priority = 12)
    public void SOA02(String billingDate) {
    	Reporter.log("Start of Test ID (SOA02)", true);    
    	     	    
    	String getBillingDate = driver.findElement(By.xpath("//td[@data-field='BillingDate' and text()='"+billingDate+"']")).getText();

    	if (billingDate.contentEquals(getBillingDate)) {
      		 Reporter.log("Test ID (SOA02) Passed ", true);
      	   		Reporter.log("Billing Date is correct which is: " + getBillingDate, true);    
      	   	   
      	   		Assert.assertTrue(true, "Billing Date is Correct");
      	   		
        }else {
     	   Reporter.log("Test ID (SOA02) Failed ", true);
     	   Assert.fail();
      	  
        }
    	
     
    }
    
    @Test (priority = 13)
    public void SOA3() {
    	Reporter.log("Start of Test ID (SOA03)", true);    
    	     	    
    	String getTotalClaims = driver.findElement(By.xpath("//td[@data-field='TotalClaims']")).getText();
         
    	   	
    	if (this.totalClaims.replace(".00","").contentEquals(getTotalClaims)) {
     		 Reporter.log("Test ID (SOA03) Passed ", true);
     	   		Reporter.log("Total Claims is correct which is: " + getTotalClaims, true);         	   	   
     	   		Assert.assertTrue(true, "Total Claims is Correct");
     	   		
       }else {
    	   Reporter.log("Test ID (SOA03) Failed ", true);
    	   Assert.fail();
     	  
       }
     
    }
    
    @Parameters({"billingPeriod"})
    @Test (priority = 14)
    public void SOA4(String billingPeriod) {
    	Reporter.log("Start of Test ID (SOA04)", true);    
    	     	    
    	WebElement navSoaReport = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='" + billingPeriod + "']//following-sibling::td//a[@class='k-button k-button-icontext k-grid-report' and text()='SOA']"));
         
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", navSoaReport);


    	navSoaReport.click();
    	
    	 try {
             Thread.sleep(7000);  // Pause for 7 seconds to wait for the page to load
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='k-content-frame']")));
    	 
    	 try {
             Thread.sleep(2000);  // Pause for 2 seconds to wait for the page to load
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ReportsViewerReportFrame']")));
    	 


    	 
    	 WebElement reportDiv = driver.findElement(By.xpath("//div[contains(text(), 'STATEMENT OF ACCOUNT')]"));
    	 if (reportDiv.isDisplayed()) {
    		 
    		    Reporter.log("Successfully navigated to the report page.", true);
    		    Assert.assertTrue(true, "Navigated to the Report");
    		} else {
    		    Reporter.log("Failed to navigate to the report page.", true);
    		    Assert.fail();
    		}
    	
    }
    
    @Parameters({"billingPeriod"})
    @Test (priority = 15)
    public void SOA5(String billingPeriod) {
    	Reporter.log("Start of Test ID (SOA05)", true);    
    	     	    
    	String navSoaReportBillingPeriod = driver.findElement(By.xpath("//div[contains(text(), '"+billingPeriod+"')]")).getText();
         
        Reporter.log(navSoaReportBillingPeriod, true);
    
       	
    	if (billingPeriod.contentEquals(navSoaReportBillingPeriod)) {
     		 Reporter.log("Test ID (SOA05) Passed ", true);
     	   		Reporter.log("Billing Period is valid which is: " + navSoaReportBillingPeriod, true);         	   	   
     	   		Assert.assertTrue(true, "Billing Period is Correct");
     	   		
       }else {
    	   Reporter.log("Test ID (SOA05) Failed ", true);
    	   Assert.fail();
     	  
       }
        

        
}
    @Test (priority = 16)
    public void SOA6() {
    	Reporter.log("Start of Test ID (SOA06)", true);
   
    	     	    
    	String getTotalClaims = driver.findElement(By.xpath("//div[text()='"+this.totalClaims.replace(".00", "").trim().replace(",", "")+"']")).getText();
    
        
    	double totalClaims = Double.parseDouble(getTotalClaims);
    	
    	double FreeTrial = Double.parseDouble(this.freeTrials);
	
    	double TotalClaimsWithFree = totalClaims - FreeTrial;
    	
    	totalClaimsWithFreeFormatted = String.format("%.0f",TotalClaimsWithFree);
    	
    	
    	String getTotalClaimsSubFreeTrial = driver.findElement(By.xpath("//div[(text()='"+totalClaimsWithFreeFormatted+"')]")).getText();
    	
    	
        	
    	if (getTotalClaimsSubFreeTrial.contentEquals(getTotalClaims)) {
     		 Reporter.log("Test ID (SOA06) Passed ", true);
     	   		Reporter.log("Total of Free trial claims: " + FreeTrial, true);     
     	   		Reporter.log("Total Claims without free trial: " + totalClaims, true);
     	   		Reporter.log("Total Claims that deducted free trial: " + totalClaimsWithFreeFormatted, true);
     	   		Assert.assertTrue(true, "Total Claims is Correct");
     	   		
     	   		
       }else {
    	   Reporter.log("Test ID (SOA06) Failed ", true);
    	   Assert.fail();
     	  
       }
    	
    	
  
     
    }
    
    @Test (priority = 17)
    public void SOA7() {
    	Reporter.log("Start of Test ID (SOA07)", true);
        
    	String getTotalAmount = driver.findElement(By.xpath("//div[text()='"+this.formattedTotalAmount.replace("Php", "₱").trim()+"']")).getText();
    	double dbServiceFeeFormatted = Double.parseDouble(this.serviceFee);   	
    	
        String formatteddbServiceFeeFormatted = String.format("%,.2f", dbServiceFeeFormatted);

     
    	double dbFormattedClaims = Double.parseDouble(this.totalClaims);
    	
    	String formattedbFormattedClaims = String.format("%,.2f", dbFormattedClaims);
    	     	    
        double resultTotalAmountServiceFee = dbFormattedClaims * dbServiceFeeFormatted;
    	
       String formattedResultTotalAmountServiceFee = "₱ " + String.format("%,.2f", resultTotalAmountServiceFee);
       
   	if (getTotalAmount.contentEquals(formattedResultTotalAmountServiceFee)) {
		 Reporter.log("Test ID (SOA07) Passed ", true);
	   		Reporter.log("Total Claims: " + formattedbFormattedClaims  , true);     
	   		Reporter.log("Service Fee: " + formatteddbServiceFeeFormatted, true);
	   		Reporter.log("Total Claims * Service Fee: " + formattedResultTotalAmountServiceFee, true);
	   		Assert.assertTrue(true, "Total Amount is Correct");
	   		
	   		
  }else {
	   Reporter.log("Test ID (SOA07) Failed ", true);
	   Assert.fail();
	  
  }
      
    	
   
}
    
    @Test (priority = 18)
    public void SOA8() {
    	Reporter.log("Start of Test ID (SOA08)", true);
        
    	
    	
    	String formattedTotalAmount2 = this.formattedTotalAmount.replace("Php", "").trim().replace(",", "");
    	
       double dbformattedTotalAmount = Double.parseDouble(formattedTotalAmount2);
       
       double ResultDbFormattedTotalAmount = dbformattedTotalAmount / this.vatableValue;
    	
    	      	
    	vatableSales = "₱ " + String.format("%,.2f", ResultDbFormattedTotalAmount);
    	
        String vatableSales = driver.findElement(By.xpath("//div[text()='"+this.vatableSales+"']")).getText();
        
        if (this.vatableSales.contentEquals(vatableSales)) {
   		 Reporter.log("Test ID (SOA08) Passed ", true);
   	   		Reporter.log("Total Amount: " + dbformattedTotalAmount  , true);     
   	   		Reporter.log("Total Amount / 1.12: " + this.vatableSales, true);
   	   		Assert.assertTrue(true, "Vatable Sales is Correct");
   	   		
   	   		
     }else {
   	   Reporter.log("Test ID (SOA08) Failed ", true);
   	   Assert.fail();
   	  
     }
           	     	        	
  
}
    
    @Test (priority = 19)
    public void SOA9() {
    	Reporter.log("Start of Test ID (SOA09)", true);
         
    	double formattedVatSales = Double.parseDouble(this.vatableSales.replace("₱", "").trim().replace(",", ""));
    	
    	double formattedVAT = formattedVatSales * this.vat;
    	
    	valAddedTax = "₱ " + String.format("%,.2f", formattedVAT);
    	   	    	
    	String VatValue = driver.findElement(By.xpath("//div[text()='"+valAddedTax+"']")).getText();
    	   	    	              
        if (valAddedTax.contentEquals(VatValue)) {
   		 Reporter.log("Test ID (SOA09) Passed ", true);
   	   		Reporter.log("Vatable Sales: " + formattedVatSales  , true);     
   	   		Reporter.log("Vatable Sales * 0.12: " + valAddedTax, true);
   	   		Assert.assertTrue(true, "Vatable Added Tax (12%) is Correct");
   	   		
   	   		
     }else {
   	   Reporter.log("Test ID (SOA09) Failed ", true);
   	   Assert.fail();
   	  
     }
           	     	        	
   
}
    
    @Test (priority = 20)
    public void SOA10() {
    	Reporter.log("Start of Test ID (SOA10)", true);
         
    	double formattedVatSales = Double.parseDouble(this.vatableSales.replace("₱", "").trim().replace(",", ""));
    	
    	double formattedVAT = Double.parseDouble(this.valAddedTax.replace("₱", "").trim().replace(",", ""));
    	
    	double resultVatSalesAddVat = formattedVatSales + formattedVAT;
    	
    	String formattedresultVatSalesAddVat = "₱ " + String.format("%,.2f", resultVatSalesAddVat);
    	   	    	
    	String TotalAmount = driver.findElement(By.xpath("//div[text()='"+formattedresultVatSalesAddVat+"']")).getText();
    	
    	   	    	              
        if (formattedresultVatSalesAddVat.contentEquals(TotalAmount)) {
   		 Reporter.log("Test ID (SOA10) Passed ", true);
   	   		Reporter.log("Vatable Sales: " + this.vatableSales  , true);     
   	   		Reporter.log("Value Added Tax: " + this.valAddedTax, true);
   	   		Reporter.log("Current Amount Due: " + formattedresultVatSalesAddVat, true);
   	   	Assert.assertTrue(true, "Current Amount Due is Correct");
   	   		
   	   		
     }else {
   	   Reporter.log("Test ID (SOA10) Failed ", true);
   	   Assert.fail();
   	  
     }
           	     	        	
     
}
    
    
    @Test (priority = 21)
    public void SOA11() {
    	Reporter.log("Start of Test ID (SOA11)", true);
         
    	   	    	
    	String CurrentBalance = driver.findElement(By.xpath("//div[text()='("+this.formattedAllCurrentBalance+")']")).getText();

    	if (CurrentBalance.contentEquals("("+this.formattedAllCurrentBalance+")") || CurrentBalance.contentEquals(("(₱ 0.00)"))) {
       		 Reporter.log("Test ID (SOA11) Passed ", true);
       		Reporter.log("Current Balance in Payment History " + this.formattedAllCurrentBalance, true);
       		Reporter.log("Total amount in Periodical History: " + CurrentBalance, true);
       	   	Assert.assertTrue(true, "Periodical History in SOA is same with Payment History in Collection Module");
       	   		      	   		
         }else {
       	   Reporter.log("Test ID (SOA11) Failed ", true);
       	   Assert.fail();
       	  
         }	
     
           	     	        	      
}
    @Test (priority = 22)
    public void SOA12() {
    	Reporter.log("Start of Test ID (SOA12)", true);
         
    	   	    	
    	String amountDue = driver.findElement(By.xpath("//div[text()='"+this.amountDue.replace("Php", "₱").trim()+"']")).getText();
    	    	    	
    	 if (amountDue.contentEquals(this.amountDue.replace("Php", "₱").trim())) {
       		 Reporter.log("Test ID (SOA12) Passed ", true);
       		Reporter.log("Total Amount Due: " + this.amountDue.replace("Php", "₱").trim(), true);     
   	   		Reporter.log("Total Amount Due in SOA: " + amountDue, true);
       	   	Assert.assertTrue(true, "Overdue balance is correct");
       	   		      	   		
         }else {
       	   Reporter.log("Test ID (SOA12) Failed ", true);
       	   Assert.fail();
       	  
         }	    
           	     	        	
    
}
    @Test (priority = 23)
    public void SOA13() {
    	Reporter.log("Start of Test ID (SOA13)", true);
         
    	   	    	
    	String TotalPayment = driver.findElement(By.xpath("//div[text()='("+this.formattedAllCurrentBalance+")']")).getText();
    	    

    	 if (TotalPayment.contentEquals("("+this.formattedAllCurrentBalance+")"))  {
       		 Reporter.log("Test ID (SOA13) Passed ", true);
       		Reporter.log("Total Payment: " + TotalPayment, true);     
   	   		Reporter.log("Total Payment covered in generated billing: " + ("("+this.formattedAllCurrentBalance+")"), true);
       	   	Assert.assertTrue(true, "Total Amount Due is correct");
       	   		      	   		
         }else {
       	   Reporter.log("Test ID (SOA13) Failed ", true);
       	   Assert.fail();
       	  
         }	    
           	     	        	
      
}
    
    @Test (priority = 24)
    public void SOA14() {
    	Reporter.log("Start of Test ID (SOA14)", true);
             	  
    	//double formatAmountDue = Double.parseDouble(this.amountDue.replace("Php", "").trim());
    	//double formatFormattedTotalAmount = Double.parseDouble(this.formattedTotalAmount)
    	
    	double formatFormattedAllCurrentBalance = Double.parseDouble(this.formattedAllCurrentBalance.replace("₱", "").trim().replace(",", ""));
    	double formatAmountDue = Double.parseDouble(this.amountDue.replace("Php", "").trim().replace(",", ""));
    	double formatFormattedTotalAmount = Double.parseDouble(this.formattedTotalAmount.replace("Php", "").trim().replace(",", ""));
    	
         
    	double resultTad = formatAmountDue + formatFormattedTotalAmount - formatFormattedAllCurrentBalance;
    	
    	String formatResultTad = "₱ " + String.format("%,.2f", resultTad);
    	
    	String Tad = driver.findElement(By.xpath("//div[text()='"+formatResultTad+"']")).getText();
    	
    	 if (Tad.contentEquals(formatResultTad))  {
       		 Reporter.log("Test ID (SOA14) Passed ", true);
       		Reporter.log("Overdue: " + formatAmountDue, true);  
       		Reporter.log("Current Amount Due: " + formatFormattedTotalAmount , true); 
       		Reporter.log("Total Payment: " + "("+formatFormattedAllCurrentBalance+")", true); 
   	   		Reporter.log("TAD: " + Tad,  true);
       	   	Assert.assertTrue(true, "TAD is valid");
       	   		      	   		
         }else {
       	   Reporter.log("Test ID (SOA14) Failed ", true);
       	   Assert.fail();
       	  
         }	    
           	     	
    	
    	
        driver.switchTo().defaultContent();
}
    @Parameters({"link2", "Hospital", "billingPeriod", "billingDate"})
    @Test (priority = 25)
    public void SOA15(String link2, String Hospital, String billingPeriod, String billingDate) {
    	Reporter.log("Start of Test ID (SOA15)", true);
             	  
    	driver.get(link2);
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
	 	   WebElement kebabIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div[3]/div[2]/div/table/thead/tr/th[1]/a[1]/span")));
	 
	 kebabIcon.click();
	 
	 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 	   
	 WebElement hoverFilter = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[6]/span"));
	   
	   Actions actions1 = new Actions(driver);
 actions1.moveToElement(hoverFilter).perform();
 
 WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/ul/li[6]/div/ul/li/div/form/div/input")));
 
 textBox.sendKeys(Hospital);
 textBox.sendKeys(Keys.ENTER);
 
 try {
	            Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
 WebElement navClaimReport = driver.findElement(By.xpath("//td[@data-field='BillingPeriod' and text()='" + billingPeriod + "']//following-sibling::td//a[@class='k-button k-button-icontext k-grid-view' and text()='Claims']"));
 
	JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", navClaimReport);
           	     	
    	
 navClaimReport.click();
 
 try {
     Thread.sleep(3000);  // Pause for 3 seconds to wait for the page to load
 } catch (InterruptedException e) {
     e.printStackTrace();
 }
 
 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
 
 String TotalClaims = driver.findElement(By.xpath("//h4[@class='content-header total-claims' and contains(text(),'"+this.totalClaims.replace(".00", "").trim().replace(",", "")+"')]")).getText();
    
 String TotalClaimsTrim = TotalClaims.trim();
 
 String cleanedTotalClaimsText = TotalClaimsTrim.replaceAll("[^\\d]", "");
 
  String formatTotalClaims =  this.totalClaims.replace(".00", "").trim().replace(",", "");
 
 String rowCount = String.format("//tr[td[@data-field='StatementDate' and text()='"+billingDate+"'] and td[@data-field='BillingPeriod' and text()='"+billingPeriod+"']]");
 int rowCounted = driver.findElements(By.xpath(rowCount)).size();
 
 String rowCountedText = String.valueOf(rowCounted);
 
 if (formatTotalClaims.contentEquals(rowCountedText))  {
		 Reporter.log("Test ID (SOA15) Passed ", true);
		Reporter.log("Total Claims: " + cleanedTotalClaimsText, true);  
		Reporter.log("Billing Period: " + billingPeriod, true); 
		Reporter.log("Statement Date: " + billingDate, true); 
	   	Assert.assertTrue(true, "Total Claims, Statement Date, and Billing Period are valid");
	   		      	   		
 }else {
	   Reporter.log("Test ID (SOA15) Failed ", true);
	   Assert.fail();
	  
 }	    

 driver.switchTo().defaultContent();
}
    
}
    


