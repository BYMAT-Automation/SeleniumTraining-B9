package abstractions;

public abstract class Bank {
	
	public abstract int getRateOfInterest();
	
	public void getCustomerAddress() {
		System.out.println("I am in Non Abstract method");
	}

}
