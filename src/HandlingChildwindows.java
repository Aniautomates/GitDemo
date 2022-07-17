import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingChildwindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); //[parentId,childId,subchildId]
		Iterator<String> it = windows.iterator(); //to iterate from parent to child window
		String parentId = it.next(); //holds parent window
		String childId = it.next(); //holds child window
		
		driver.switchTo().window(childId); // switched from parent to child window
		WebDriverWait w= new WebDriverWait(driver,5); //adding explicit wait for the page to load
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='logo']")));
	//	driver.findElement(By.cssSelector(".im-para.red")).getText(); //getting the text containing email id
	//	String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]; //extracted teh email id from teh red text
		
		System.out.println(driver.findElement(By.xpath("//span[text()=' contact@rahulshettyacademy.com']")).getText());
	//	driver.switchTo().window(parentId);
	//	driver.findElement(By.id("username")).sendKeys(emailId);
		

	}

}
