import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ICT_Flow {

	static WebDriver driver;
    
	@BeforeTest 
	public static WebDriver getDrivers() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shivani.jaiswal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	@BeforeTest
	public static void getURL() {
		driver.get("https://ict-recurring-uat.web.app/");
	}

	@BeforeTest	
	public static void timeout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

    
	@Test
	public static void loginPage() {
		driver.findElement(By.xpath("//input[@id='Email Address']")).sendKeys("sufi.sawant@gmail.com");
		driver.findElement(By.xpath("//input[@id='Email Address']//following::input[1]")).sendKeys("Ram@1234");
		timeout();
		driver.findElement(By.xpath("//button//following::button[1]")).click();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("", null);
	}
    
     @AfterTest
     public static void closeDriver()
     {
    	 
    	 driver.quit();
     }
	
	//public static void main(String args[]) {
		// ICT_Flow ictFlow = new ICT_Flow();
		//getDrivers();
		//getURL("https://ict-recurring-uat.web.app/");
//		loginPage();
//		closeDriver();
}
