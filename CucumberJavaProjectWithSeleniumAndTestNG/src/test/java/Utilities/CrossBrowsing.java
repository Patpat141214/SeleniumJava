package Utilities;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class CrossBrowsing {
	

	public static WebDriver open(String browser) {
		  if (browser.equalsIgnoreCase("google")) {
			   return new ChromeDriver ();

		   }else {
			    return new FirefoxDriver();
			    
		   }

}
}