package co.in.bymat.projectName.ModuleName.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;

public class LoginToMyStore2 extends TestBase_B9 {
	
	
	@BeforeClass
	public void testCaseName() {
		
	testCaseName = this.getClass().getSimpleName();
	
	if(!HT_RunMode.get(testCaseName).equalsIgnoreCase("Y")) { // N = Y 
		throw new SkipException("Run mode of test case is set to N");
		}
	}
	
	@Test (dataProvider = "data_Collection")
	public void loginToMyStore2(Hashtable<String, String> htdata) throws Exception {
		
		//test = report.startTest("loginToMyStore2");
		
		//System.out.println("User Navigated to:-" + driver.getTitle());
		test.log(LogStatus.PASS, "User Navigated to the URL :- "  + driver.getTitle());
		
		//Assert.assertEquals(driver.getTitle(), excel.getCellData("Test_Data", "Page_Title", 2));
		Assert.assertEquals(driver.getTitle(), htdata.get("Page_Title"));
		//System.out.println("Page title has been verified");
		test.log(LogStatus.PASS, "Page title has been verified");
		takeScreenShot();
		
		driver.findElement(By.xpath(or.getProperty("Sign_In"))).click();
		//System.out.println();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User clicked on Sign In button");
		takeScreenShot();
		
		String pageText = driver.findElement(By.xpath(or.getProperty("CreateAnAccntText"))).getText();
		//Assert.assertEquals(pageText, excel.getCellData("Test_Data", "Page_Text", 2));
		Assert.assertEquals(pageText, htdata.get("Page_Text"));
		//System.out.println("Create an account text has been verified");
		test.log(LogStatus.PASS, "Create an account text has been verified");
		takeScreenShot();
		
//		driver.findElement(By.xpath(or.getProperty("Email_ID"))).sendKeys(excel.getCellData("Test_Data", "Email_ID", 2));
		driver.findElement(By.xpath(or.getProperty("Email_ID"))).sendKeys(htdata.get("Email_ID"));
		//System.out.println("User entered email Address");
		Thread.sleep(2000);;
		test.log(LogStatus.PASS, "User entered email Address");
		takeScreenShot();
		
		driver.findElement(By.xpath(or.getProperty("Submit_btn"))).click();
		//System.out.println("User clicked on Submit button");
		test.log(LogStatus.PASS, "User clicked on Submit button");
		takeScreenShot();
	}


}
