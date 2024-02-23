import java.util.Scanner;

	class Counter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the number of coins:");
		
		System.out.printf("# of quarters: ");
		int q = s.nextInt(); 
		s.nextLine();
		
		System.out.printf("# of dimes: ");
		int d = s.nextInt(); 
		
		System.out.printf("# of nickels: ");
		int n = s.nextInt(); 
		
		System.out.printf("# of pennies: ");
		int p = s.nextInt(); 
		
		
		int total = 25*(q) + 10*d + 5*n + 1*p;
		int dollar = total/100;
		int cent = total % 100;
		
		System.out.printf("the total is " + dollar + " dollars and " + cent + " cents");
		
	}

}
