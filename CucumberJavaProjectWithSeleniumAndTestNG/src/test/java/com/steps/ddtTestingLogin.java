package com.steps;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ddtTestingLogin {
	
	WebDriver driver;
	String WebUrl = "http://172.30.1.26/Published_eSOA4/Account/Login?ReturnUrl=%2FPublished_eSOA4%2F";

	
	  List<List<String>> testData = new ArrayList<>(
		        Arrays.asList(
		            Arrays.asList("patche@admin", "123123123"),
		            Arrays.asList("patche@admin1", "123123123")
		        )
		    );

	@Test
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		
		Reporter.log("Navigate to URL", true);
		driver = Utilities.CrossBrowsing.open("google");
		driver.manage().window().maximize();
		driver.get(WebUrl);
				
	
	}
	@Test
	@When("I test multiple login credentials")
	public void i_test_multiple_login_credentials() {
		 for (List<String> credentials : testData) {
	            String username = credentials.get(0);
	            String password = credentials.get(1);
	         	
	            Reporter.log("Entering Valid Credentials", true);
	            Login(username, password);
	            
	        }
		 
	}
	
	
	@Test
	@Then("I verify the login results")
	public void i_verify_the_login_results() {
	
		 for (List<String> credentials : testData) {
	            String username = credentials.get(0);
	            String password = credentials.get(1);
	         	
	            Reporter.log("Verifying Login Results", true);
	            LoginForAssertion(username, password);
	            
	        }
	    }
	
	public void Login(String usr, String pass){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement user =  driver.findElement(By.id("Username"));
		WebElement passw =  driver.findElement(By.id("Password"));
		 
		  user.clear();
		    passw.clear();
		    
		    user.sendKeys(usr);
		    passw.sendKeys(pass);
		    
		    driver.findElement(By.id("submitBtn")).click();
		    Reporter.log("Logged in with Username: " + usr);
		    
		    WebElement logoutButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='flex-grow commandbar-item-text' and text() = 'Log off']")));
		    logoutButton.click();
		   				
	}
	
	public void LoginForAssertion(String usr, String pass){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement user =  driver.findElement(By.id("Username"));
		WebElement passw =  driver.findElement(By.id("Password"));
		 
		  user.clear();
		    passw.clear();
		    
		    user.sendKeys(usr);
		    passw.sendKeys(pass);
		    
		    driver.findElement(By.id("submitBtn")).click();
		    
		    Reporter.log("Logged in with Username: " + usr);
		    
		   WebElement connect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='content-header' and text() = 'Connect']")));
		   
		 
		   
		   try {
			   Assert.assertTrue(connect.isDisplayed(), "Valid Credential");
			   Reporter.log("Successfully proceed to Connect Page");
		   }catch (Exception e) {
			   e.getMessage();
			   Assert.fail("Invalid Credential");
			   Reporter.log("Did not proceed to Connect Page");
			   
		   }
		  
		    
		    WebElement logoutButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='flex-grow commandbar-item-text' and text() = 'Log off']")));
		    logoutButton.click();
		   				
	}
	
	
	
		
	}
	
	
	
