package interface_test;

public class TestInterface {

	static WebDriver_B9 driver, driver1, driver2;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		// ChromeDriver driver = new ChromeDriver();

		driver.get_b9();
		driver.getTitle_b9();
		driver.close_b9();
		driver.quite_b9();
		driver.takeScreenShot_b9();
		driver.click_b9();

		System.out.println("**********************************");

		driver1 = new FireFoxDriver();

		driver1.get_b9();
		driver1.getTitle_b9();
		driver1.close_b9();
		driver1.quite_b9();
		driver1.takeScreenShot_b9();

		System.out.println("**********************************");

		driver2 = new IEDriver();

		driver2.get_b9();
		driver2.getTitle_b9();
		driver2.close_b9();
		driver2.quite_b9();
		driver2.takeScreenShot_b9();

	}
}
