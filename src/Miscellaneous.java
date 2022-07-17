import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Miscellaneous {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		// ******** THIS IS THE CODE FOR VALIDATING BROKEN LINKS, HARD ASSERT AND SOFT ASSERT ********** //
		
String url = "https://rahulshettyacademy.com/AutomationPractice/" ;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		//to validate the status code of all links present ina  footer we start by storing them in a list webelement
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		//declaring soft assert class object
		SoftAssert a = new SoftAssert();
		
		//now we calling each link present in teh list
		
		for(WebElement link: links)
		{
			
			// we can replace this: driver.findElement(By.cssSelector("a[href*='brokenlink']") with link as now link contains the entire thing
			String url1 = link.getAttribute("href");
			
			//OpenConnection is a method of class URL, hence creating an object of that class and casting the type in it
			//and pass url 1 as the argument of the object
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url1).openConnection();
			conn.setRequestMethod("HEAD");
			int RespCode = conn.getResponseCode();
			a.assertTrue(RespCode > 400, "The link with the text " +link.getText()+ "failed with " + RespCode);
			
			//we will comment out the below part while using soft assert, we use the below part when using hard assert
		/*	if(RespCode >400)
			{
				//link.getText will get you the text of the link that is broken
				System.out.println("The link with the text " +link.getText()+ "failed with " +RespCode );
				Assert.assertTrue(false);
			}*/
			
			//now doing the same checking by introducing soft assertions, for which need to modify the above code a bit
		
		}
		
		
		
 
		

	}

}
