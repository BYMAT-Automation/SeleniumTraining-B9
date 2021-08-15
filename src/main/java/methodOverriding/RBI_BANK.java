package methodOverriding;

public class RBI_BANK {
	
	public double getRateOfInterest() {
		
		System.out.println("I am in RBI Bank");
		
		return 8.2; 
		
	}
	
	
	public String getRateOfInterest(String name) {
		
		System.out.println("I am in RBI Bank");
		
		return name; 
		
	}

}
