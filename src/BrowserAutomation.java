import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91943\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//in order to open the browser window in maximize mode
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		// to open another url in the current window w/o opening another tab
		driver.navigate().to("https://rahulshettyacademy.com");
		
		//to go back to google homepage
		driver.navigate().back();
		
		//to navigate forward to rahul shetty academy page
		driver.navigate().forward();
		
	}

}
