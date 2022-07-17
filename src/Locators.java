
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//using class as a css selector: put a .before the classname and it behaves like a css selector
		//when using id, put a # before id and it behaves like a css selector
		//when there is a space b/w classnames using a . to remove the white spaces as classnames used as accs selectors cannot have white spaces in between
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// the below command is to manage timeouts on a page, to wait for certain time unti atleast one element is detected on page
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("AniSG");
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
	//	driver.findElement(By.className("submit")).click();
		driver.findElement(By.cssSelector("button.submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Ani");
		driver.findElement(By.xpath("//input[@type='text'][1]")).clear();
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Anindita Sengupta");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("anisg07@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("987654321");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='infoMsg']")).getText());
		
		//syntax for passing dynamic variables using xpath
		driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		
		//syntax for passing dynamic locator values for css selector
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		//on providing locators with classname and it has two classes for eg: submit signin, you can provide one classname to identify the field
		driver.findElement(By.className("signInBtn")).click();
		
	
		
		
		
		
		
		
	}
}
