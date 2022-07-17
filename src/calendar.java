import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class calendar {

	public static void main(String[] args) {
		
		//Assignment to navigate to the product table: 1. row count 2. column count 3. print value of 2nd row in teh table
        String url = "https://qaclickacademy.com/practice.php" ;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		WebElement table = driver.findElement(By.id("product"));
		
		int rowcount = table.findElements(By.xpath("//fieldset/table[1]/tbody[1]/tr")).size();
		System.out.println("Row Count of table is: " + rowcount);
		
		int columnCount = driver.findElements(By.xpath("//fieldset/table[1]/tbody/tr[1]/th")).size();
		System.out.println("Column Count of table is: " + columnCount);
		
	
		List<WebElement> secondrowprint = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrowprint.get(0).getText());
		System.out.println(secondrowprint.get(1).getText());
		System.out.println(secondrowprint.get(2).getText());
	
	}

}
