package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

public class InquarySubjectDataListObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<InquarySubjectData> subjects ;

	public List<InquarySubjectData> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<InquarySubjectData> subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public InquarySubjectDataListObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InquarySubjectDataListObject(List<InquarySubjectData> subjects) {
		super();
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "InquarySubjectDataListObject [subjects=" + subjects + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjects == null) ? 0 : subjects.hashCode());
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
		InquarySubjectDataListObject other = (InquarySubjectDataListObject) obj;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	} 
	
	

}
