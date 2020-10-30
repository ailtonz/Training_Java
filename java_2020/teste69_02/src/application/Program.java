package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Employee employee = new Employee();
		
		System.out.print("Name: ");
		System.out.println();
		employee.name = "Joao Silva"; //sc.nextLine();
		System.out.println(employee.name);
		
		System.out.print("Gross salary: ");
		System.out.println();
		employee.grossSalary = 6000.00; //sc.nextDouble();
		System.out.println(employee.grossSalary);
		
		System.out.print("Tax: ");
		System.out.println();
		employee.tax = 1000.00; //sc.nextDouble();
		System.out.println(employee.tax);		
		
		System.out.println();
		System.out.println("Employee: " + employee);
		System.out.println();
		System.out.println("Which percentage to increase salary? ");
		double percentage = 10.0; //sc.nextDouble();
		System.out.println(percentage);	
		
		employee.increaseSalary(percentage);
		
		System.out.println();
		System.out.println("Update data: " + employee);		
		
		sc.close();
		
		
	}

}
