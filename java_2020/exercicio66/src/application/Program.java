package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product product = new Product();

		System.out.println("Enter product data: ");
		
		System.out.print("Name: ");
		System.out.println();
		product.name = "tv".toUpperCase(); //sc.nextLine().toString().toUpperCase();
		System.out.println(product.name);
		
		System.out.println();
		System.out.println("Price: ");
		
		product.price = 900; //sc.nextDouble();
		System.out.println(product.price);
		
		System.out.println();
		System.out.println("Quantity in sotck: ");
		product.quantity = 10; //sc.nextInt();
		System.out.println(product.quantity);
		
		System.out.println();
		System.out.println("Product data: " + product.toString());
		
		System.out.println();
		System.out.println("Enter the number of products to be added in stock: ");
		int quantity = 5; //sc.nextInt();
		System.out.println(quantity);
		
		product.addProducts(quantity);

		System.out.println();
		System.out.println("Update data: " + product.toString());		
		
		System.out.println();
		System.out.println("Enter the number of products to be removed from stock: ");		
		quantity = 3; //sc.nextInt();
		System.out.println(quantity);
		
		product.removeProducts(quantity);
		
		System.out.println();
		System.out.println("Update data: " + product.toString());			
		
		sc.close();
		
		
	}

}
