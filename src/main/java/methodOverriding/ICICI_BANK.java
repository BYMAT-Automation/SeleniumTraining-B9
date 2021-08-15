package methodOverriding;

public class ICICI_BANK extends RBI_BANK {

	public double getRateOfInterest() {

		System.out.println("I am in ICICI Bank");

		return 8.9;

	}

	public double getRateOfInterest(int a) {

		System.out.println("I am in ICICI Bank");

		return a;

	}

	public String getRateOfInterest(String name) {

		System.out.println("I am in RBI Bank");

		return name;

	}

}
