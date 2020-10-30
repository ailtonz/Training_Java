package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {

	public static void main(String[] args) {

		/**
		 * 
		 * Resolvendo um problema com orientação a Objeto.
		 * 
		 * */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangle x,y; 

		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Enter the measures of triangle X: ");
		x.a = 3.00; //sc.nextDouble();
		x.b = 4.00; //sc.nextDouble();
		x.c = 5.00; //sc.nextDouble();
		double areaX = x.area();

		System.out.println("Enter the measures of triangle Y: ");
		y.a = 7.50; //sc.nextDouble();
		y.b = 4.50; //sc.nextDouble();
		y.c = 4.02; // sc.nextDouble();
		double areaY = y.area();

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
