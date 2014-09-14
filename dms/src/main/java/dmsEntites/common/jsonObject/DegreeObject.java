package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

public class DegreeObject implements Serializable {

	// Properties ====================================================
	private static final long serialVersionUID = 1L;
	private String degreeName;
	private String grade;
	private String university;
	private boolean ugPg = true; // false=UG and True = PG

	// Getter & Setter ==============================================
	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public boolean isUgPg() {
		return ugPg;
	}

	public void setUgPg(boolean ugPg) {
		this.ugPg = ugPg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructors
	// =============================================================
	public DegreeObject(String degreeName, String grade, String university,
			boolean ugPg) {
		super();
		this.degreeName = degreeName;
		this.grade = grade;
		this.university = university;
		this.ugPg = ugPg;
	}

	public DegreeObject() {
		super();
	}

	// Override =============================================================
	@Override
	public String toString() {
		return "DegreeObject [degreeName=" + degreeName + ", grade=" + grade
				+ ", university=" + university + ", ugPg=" + ugPg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((degreeName == null) ? 0 : degreeName.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + (ugPg ? 1231 : 1237);
		result = prime * result
				+ ((university == null) ? 0 : university.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DegreeObject other = (DegreeObject) obj;
		if (degreeName == null) {
			if (other.degreeName != null)
				return false;
		} else if (!degreeName.equals(other.degreeName))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (ugPg != other.ugPg)
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		return true;
	}

	// Supportive methods ================================================
	public void updateAll(DegreeObject input) {
		this.degreeName = input.getDegreeName();
		this.grade = input.getGrade();
		this.university = input.getUniversity();
		this.ugPg = input.isUgPg();
	}

}
