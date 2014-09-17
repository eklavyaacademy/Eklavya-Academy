package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class BatchStudentData implements Serializable{

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

	public BatchStudentData(long studentId, long feePaid) {
		super();
		this.studentId = studentId;
		this.feePaid = feePaid;
	}

	public BatchStudentData() {
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
		BatchStudentData other = (BatchStudentData) obj;
		if (feePaid != other.feePaid)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	
	
	

}
