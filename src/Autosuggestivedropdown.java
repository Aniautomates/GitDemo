import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdown {

	public static void main(String[] args) throws InterruptedException {
		
        String url = "https://qaclickacademy.com/practice.php" ;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000L);
		//helps in selecting the value from teh dynamic list. we will put keys down teh number of times we donot get our desired result
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		
		// we can get the table value using javascript query attrubute syantax explained in Practiceexercise6 else we can use a frontend command of getAttribute("value")
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
