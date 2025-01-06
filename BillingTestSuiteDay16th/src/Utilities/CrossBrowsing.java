package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowsing {
	public static WebDriver open(String browser) {
		  if (browser.equalsIgnoreCase("google")) {
			   return new ChromeDriver ();

		   }else {
			    return new FirefoxDriver();
			    
		   }

}
}
