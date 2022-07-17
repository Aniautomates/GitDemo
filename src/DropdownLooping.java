

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DropdownLooping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//2000L means 2000 long same as writing 2000
		Thread.sleep(2000L);
		
		//*** Selecting a dropdown and then choosing multiple values by dropdown looping*****//
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		//by default 1 value is present, we need to pass 6 values for adults
		driver.findElement(By.id("hrefIncAdt")).click();
		
		//while loop: initialization, assignment, comparison
		int i=1;
	
        while(i<6)	
        {
        	driver.findElement(By.id("hrefIncAdt")).click();
        	i++;
        }
        
       //selecting two child
        
        for(int j=0; j<2; j++)
        {
        	 driver.findElement(By.id("hrefIncChd")).click();
        }
		
        driver.findElement(By.id("btnclosepaxoption")).click();
        
        //******end of selecting values by iteration******
        
        
        //************** Handling Dynamic DRopdowns******************//
        
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@text='Adampur (AIP)']")).click();
        
        //***selecting destination***
        
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        
        //the below statement throws an error because there are two instances of the same element one coming from arrival list and another from destination list, and our requirement is the one in destination list, hence we need to modify xpath accordingly with index
      //  driver.findElement(By.xpath("(//a[@text='Goa (GOI)'])[2]")).click();
        
        //now what if using index is not the best coding practise, so below is an alternate way to access teh same webelement
//is by traversing from parent-child, first capture the parent div and find the required child element from in there for uniqueness
 // syntax is parentxpath childxpath - one white space in between       
driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Goa (GOI)']")).click();
	
	
	//**********End of Handling Dynamic Dropdowns*********//

//******** Handling Auto suggestive dropdowns********//

driver.findElement(By.id("autosuggest")).click();


driver.findElement(By.id("autosuggest")).sendKeys("Mauritius");

//in order to get a list of all values that the auto list is returning on selectinga value, can be obtained by findelements method, syntax below
//in css selector we use a space traversing from parent to child: Parentclass child class wheres xpath is wrirren as parentclass/childclass

List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

//we create a loop to iterate through teh webelemt options until we get our required value

for(WebElement option : options)
{
	if(option.getText().equalsIgnoreCase("Mauritius"));
	break;
	}

//******** End of Handling Auto suggestive dropdowns********//



//******HandlingCheckboxes and Number of checkboxes Count**************//

driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

//size gives you the number of boxes present on the webpage
System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

//to find out the count of number of check boxes selected on a page

int k=0;
for (WebElement we:driver.findElements(By.cssSelector("input[type='checkbox']")))
		{
    if (we.isSelected()) { k++; }
}
System.out.println(k
            + " Number of check boxes present in the page");


//******End of HandlingCheckboxes and Number of checkboxes Count**************//

	
	
	
	
	
	}

}
