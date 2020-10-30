package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Rectangle rectangle = new Rectangle();

		System.out.println("Enter rectangle width and height: ");
	
		System.out.println();
		rectangle.width = 3.0; //sc.nextDouble();
		System.out.println(rectangle.width);
		
		System.out.println();
		rectangle.height = 4.0; //sc.nextDouble();
		System.out.println(rectangle.height);
		
		System.out.printf("AREA = %.2f%n", rectangle.area());
		System.out.printf("PERIMETER = %.2f%n", rectangle.perimeter());
		System.out.printf("DIAGONAL = %.2f%n", rectangle.diagonal());
		
		sc.close();
		
		
	}

}
