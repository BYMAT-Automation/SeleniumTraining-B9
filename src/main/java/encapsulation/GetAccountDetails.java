package encapsulation;

public class GetAccountDetails {
	
	public static int Account_no;
	
	public GetAccountDetails(int Account_No) {
		System.out.println("I am in Constructor");
		Account_no = Account_No;
	}
	
	public static double getAccountBalance() {
		System.out.println("Code to get getAccountBalance for Account_no:- " +Account_no);
		return 434234.45;
	}

}
