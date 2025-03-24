import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
		driver.get("https://lms-frontend-803019860386.asia-south1.run.app/lesson-plan/");
	}

	@BeforeTest	
	public static void timeout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

    
	@Test
	public static void loginPage() {
		driver.findElement(By.xpath("//*[@id=\":r7:-label\"]")).sendKeys("teacher1@gmail.com");
		driver.findElement(By.xpath("//*[@id=\":r8:-label\"]")).sendKeys("Test@123");
		timeout();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/main/div/div[2]/div/div/form/div[2]/div[3]/label/span[1]/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/main/div/div[2]/div/div/form/div[2]/button")).click();
		
		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("", null);
	}
	
	@Test
	public static ArrayList<String> getData()
	{
		
		String filepath = "";
		ArrayList<String> links = new ArrayList<String>();
		  
	        try {
	        		FileInputStream fis = new FileInputStream(new File(filepath));
	            // Create a workbook instance (for .xlsx files)
	            Workbook workbook = new XSSFWorkbook(fis);
	            
	            // Get the first sheet from the workbook
	            Sheet sheet = workbook.getSheetAt(0);
	            
	            // Iterate through each row in the sheet
	            for (Row row : sheet) {
	                
	                // Iterate through each cell in the row and add only string values
	                for (Cell cell : row) {
	                    if (cell.getCellType() == CellType.STRING) {
	                        String cellValue = cell.getStringCellValue();
	                        links.add(cellValue);
	                    }
	                }}
	        return links;
    } catch (IOException e) {
        e.printStackTrace();
        return links;
    }}
	            
    
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
