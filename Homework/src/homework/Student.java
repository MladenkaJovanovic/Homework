package homework;

import java.time.LocalDate;

public class Student {
	private String indexNo;
	private int yearReg;
	private String firstName;
	private String lastName;
	private LocalDate date;

	public Student(String indexNo, int yearReg, String firstName, String lastName, LocalDate date) {
		this.indexNo = indexNo;
		this.yearReg = yearReg;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public int getYearReg() {
		return yearReg;
	}

	public void setYearReg(int yearReg) {
		this.yearReg = yearReg;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Broj indeksa: " + indexNo + "\t" + "Godina upisa: " + yearReg + "\t" + "Ime: " + firstName + "\t"
				+ "Prezime: " + lastName + "\t" + "Datum Rodjenja: " + date + " \n";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return indexNo.equals(student.getIndexNo());
		}
		return false;
	}

}
