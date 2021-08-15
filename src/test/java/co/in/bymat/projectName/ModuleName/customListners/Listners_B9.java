package co.in.bymat.projectName.ModuleName.customListners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;

public class Listners_B9 extends TestBase_B9 implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		try {
			launchBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		
		try {
			takeScreenShot();
			test.log(LogStatus.PASS, "Execution for Test case "+testCaseName+" is Passed");	
			closeBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		try {
			test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			takeScreenShot_Fail();
			test.log(LogStatus.FAIL, "Execution for Test case "+testCaseName+" has been failed");
			closeBrowser();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
