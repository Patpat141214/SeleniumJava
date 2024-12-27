package com.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = { "com.steps" },
		plugin = { "pretty", 
		"html:target/cucumber-Report.html" },
		tags = "@UploadTesting" )
		

public class TestNgRunner extends AbstractTestNGCucumberTests {

}
