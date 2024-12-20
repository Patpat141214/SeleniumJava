package com.steps;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition {
	WebDriver driver;
	String webUrl = "http://172.30.1.26/Published_eSOA4";
	

	@Test
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		
		Reporter.log("Proceed to Login Page", true);
		driver = Utilities.CrossBrowsing.open("google");
		driver.get(webUrl);
		driver.manage().window().maximize();

	}
	@Test
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		
		Reporter.log("Entering valid credential", true);
		driver.findElement(By.id("Username")).sendKeys("patche@admin");
		driver.findElement(By.id("Password")).sendKeys("123123123");

	}
	@Test
	@When("Click login Button")
	public void click_login_button() {
		
		Reporter.log("Click login button", true);
		driver.findElement(By.id("submitBtn")).click();
		
	}
	@Test
	@Then("User should be navigated to Connect Page")
	public void user_should_be_navigated_to_connect_page() {
		
		Reporter.log("Proceeding to Connect Page", true);
	
		WebElement labelCon = driver.findElement(By.xpath("//div[@class='content-header' and text()='Connect']"));
		try {
			if (labelCon.isDisplayed()) {
				Assert.assertTrue(labelCon.isDisplayed(),"Connect Label is visible");
				
			}
			else {
				Assert.assertFalse(labelCon.isDisplayed(), "Connect Label is not Visible");
				Assert.fail("Connect Label is not Visible");
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
	}
	@Test
	@Then("Close the browser")
	public void close_the_browser() {
      Reporter.log("Closing the browser", true);
      driver.quit();
	} 
}
