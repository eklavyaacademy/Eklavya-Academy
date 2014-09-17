package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
@JsonSerialize(include = Inclusion.NON_NULL)
public class StudentSubjectListObject implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private List<StudentSubjectData> studentSubjects = new ArrayList<StudentSubjectData>();

	
	
	public List<StudentSubjectData> getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubjectData> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StudentSubjectObject [studentSubjects=" + studentSubjects + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((studentSubjects == null) ? 0 : studentSubjects.hashCode());
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
		StudentSubjectListObject other = (StudentSubjectListObject) obj;
		if (studentSubjects == null) {
			if (other.studentSubjects != null)
				return false;
		} else if (!studentSubjects.equals(other.studentSubjects))
			return false;
		return true;
	}

	public StudentSubjectListObject() {
		super();
	}

	public StudentSubjectListObject(List<StudentSubjectData> studentSubjects) {
		super();
		this.studentSubjects = studentSubjects;
	}
	
	
}
