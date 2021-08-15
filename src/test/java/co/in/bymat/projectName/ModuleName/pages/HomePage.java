package co.in.bymat.projectName.ModuleName.pages;

import java.util.Hashtable;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;
import co.in.bymat.projectName.ModuleName.utility.CommonMethods;

public class HomePage extends TestBase_B9 {

	public static void createAnAccount(Hashtable<String, String> htdata) throws Exception {
		
		Assert.assertEquals(CommonMethods.getPageTitle(), htdata.get("Page_Title")); // Verification
		test.log(LogStatus.PASS, "Page title has been verified");
			
		CommonMethods.clickOnWebElement("Sign_In", "Sign In Button"); // Step

		Assert.assertEquals(CommonMethods.getText("CreateAnAccntText"), htdata.get("Page_Text")); // Verification
		test.log(LogStatus.PASS, "Create an account text has been verified");
		takeScreenShot();	
		
		CommonMethods.enterTextIntoTextBox("Email_ID", htdata.get("Email_ID"), "Email address"); // Step

		CommonMethods.clickOnWebElement("Submit_btn", "Submit Button"); // Step	
		
	}

	public void alreadyRegistered() {

	}

}
