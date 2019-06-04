package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	Arrays arrays = new Arrays();
	List<Apply> applies = new ArrayList<>();

	public void generateMenu() {

		int c1 = 0;
		do {
			System.out.println("GLAVNI MENI:" + "\n");
			System.out.println("1. PREGLED");
			System.out.println("2. UNOS NOVE PRIJAVE");
			System.out.println("3. IZMENA");
			System.out.println("4. KRAJ PROGRAMA" + "\n");
			System.out.println("Izaberite opciju:" + "\n");
			try {
				Scanner sc1 = new Scanner(System.in);

				switch (sc1.nextInt()) {

				case 1:
					subMenu1(null);
					break;

				case 2:
					applyInput();
					break;

				case 3:
					subMenu2(null);
					break;

				case 4:
					System.out.println("KRAJ PROGRAMA!");
					return;

				default:
					System.out.println("Niste uneli odgovarajucu opciju!");
					break;
				}
			} catch (InputMismatchException ime) {
				System.out.println("Niste uneli odgovarajucu opciju!");
				continue;
			}

		} while (c1 != 4);
	}

	void subMenu1(String c2) {
		do {
			System.out.println("a. Pregled svih predmeta");
			System.out.println("b. Pregled svih studenata");
			System.out.println("c. Pregled svih prijava za trazenog studenta");
			System.out.println("d. Prikaz svih studenata koji su polozili odredjeni predmet");
			System.out.println("e. Povratak u GLAVNI MENI" + "\n");
			System.out.println("Izaberite opciju:");

			Scanner sc2 = new Scanner(System.in);

			switch (sc2.next()) {

			case "a":
				arrays.subjectReview();
				break;
			case "b":
				arrays.studentReview();
				break;
			case "c":
				applyReview();
				break;
			case "d":
				examReview();
				break;
			case "e":
				System.out.println("Povratak u GLAVNI MENI");
				return;
			default:
				System.out.println("Niste uneli odgovarajucu opciju!");
				break;
			}

		} while (!"e".equals(c2));

	}

	void subMenu2(String c3) {
		do {
			System.out.println("a. Izmena podataka o studentu");
			System.out.println("b. Povratak u GLAVNI MENI");

			Scanner sc3 = new Scanner(System.in);

			switch (sc3.next()) {

			case "a":
				studentChange();
				break;

			case "b":
				System.out.println("Povratak u GLAVNI MENI");
				return;

			default:
				System.out.println("Niste uneli odgovarajucu opciju!");
				break;
			}

		} while (!"b".equals(c3));
	}

	public void printApply(Apply a) {
		System.out.print(a);
	}

	public void applyReview() {
		if (!applies.isEmpty()) {
			boolean found = false;

			do {
				String index;
				System.out.println("Unesite broj indeksa:");
				Scanner sc = new Scanner(System.in);
				index = sc.next();
				int i = 0;
				for (Apply current : applies) {
					if (index.equals(current.getIndexNo())) {
						printApply(current);
						i++;
						found = true;
					}
				}
				if (i == 0) {
					System.out.println("Ne postoji student sa navedenim brojem indeksa! Unesite ispravan broj!");
				}

			} while (!found);
		} else {
			System.out.println("Jos uvek nema evidencije o prijavama! Prvo unesite prijavu." + "\n");
		}
	}

	public void examReview() {
		if (!applies.isEmpty()) {
			boolean found = false;

			do {
				int id;
				System.out.println("Unesite sifru ispita:");
				Scanner sc = new Scanner(System.in);
				id = sc.nextInt();
				int i = 0;
				for (Apply current : applies) {
					if (id == current.getSubjectId() && current.getGrade() > 5) {
						printApply(current);
						i++;
						found = true;
					}
				}
				if (i == 0) {
					System.out.println("Ne postoji predmet sa navedenom sifrom! Unesite ispravnu sifru!");
				}
			} while (!found);
		} else {
			System.out.println("Jos uvek nema evidencije o prijavama! Prvo unesite prijavu." + "\n");
		}
	}

	private void applyInput() {
		boolean passed = false;
		boolean containId = false;
		boolean containIndex = false;
		int id;
		String index;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Unesite sifru predmeta:");
			id = sc.nextInt();
			for (int i = 0; i < arrays.students.length; i++) {
				if ((id == (arrays.subjects[i].getSubjectId()))) {
					containId = true;
				}
			}
			if (!containId) {
				System.out.println("Ne postoji predmet sa unetom sifrom!" + "\n");
			}

		} while (!containId);

		do {
			System.out.println("Unesite broj indeksa:");
			index = sc.next();
			for (int i = 0; i < arrays.students.length; i++) {
				if ((index.equals(arrays.students[i].getIndexNo()))) {
					containIndex = true;
				}
			}
			if (!containIndex) {
				System.out.println("Ne postoji student sa unetim brojem indeksa!" + "\n");

			}
		} while (!containIndex);

		System.out.println("Unesite datum polaganja ispita (u formatu gggg-MM-dd):");
		String date = sc.next();

		for (Apply current : applies) {
			if ((index.equals(current.getIndexNo())) && (id == (current.getSubjectId())) && current.getGrade() > 5) {
				passed = true;
				System.out.println("Prijava za datog studenta je vec uneta!");
				break;
			}
		}
		if (passed == false) {
			System.out.println("Unesite ocenu od 5 do 10:");
			int grade = sc.nextInt();
			if ((grade >= 5) && (grade <= 10)) {
				Apply apply = new Apply(id, index, date, grade);
				applies.add(apply);
				System.out.println("Uspesno ste prijavili ispit!");

			} else {

				System.out.println("Niste uneli odgovarajucu ocenu! Unesite prijavu ponovo.");

			}

		}

	}

	private void studentChange() {
		Scanner sc = new Scanner(System.in);
		String change;
		int year;
		int counter = 0;
		System.out.println("Unesite broj indeksa:");
		change = sc.next();
		
		for (int i = 0; i < arrays.students.length; i++) {

			if (change.equals(arrays.students[i].getIndexNo())) {

				System.out.println("Unesite ime:");
				change = sc.next();
				arrays.students[i].setFirstName(change);

				System.out.println("Unesite prezime:");
				change = sc.next();
				arrays.students[i].setLastName(change);

				System.out.println("Unesite godinu upisa:");
				year = sc.nextInt();
				arrays.students[i].setYearReg(year);

				System.out.println("Unesite datum rodjenja (u formatu gggg-MM-dd):");
				change = sc.next();
				LocalDate ld;
				try {
					ld = LocalDate.parse(change, DateTimeFormatter.ISO_LOCAL_DATE);
					arrays.students[i].setDate(ld);
				} catch (DateTimeParseException dtpe) {
					System.out.println("Pogresan unos datuma! Pokusajte ponovo");
					return;
				}

				System.out.println("Uspesno ste izmenili podatke!" + "\n");
				System.out.println("Novi podaci o studentu sa unetim brojem indeksa su:" + "\n");
				System.out.println(arrays.students[i].toString());
				counter++;
			}

		}
		if (counter == 0) {
			System.out.println("Ne postoji student sa unetim brojem indeksa!");
		}

	}

}
