package encapsulation;

public class TestConstructor {
	
	public static void main(String[] args) {
	
	GetAccountDetails gad = new GetAccountDetails(123456789);
	System.out.println(gad.getAccountBalance());
		
	}

}
