package co.in.bymat.projectName.ModuleName.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.pages.HomePage;
import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;
import co.in.bymat.projectName.ModuleName.utility.CommonMethods;

public class LoginToMyStore5 extends TestBase_B9 {

	@BeforeClass
	public void testCaseName() {

		testCaseName = this.getClass().getSimpleName();

	}

	@Test(dataProvider = "data_Collection")
	public void loginToMyStore5(Hashtable<String, String> htdata) throws Exception {

		HomePage.createAnAccount(htdata);

	}

}