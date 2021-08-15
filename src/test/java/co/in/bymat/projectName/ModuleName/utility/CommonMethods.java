package co.in.bymat.projectName.ModuleName.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.projectName.ModuleName.testBase.TestBase_B9;

public class CommonMethods extends TestBase_B9 {

	public static String getPageTitle() {

		return driver.getTitle();
	}

	public static void clickOnWebElement(String Xpath, String WebElementName) throws Exception {

		driver.findElement(By.xpath(or.getProperty(Xpath))).click();
		// driver.findElement(By.xpath(or.getProperty("Sign_In"))).click();
		test.log(LogStatus.PASS, "User clicked on " + WebElementName); // Sign In Button
		takeScreenShot();
	}

	public static void clickOnButton(String Xpath, String button) {

		driver.findElement(By.xpath(or.getProperty(Xpath))).click();
		test.log(LogStatus.PASS, "User clicked on " + button);
	}

	public static void enterTextIntoTextBox(String Xpath, String text, String TextBoxName) throws Exception {

		driver.findElement(By.xpath(or.getProperty(Xpath))).sendKeys(text);
		test.log(LogStatus.PASS, "User entered text in to " + TextBoxName);
		takeScreenShot();	
	}

	public static String getText(String Xpath) {

		return driver.findElement(By.xpath(or.getProperty(Xpath))).getText();

	}

	public static void clickOnRadioButton(String Xpath, String buttonName) {

		driver.findElement(By.xpath(or.getProperty(Xpath))).click();
		test.log(LogStatus.PASS, "User clicked on " + buttonName);
	}

	public static void clickOnCheckBox(String Xpath, String CheckBoxName) {

		driver.findElement(By.xpath(or.getProperty(Xpath))).click();
		test.log(LogStatus.PASS, "User clicked on checkbox " + CheckBoxName);

	}

	public static void selectByIndex(String Xpath, int IndexValue) {
		Select Sel = new Select(driver.findElement(By.xpath(or.getProperty(Xpath))));
		Sel.selectByIndex(IndexValue);
		test.log(LogStatus.PASS, "User selected the index value " + IndexValue);

	}

	public static void selectByValue(String Xpath, String value) {
		Select Sel = new Select(driver.findElement(By.xpath(or.getProperty(Xpath))));
		Sel.selectByValue(value); 
		test.log(LogStatus.PASS, "User selected the index " + value);
	}
	
	public static void selectByVisibleText (String Xpath, String VisibleText) {
		Select Sel = new Select(driver.findElement(By.xpath(or.getProperty(Xpath))));
		Sel.selectByVisibleText(VisibleText); 
		test.log(LogStatus.PASS, "User selected the index " + VisibleText);
	}
	
	
}
