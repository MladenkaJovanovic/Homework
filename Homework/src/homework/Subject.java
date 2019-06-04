package homework;

public class Subject {
	private int subjectId;
	private String subjectName;

	public Subject(int subjectId, String subjectName) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Predmet ID: " + subjectId + " \t" + "Naziv: " + subjectName + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Subject) {
			Subject subject = (Subject) obj;
			return (subjectName.equals(subject.getSubjectName()) && subjectId == subject.getSubjectId());
		}
		return false;
	}

}
