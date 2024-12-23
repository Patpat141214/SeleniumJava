package com.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepsDefinition {
	WebDriver driver;
	String url  = "https://thinking-tester-contact-list.herokuapp.com/addUser";

	
	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {
	    Reporter.log("Proceed to URL", true);
	    
	    driver = Utilities.CrossBrowsing.open("google");
	    driver.get(url);
	    driver.manage().window().maximize();
	    	    
	}

	@When("I fill in valid details")
	public void i_fill_in_valid_details() {
		
		Reporter.log("Inputting Valid Credential", true);
	    WebElement fName = driver.findElement(By.id("firstName"));
	    fName.sendKeys("Patche12141214");
	    WebElement LName = driver.findElement(By.id("lastName"));
	    LName.sendKeys("Fenacaszx");
	    WebElement email = driver.findElement(By.id("email"));
	    email.sendKeys("as82hn65002688g22S3hhJs@gmail.com");
	    WebElement pass = driver.findElement(By.id("password"));
	    pass.sendKeys("123123123");
	    
	   
	    
	}

	@Then("I should successfully registered an account")
	public void i_should_successfully_registered_an_account() {	 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Reporter.log("Click Submit Button", true);
		
		 driver.findElement(By.id("submit")).click();
		
	
		 WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='logout' and @class='logout' and text()='Logout']")));
		
		try {
			Assert.assertTrue(logoutButton.isDisplayed(), "Add Contact button is visible");
			
		}catch (Exception e) {
			e.getMessage();
			Assert.fail("Add Contact button is not visible");
		}
	
		

	}

}
