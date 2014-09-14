package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class EmailIdJObject implements Serializable {

	// Properties ====================================================
	private static final long serialVersionUID = 1L;
	private String primaryEmailId;
	private String secondaryEmailId;

	// Getter & Setter ==============================================
	public String getPrimaryEmailId() {
		return primaryEmailId;
	}

	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	public String getSecondaryEmailId() {
		return secondaryEmailId;
	}

	public void setSecondaryEmailId(String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Override =============================================================
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((primaryEmailId == null) ? 0 : primaryEmailId.hashCode());
		result = prime
				* result
				+ ((secondaryEmailId == null) ? 0 : secondaryEmailId.hashCode());
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
		EmailIdJObject other = (EmailIdJObject) obj;
		if (primaryEmailId == null) {
			if (other.primaryEmailId != null)
				return false;
		} else if (!primaryEmailId.equals(other.primaryEmailId))
			return false;
		if (secondaryEmailId == null) {
			if (other.secondaryEmailId != null)
				return false;
		} else if (!secondaryEmailId.equals(other.secondaryEmailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "emailIdObject [primaryEmailId=" + primaryEmailId
				+ ", secondaryEmailId=" + secondaryEmailId + "]";
	}

	// Constructors
	// =============================================================
	public EmailIdJObject(String primaryEmailId, String secondaryEmailId) {
		super();
		this.primaryEmailId = primaryEmailId;
		this.secondaryEmailId = secondaryEmailId;
	}

	public EmailIdJObject() {
		super();
	}

	// Supportive methods ================================================
	public void updateAll(EmailIdJObject input) {
		this.primaryEmailId = input.getPrimaryEmailId();
		this.secondaryEmailId = input.getSecondaryEmailId();
	}

	public void updatePrimaryEmailId(EmailIdJObject input) {
		this.primaryEmailId = input.getPrimaryEmailId();
	}

	public void updateSecondaryEmailId(EmailIdJObject input) {
		this.secondaryEmailId = input.getSecondaryEmailId();
	}
}
