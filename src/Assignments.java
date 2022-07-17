import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignments {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	//	driver.manage().window().maximize();
		
		//*******Assignment 1*********//
		
	//	boolean x = driver.findElement(By.id("checkBoxOption1")).isSelected();
		
		//if checkbox is not selected, select it using click method
		
//		if (x == false)
//		{
//			driver.findElement(By.id("checkBoxOption1")).click();
//		}
//		
//		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
	//	driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//if checkbox is selected, deselect it using click as well
		
//		if ( x == true)
//		{
//			driver.findElement(By.id("checkBoxOption1")).click();
//		}
	//	Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
//		Thread.sleep(1000);
//		driver.findElement(By.id("checkBoxOption1")).click();
//		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//<input id="checkBoxOption1" value="option1" name="checkBoxOption1" type="checkbox">
//		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
//		driver.close();
		
		//*********************Assignment 1**********************//
		
		//*****************************Assignment 2************************//
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//form-comp[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Anindita Sengupta");
		driver.findElement(By.xpath("//form-comp[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("anisg07@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		driver.findElement(By.id("exampleCheck1")).isSelected();
		
		WebElement Staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown = new Select(Staticdropdown);
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).isSelected();
		driver.findElement(By.name("bday")).sendKeys("01/02/2022");
		driver.findElement(By.cssSelector("input[class*=btn]")).click();
		
		//alert alert-success alert-dismissible
		
		//Assert.assertEquals(driver.findElement(By.cssSelector(".alert-success")).getText(), "Success! The Form has been submitted successfully!.");
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		driver.close();
		
		
		//*******************************Assignment 2**************************//
		
	
		

	}

}
