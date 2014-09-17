package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class InquarySubjectData implements Serializable {

	private static final long serialVersionUID = 1L;

	// Properties ====================================================
	private long subjectId;
	private String subjectName;

	// Getter & Setter ==============================================
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	// Constructors ===========================================================
	public InquarySubjectData() {

	}

	public InquarySubjectData(long subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	// override methods
	// ================================================================
	@Override
	public String toString() {
		return "InquarySubjectJSONObject [subjectId=" + subjectId
				+ ", subjectName=" + subjectName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		InquarySubjectData other = (InquarySubjectData) obj;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}

	// Supportive methods ================================================
	public void updateAll(InquarySubjectData input) {
		this.subjectId = input.getSubjectId();
		this.subjectName = input.getSubjectName();
	}

}
