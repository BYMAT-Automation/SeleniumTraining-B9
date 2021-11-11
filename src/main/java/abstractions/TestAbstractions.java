package abstractions;

public class TestAbstractions {

	public static void main(String args[]){    
		Bank b;  
		b=new SBI_BANK();  
		System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
		b=new ICICI_BANK();  
		System.out.println("Rate of Interest is: "+b.getRateOfInterest()+" %");    
		}
	}   
