import java.util.Scanner;

class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the amount of money to convert:");
		
		System.out.printf("# of dollars: ");
		int d = s.nextInt(); 
		s.nextLine();
		
		System.out.printf("# of cents: ");
		int c = s.nextInt(); 
		
		int total = 100*d + c;
		
		int quarter =  total/25;
		int dime = (total - (quarter*25))/10;
		int nickel = (total - (quarter*25 + dime*10))/5;
		int penny = (total - (quarter*25 + dime*10 + nickel*5));
		
		System.out.println("The coins are " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels and " + penny + " pennies");
	}

}
