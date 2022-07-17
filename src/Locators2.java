import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//we atre using driver object to access the getPassword method
		String name= "ani";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='infoMsg']")).getText());
		driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		Thread.sleep(1000);
		//on providing locators with classname and it has two classes for eg: submit signin, you can provide one classname to identify the field
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		//driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		 //Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello" + name + ",");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//locators can be identified by text names and a * can be used in place of tagname, in this case * can be used in place of button tagname
		//if only one occurance of that div is in the page, else provide the unique tag name, this method cannot be used for css
	
		// locating by button name
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordtext = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordarray = passwordtext.split("'");
		
		//Now on split at index[0] we will have //Please use temporary password '
		//and index[1] will have: ' to Login.
		
	//	Below are the two ways to capture the index:
		//*****First one***
		
		String[] passwordarray2 = passwordarray[1].split("'");
		String password=passwordarray2[0]; //Here after split the left side of the ' contains are desired password which is at index 0, hence extracting that in a string
		return password;
		
		//second one
		
	// String password = passwordarray[1].split("'")[0];
	//	return password;
	
		
	}
}
