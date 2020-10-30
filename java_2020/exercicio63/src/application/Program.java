package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		/**
		 * 
		 * Resolvendo um problema sem orientação a Objeto.
		 * 
		 * */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double xA, xB, xC, yA, yB, yC;

		System.out.println("Enter the measures of triangle X: ");
		xA = 3.00; //sc.nextDouble();
		xB = 4.00; //sc.nextDouble();
		xC = 5.00; //sc.nextDouble();

		System.out.println("Enter the measures of triangle Y: ");
		yA = 7.50; //sc.nextDouble();
		yB = 4.50; //sc.nextDouble();
		yC = 4.02; // sc.nextDouble();

		double p = (xA + xB + xC) / 2.0;
		double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

		p = (yA + yB + yC) / 2.0;
		double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

		System.out.printf("Triangle X area: %.4f%n", areaX);
		System.out.printf("Triangle Y area: %.4f%n", areaY);

		if (areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}

		sc.close();
	}

}
