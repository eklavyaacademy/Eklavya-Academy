package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
@JsonSerialize(include = Inclusion.NON_NULL)

public class BatchStudentDataListObject implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	List<BatchStudentData> students;

	public List<BatchStudentData> getStudents() {
		return students;
	}

	public void setStudents(List<BatchStudentData> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BatchStudentDataListObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatchStudentDataListObject(List<BatchStudentData> students) {
		super();
		this.students = students;
	}

	@Override
	public String toString() {
		return "BatchStudentDataListObject [students=" + students + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((students == null) ? 0 : students.hashCode());
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
		BatchStudentDataListObject other = (BatchStudentDataListObject) obj;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	
	
	
	
}
