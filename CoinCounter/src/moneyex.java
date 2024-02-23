
import java.util.Scanner;
import java.text.DecimalFormat;


public class moneyex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.printf("Input x1: $ ");
		double x1 = s.nextDouble();
		s.nextLine();
		
		System.out.printf("Input x2: $ ");
		double x2 = s.nextDouble();
		
		System.out.printf("Input x3: $ ");
		double x3 = s.nextDouble();
		
		double sum = x1 + x2 + x3;
		double mean = sum/3.0;
		
		DecimalFormat dF = new DecimalFormat("0.0#");
		System.out.println("Sum of numbers = $ " + sum);
		System.out.println("Mean of numbers = $ " + dF.format(mean));
	}

}
