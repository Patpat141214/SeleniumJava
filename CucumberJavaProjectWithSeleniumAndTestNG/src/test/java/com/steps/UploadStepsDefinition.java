package com.steps;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadStepsDefinition {
	WebDriver driver;
	String WebUrl = "https://practice.expandtesting.com/upload";
	
	
	@Given("I am on the file upload page")
	public void i_am_on_the_file_upload_page() {
	    // Write code here that turns the phrase above into concrete actions
		Reporter.log("Navigating to URL", true);
	   driver = Utilities.CrossBrowsing.open("google");
	   driver.manage().window().maximize();
	   driver.get(WebUrl);
	
	}
	
	@When("I upload the PDF file")
	public void i_upload_the_pdf_file() {

		Reporter.log("Uploading File", true);
		WebElement Uploader = driver.findElement(By.id("fileInput"));
		String FileLocation = "C:\\QA Files\\SeleniumQNA.docx";
	    Uploader.sendKeys(FileLocation);
	    
	    driver.findElement(By.id("fileSubmit")).click();
	    
	}
	
	@Then("I should see the upload success message")
	public void i_should_see_the_upload_success_message() {
	    
		String SuccessMessage1 = driver.findElement(By.id("uploaded-files")).getText();
		WebElement SuccessMessage = driver.findElement(By.id("uploaded-files"));
		
			try {
			System.out.println(SuccessMessage1);
			Reporter.log("File Successfully uploaded!", true);
			Assert.assertTrue(SuccessMessage.isDisplayed(), "Successfully Uploaded!");
			
		}catch (Exception e) {
			
			e.getMessage();
			Assert.assertFalse(SuccessMessage.isDisplayed(), "Upload Failed!");
		}
		
		
		
		
	   
	}


}
