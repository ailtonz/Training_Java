package entities;

public class Student {

	public String name;
	public double grade1;
	public double grade2;
	public double grade3;

	public double finalGrade() {
		return this.grade1 + this.grade2 + this.grade3;
	}

	public double missingPoints() {
		if (finalGrade() < 60.0) {
			return 60.0 - finalGrade();
		} else {
			return 0.0;
		}
	}

	public void exit() {

		if (finalGrade() < 60.0) {
			System.out.printf("FINAL GRADE: %.2f%s ", finalGrade(), " FAILED");
			System.out.println();
			System.out.printf("MISSING %.2f POINTS%n", missingPoints());
			System.out.println();

		} else {
			System.out.printf("FINAL GRADE: %.2f%s", finalGrade(), " PASS");
			System.out.println();
		}
	}

}
