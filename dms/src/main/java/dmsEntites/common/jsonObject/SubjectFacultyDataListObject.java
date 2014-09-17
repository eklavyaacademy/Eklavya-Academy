package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSerialize(include = Inclusion.NON_NULL)
public class SubjectFacultyDataListObject implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	private List<SubjectFacultyData> faculty;


	public List<SubjectFacultyData> getFaculty() {
		return faculty;
	}


	public void setFaculty(List<SubjectFacultyData> faculty) {
		this.faculty = faculty;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public SubjectFacultyDataListObject() {
		super();
	}


	public SubjectFacultyDataListObject(List<SubjectFacultyData> faculty) {
		super();
		this.faculty = faculty;
	}


	@Override
	public String toString() {
		return "SubjectFacultyDataListObject [faculty=" + faculty + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
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
		SubjectFacultyDataListObject other = (SubjectFacultyDataListObject) obj;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		return true;
	}
	
	
	
	
}
