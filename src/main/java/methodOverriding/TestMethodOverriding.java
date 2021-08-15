package methodOverriding;

public class TestMethodOverriding {

	public static void main(String[] args) {

		RBI_BANK icici = new ICICI_BANK();

		System.out.println(icici.getRateOfInterest());
		
		ICICI_BANK icici1 = new ICICI_BANK();
		System.out.println(icici1.getRateOfInterest(20));

		RBI_BANK hdfc = new HDFC_BANK();

		System.out.println(hdfc.getRateOfInterest());
		

		RBI_BANK sbi = new SBI_BANK();

		System.out.println(sbi.getRateOfInterest());

	}

	// Need to have Inheritance relation
	// Child class should have same method with same data type same agr with same data type(of method)
	// Create a object of child class and assign to the reference variable of Parent class
	
	
}
