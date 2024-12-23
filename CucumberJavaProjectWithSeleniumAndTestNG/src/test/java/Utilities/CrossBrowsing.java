package Utilities;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class CrossBrowsing {
	

	public static WebDriver open(String browser) {
		
		  if (browser.equalsIgnoreCase("google")) {
		   return new ChromeDriver ();

	   }else {
		   return new FirefoxDriver();
		    
	   }

		 //if (browser.equalsIgnoreCase("google")) {
	            // Set up ChromeOptions for headless mode
	          //  ChromeOptions options = new ChromeOptions();
	           // options.addArguments("--headless"); // Run in headless mode
	            //options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
	           // options.addArguments("--no-sandbox"); // Disable sandboxing, necessary on some systems
	           // options.addArguments("--remote-debugging-port=9222"); // Allow remote debugging

	            // Return the ChromeDriver with the specified options
	           // return new ChromeDriver(options);
	      //  } else {
	            // Return FirefoxDriver if the browser is not Google Chrome
	       //     return new FirefoxDriver();
	        }
	    }
	
	
