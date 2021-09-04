package co.in.bymat.projectName.ModuleName.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;

public class TestBase_B9 { // Heart of Framework
	
	public static WebDriver driver; // Global variable
	public static Properties config = new Properties(); // Global variable
	public static Properties or = new Properties(); // Global variable
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExcelReader excel;
	public static String ScreenShot;
	public static String testCaseName;
	public static Hashtable<String, String> HT_RunMode = new Hashtable();
	
	@BeforeSuite
		public void initialization() throws IOException {
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\files\\Config.properties");
		config.load(fis);
		System.out.println("Config file has been loaded");

		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\files\\OR.properties");
		or.load(fis1);
		System.out.println("OR file has been loaded");
		
		excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		String timestamp = new SimpleDateFormat("YYYY_MM_dd_HH_mm_SS").format(new Date());
		report = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\executionReports\\ExecutionReport_"+timestamp+".html");
		
		loadHashTable();
	}
	
	//@BeforeMethod
	public void launchBrowser() throws IOException { // Pre-Condition

		if (config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (config.getProperty("Browser").equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
					+ "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); // not reco
			
		} else if (config.getProperty("Browser").equalsIgnoreCase("EDGE")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
					+ "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		} else {
			driver = new InternetExplorerDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		test = report.startTest(testCaseName);		
		driver.get(config.getProperty("ApplicationURL_Test"));
		
		test.log(LogStatus.PASS, "User navigated to Application URL" +config.getProperty("ApplicationURL_Test"));
	}
	
	//@AfterMethod
	public void closeBrowser() throws InterruptedException { // postCondition
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	//@AfterClass
	 @AfterSuite
	public void endReport() {	
		report.endTest(test);
		report.flush();
	}

	public static void takeScreenShot() throws Exception { // code re-usability

		String timestamp = new SimpleDateFormat("YYYY_MM_dd_HH_mm_SS").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\screenShots\\Passed\\screenshot_" + timestamp + ".png";
		// Now you can do whatever you need to do with it, for example copy somewhere
		File dest = new File(screenShotPath);
		FileHandler.copy(scrFile, dest);
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));
		
	}
	
	
	public static void takeScreenShot_Fail() throws Exception { // code re-usability

		String timestamp = new SimpleDateFormat("YYYY_MM_dd_HH_mm_SS").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\screenShots\\Failed\\screenshot_" + timestamp + ".png";
		// Now you can do whatever you need to do with it, for example copy somewhere
		File dest = new File(screenShotPath);
		FileHandler.copy(scrFile, dest);
		test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		
	}
	
	@DataProvider
	public static Object[][] data_Collection() {
		
		//DataCollection dc = new DataCollection(excel, "Test_Data", "loginToMyStore");
		
		DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);
		
		return dc.dataArray();
	}
	
	public static void loadHashTable() {
		
		int rows = excel.getRowCount("TestCases");
		System.out.println("Total number of rows: " +rows);
		
		for(int i = 2; i<= rows; i++) {
			
			String key = excel.getCellData("TestCases", "TestCase_Name", i);
			
			String value = excel.getCellData("TestCases", "Run_Mode", i);
			
			HT_RunMode.put(key, value);
		}
		
		System.out.println("My Run mode HT data is:- " +HT_RunMode);
		
	}

}
