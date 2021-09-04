package co.in.bymat.projectName.ModuleName.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;
import co.in.bymat.projectName.ModuleName.utility.CommonMethods;

public class LoginToMyStore7 extends TestBase_B9{
	
	@BeforeClass
	public void testCaseName() {
		
	testCaseName = this.getClass().getSimpleName();
		
	}
	
	@Test (dataProvider = "data_Collection")
	public void loginToMyStore7(Hashtable<String, String> htdata) throws Exception {
		
		Assert.assertEquals(CommonMethods.getPageTitle(), htdata.get("Page_Title")); // Verification
		test.log(LogStatus.PASS, "Page title has been verified");
		
		CommonMethods.clickOnWebElement("Sign_In", "Sign In Button"); // Step

		Assert.assertEquals(CommonMethods.getText("CreateAnAccntText"), htdata.get("Page_Text")); // Verification
		test.log(LogStatus.PASS, "Create an account text has been verified");
		takeScreenShot();
		
		CommonMethods.enterTextIntoTextBox("Email_ID", htdata.get("Email_ID"), "Email address"); // Step

		CommonMethods.clickOnWebElement("Submit_btn", "Submit Button"); // Step	
		
	}
	
}
