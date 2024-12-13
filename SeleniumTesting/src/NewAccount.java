import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

	public static void main(String[] args) {
		String fName = "patpat";
		String lName = "asdadsadas";
		String uName = "asdada@gmail.com";
		String uNumber = "0957856218";
	    Keys dObBS = Keys.BACK_SPACE;
	    Keys dObEnt = Keys.ENTER;
	    String dObNu = "3";
	    String subIn = "com";
	    String curAddress = "52 Purok 4";
	    String browser = "GOOGLE"; 
	    String browser1 = "firefox";
	    String gender = "Female";
	    WebDriver driver;
	    
	    driver = utilities.DriverFactory.open(browser);
	   
		 //WebDriver driver = new FirefoxDriver();	
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       driver.get("https://demoqa.com/automation-practice-form");
	      
	       
	       driver.manage().window().maximize();
	       
	       driver.findElement(By.id("firstName")).sendKeys(fName);
	       driver.findElement(By.id("lastName")).sendKeys(lName);
	       driver.findElement(By.id("userEmail")).sendKeys(uName);
	       WebElement femaleRad = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
	       WebElement maleRad = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
	     
	       if(gender.equalsIgnoreCase("female")) {
	    	   femaleRad.click();
	       }else {
	    	   maleRad.click();
	       }
	       
	       WebElement userNo = driver.findElement(By.id("userNumber"));
	       userNo.sendKeys(uNumber);

	     
	       
	       wait.until(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
	          
	       driver.findElement(By.id("dateOfBirthInput")).click();
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys(dObBS);
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys(dObNu);
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys(dObEnt);    
	       
	       
	       driver.findElement(By.id("subjectsInput")).sendKeys(subIn);
	       driver.findElement(By.id("subjectsInput")).sendKeys(dObEnt);
	       
	       WebElement checkbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	       //driver.findElement(By.xpath("//div[@id='subjectsContainer']")).click();
	      
	      driver.findElement(By.id("currentAddress")).sendKeys(curAddress);
	       
	       WebElement element = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class, 'css-1hwfws3')]"));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	       element.click();
	      

	       //driver.findElement(By.xpath("//div[@id='state']//div[contains(@class, 'css-1hwfws3')]")).click();
	       
	       
	       driver.findElement(By.xpath("//div[text()='NCR']")).click();
	       
	       WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class, 'css-1hwfws3')]"));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", city);
	       city.click();
	       
	       driver.findElement(By.xpath("//div[text()='Delhi']")).click();
	       
	       
	       driver.findElement(By.id("submit")).click();
	       
	       
	       String conf = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
	       String message = "Thanks for submitting the form";
	       
	       if(conf.equalsIgnoreCase(message)) {
	    	   System.out.println("Successfully Registered");
	       }else {
	    	   System.out.println("Failed");
	       }
	       
	       

	       
	       try {
	           Thread.sleep(10000); // Pause for 2 seconds to wait for the page to load
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       

	       // Select the option "NCR"
	       //driver.findElement(By.xpath("//div[contains(@id, 'react-select-3-option-0')]")).click();
	       
	      
	     

	       
	       //driver.findElement(By.cssSelector("span[class='rct-checkbox']")).click();
	       //driver.findElement(By.cssSelector("input[id='impressiveRadio'][name='like']")).click();
	       //driver.findElement(By.id("signup")).click();
	       //driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("patpat");
	       //driver.findElement(By.id("lastName")).sendKeys("f");
	       //driver.findElement(By.id("email")).sendKeys("36ss222222nk3@gmail.com");
	       //driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123123123");
	      // driver.findElement(By.id("submit")).click();
	       

	      //String element = driver.getTitle();


	        //System.out.println("Sucessfully Created Account: " + "Redirected To Add User: " + element);
	


	}

}
