import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeExercise6 {

	public static void main(String[] args) {
		
		String url = "https://qaclickacademy.com/practice.php" ;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		boolean isSelected = checkbox.isSelected();
		
		while(isSelected == false) 
		{
			checkbox.click();
		
			break;
			
			
		}
		String dropdownvaluetext =	driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		//initializing new dropdown value
		
		Select s = new Select(dropdown);
		s.selectByVisibleText(dropdownvaluetext);
		
		driver.findElement(By.id("name")).sendKeys(dropdownvaluetext);
		driver.findElement(By.id("alertbtn")).click();
		
		String getAlertText = driver.switchTo().alert().getText();
		
		if (getAlertText.contains(dropdownvaluetext))
		{
			System.out.println("Success");
			driver.switchTo().alert().accept();
			
		}else
		{
			System.out.println("Try again");
		}
		
		
		
		

	}

}
