package dmsEntites.common.relatedobjects;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long studentId; //foreign key of student entity
	
	private long feePaid;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(long feePaid) {
		this.feePaid = feePaid;
	}

	public Student(long studentId, long feePaid) {
		super();
		this.studentId = studentId;
		this.feePaid = feePaid;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "FacultySubjectObject [studentId=" + studentId + ", feePaid="
				+ feePaid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (feePaid ^ (feePaid >>> 32));
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
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
		Student other = (Student) obj;
		if (feePaid != other.feePaid)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	
	
	

}
