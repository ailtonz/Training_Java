package application;

import java.util.Locale;

import entities.Student;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Student student = new Student();

		student.name = "Alex Green";
		student.grade1 = 27.00;
		student.grade2 = 31.00;
		student.grade3 = 32.00;

		System.out.println(student.name);
		student.exit();

		System.out.println();
		System.out.println("---");
		
		student.name = "Alex Black";
		student.grade1 = 17.00;
		student.grade2 = 20.00;
		student.grade3 = 15.00;

		System.out.println();
		System.out.println(student.name);
		student.exit();

	}

}
