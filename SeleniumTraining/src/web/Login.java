package web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://manager.easyclaimsph.com");
		
		driver.findElement(By.name("Username")).sendKeys("patche1214");
		driver.findElement(By.name("Password")).sendKeys("1234567");
		driver.findElement(By.id("submitBtn")).click();
		
		String element = driver.findElement(By.xpath("//div[text()='Home Page']")).getText();
		
	
			System.out.println("Successfully Login" + "\nNavigated to: " + element);
		
			String pageTitle = driver.getTitle();
			
			System.out.println("Page Title: " + pageTitle );
		
			driver.quit();
		
	}

}
