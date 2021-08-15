package methodOverriding;

public class SBI_BANK extends RBI_BANK {
	
	public double getRateOfInterest() {
		
		System.out.println("I am in SBI Bank");
		
		return 8.5; 
		
	}

}
