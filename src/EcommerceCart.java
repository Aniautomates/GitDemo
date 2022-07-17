import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//declaring an array of items we will add to cart
		String[] itemsNeeded = {"Beetroot","Tomato","Brinjal","Capsicum"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		//as this is a static method so can be called w/o creating a new object of the class
		addItems(driver,itemsNeeded);
		
		//or else can be called as below, as this is a static method we can directly call the method w/o creating an object of that class
		
//		EcommerceCart n = new EcommerceCart();
//		n.addItems(driver, itemsNeeded);
		
		
		//adding implicite wait time, syntax below, declared globally and will be applied to every step of teh code
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//adding explicut wait, explicite waits can be declared globally, and the methods can be implemented exactly where its needed within teh code, w/o affecting the entire code
		WebDriverWait w = new WebDriverWait(driver,5);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//implementing an implicit wait to wait for the page elements to load
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//implementing another wait to verify the promocode text
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	
		
		}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		//fetching and storing all the products in a list
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));


		
		//now we are iterating through all the products to search our matching product, size gives the count of the matching product on teh webpage
		for (int i=0; i<products.size() ; i++)
		{
			//the index value will be passed through i
			//what value is fetched in i, will be fetched by gettext
			
			//we are declaring a string here and fetching the name of the product, now if we need to 
			//fetch the exact name of the product from this: Mushroom - 1 Kg, the string becomes an array now after Splitting
			String[] name = products.get(i).getText().split("-");
			String formattedproductName = name[0].trim(); //trim is used to trim any whitespace
			
			//converting Array to ArrayList during runtime takes less memory
			List itemsNeededList = Arrays.asList(itemsNeeded);
			{
				//now it checks whether the required product is present in the Arraylist
				if(itemsNeededList.contains(formattedproductName))
				{
					//then Add to cart
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					
					
				}
			}
			
		}
	}
}

