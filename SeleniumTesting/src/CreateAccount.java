import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class CreateAccount {

	public static void main(String[] args) {
		   WebDriver driver = new ChromeDriver ();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       driver.get("https://demoqa.com/automation-practice-form");
	       
	       driver.manage().window().maximize();
	       
	       driver.findElement(By.id("firstName")).sendKeys("patpat");
	       driver.findElement(By.id("lastName")).sendKeys("asdadsadas");
	       driver.findElement(By.id("userEmail")).sendKeys("asdada@gmail.com");
	       driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
	       driver.findElement(By.id("userNumber")).sendKeys("0957856218");
	     
	       
	       wait.until(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
	          
	       driver.findElement(By.id("dateOfBirthInput")).click();
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.BACK_SPACE);
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys("3");
	       driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);    
	       
	       
	       driver.findElement(By.id("subjectsInput")).sendKeys("com");
	       driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
	       
	       WebElement checkbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	       //driver.findElement(By.xpath("//div[@id='subjectsContainer']")).click();
	      
	      driver.findElement(By.id("currentAddress")).sendKeys("52 Purok 4");
	       
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
	       
	       try {
	           Thread.sleep(5000); // Pause for 2 seconds to wait for the page to load
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       
	       driver.findElement(By.id("closeLargeModal")).click();
	       
	       
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
	      driver.quit();

	}

}
