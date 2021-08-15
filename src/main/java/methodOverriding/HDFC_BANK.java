package methodOverriding;

public class HDFC_BANK extends RBI_BANK {
	
	public double getRateOfInterest() {
		
		System.out.println("I am in HDFC Bank");
		
		return 9.2; 
		
	}

}
