package polymorphism;

public class MethodOverloading {
	
	
	public static void main(String[] args) { // Static binding //
		
		addition();
		
		addition("Selenium", 10);
		
		System.out.println("This methos is returning me addition of two numbver:-" +addition(5, 7));
		
		addition(1, 4, 24);
		
	}
	
	
	public static void addition() {

		System.out.println("I am in Addition method");
	
	}

	public static void addition(int a) {

		System.out.println("I am in Addition method- printing:-" + a);

	}
	
	public static void addition(int a, int b, int c) {

		System.out.println("I am in Addition method- printing:-" + a);

	}

	public static void addition(String a, int b) {

		System.out.println("I am in Addition method- printing:-" +a+ b);

	}

	public static int addition(int a, int b) {

		int c = a+b;
		System.out.println("I am in Addition method- printing:-" + c);
	
		return c;

	}

	public static String addition(String a, String b) {

		System.out.println("I am in printing:-" + b + a);
		return b;

	}

	// We can have same method name with same agruments but with different data type
	
}
