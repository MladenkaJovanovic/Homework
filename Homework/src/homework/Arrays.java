package homework;

import java.time.LocalDate;

public class Arrays {

	Student st1 = new Student("10", 2018, "Anka", "Antic", LocalDate.of(1998, 01, 01));
	Student st2 = new Student("20", 2017, "Pera", "Peric", LocalDate.of(1997, 02, 02));
	Student st3 = new Student("30", 2017, "Jova", "Jovic", LocalDate.of(1997, 03, 03));
	Student st4 = new Student("40", 2016, "Sima", "Simic", LocalDate.of(1996, 04, 04));
	Student st5 = new Student("50", 2016, "Maja", "Maric", LocalDate.of(1996, 05, 05));
	Student[] students = { st1, st2, st3, st4, st5 };

	Subject su1 = new Subject(1, "Osnove programiranja");
	Subject su2 = new Subject(2, "Internet tehnologije");
	Subject su3 = new Subject(3, "Baze podataka");
	Subject su4 = new Subject(4, "Matematika");
	Subject su5 = new Subject(5, "Projektovanje softvera");
	Subject[] subjects = { su1, su2, su3, su4, su5 };

	public void studentReview() {
		System.out.println("Pregled svih studenata:" + "\n");
		for (int i = 1; i < students.length + 1; i++) {
			System.out.println(i + ". " + students[i - 1]);
		}
	}

	public void subjectReview() {
		System.out.println("Pregled svih predmeta:" + "\n");
		for (int i = 1; i < subjects.length + 1; i++) {
			System.out.println(i + ". " + subjects[i - 1]);
		}
	}

}
