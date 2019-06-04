package homework;

public class Apply {

	private int subjectId;
	private String indexNo;
	private String examDate;
	private int grade;

	public Apply(int subjectId, String indexNo, String examDate, int grade) {
		this.subjectId = subjectId;
		this.indexNo = indexNo;
		this.examDate = examDate;
		this.grade = grade;
	}

	public Apply(Apply a) {
		this(a.subjectId, a.indexNo, a.examDate, a.grade);
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Prijava ispita za predmet sa sifrom: " + getSubjectId() + "\t" + "Broj indeksa studenta: "
				+ getIndexNo() + "\t" + "Datum polaganja ispita: " + getExamDate() + "\t" + "Ocena na ispitu: "
				+ getGrade() + "\n";
	}

}
