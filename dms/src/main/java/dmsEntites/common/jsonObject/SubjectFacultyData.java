package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class SubjectFacultyData implements Serializable {

	// Properties ====================================================
	private static final long serialVersionUID = 1L;
	private String facultyName;
	private long facultyId;

	// Getter & Setter ==============================================
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructors
	// =============================================================
	public SubjectFacultyData(String facultyName, long facultyId) {
		super();
		this.facultyName = facultyName;
		this.facultyId = facultyId;
	}

	public SubjectFacultyData() {
		super();
	}

	// Override =============================================================
	@Override
	public String toString() {
		return "FacultyObject [facultyName=" + facultyName + ", facultyId="
				+ facultyId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (facultyId ^ (facultyId >>> 32));
		result = prime * result
				+ ((facultyName == null) ? 0 : facultyName.hashCode());
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
		SubjectFacultyData other = (SubjectFacultyData) obj;
		if (facultyId != other.facultyId)
			return false;
		if (facultyName == null) {
			if (other.facultyName != null)
				return false;
		} else if (!facultyName.equals(other.facultyName))
			return false;
		return true;
	}

	// Supportive methods ================================================
	public void updateAll(SubjectFacultyData input) {
		this.facultyName = input.getFacultyName();
		this.facultyId = input.getFacultyId();

	}

}
