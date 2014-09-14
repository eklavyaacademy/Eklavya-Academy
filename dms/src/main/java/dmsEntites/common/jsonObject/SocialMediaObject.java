package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class SocialMediaObject implements Serializable {

	// Properties ====================================================
	private static final long serialVersionUID = 1L;
	private String linkedInId;
	private String facebookId;
	private String whatsAppNumber;
	private String hikeNumber;

	// Getter & Setter ==============================================
	public String getLinkedInId() {
		return linkedInId;
	}

	public void setLinkedInId(String linkedInId) {
		this.linkedInId = linkedInId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getWhatsAppNumber() {
		return whatsAppNumber;
	}

	public void setWhatsAppNumber(String whatsAppNumber) {
		this.whatsAppNumber = whatsAppNumber;
	}

	public String getHikeNumber() {
		return hikeNumber;
	}

	public void setHikeNumber(String hikeNumber) {
		this.hikeNumber = hikeNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Override =============================================================
	@Override
	public String toString() {
		return "SocialMediaObject [linkedInId=" + linkedInId + ", facebookId="
				+ facebookId + ", whatsAppNumber=" + whatsAppNumber
				+ ", hikeNumber=" + hikeNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((facebookId == null) ? 0 : facebookId.hashCode());
		result = prime * result
				+ ((hikeNumber == null) ? 0 : hikeNumber.hashCode());
		result = prime * result
				+ ((linkedInId == null) ? 0 : linkedInId.hashCode());
		result = prime * result
				+ ((whatsAppNumber == null) ? 0 : whatsAppNumber.hashCode());
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
		SocialMediaObject other = (SocialMediaObject) obj;
		if (facebookId == null) {
			if (other.facebookId != null)
				return false;
		} else if (!facebookId.equals(other.facebookId))
			return false;
		if (hikeNumber == null) {
			if (other.hikeNumber != null)
				return false;
		} else if (!hikeNumber.equals(other.hikeNumber))
			return false;
		if (linkedInId == null) {
			if (other.linkedInId != null)
				return false;
		} else if (!linkedInId.equals(other.linkedInId))
			return false;
		if (whatsAppNumber == null) {
			if (other.whatsAppNumber != null)
				return false;
		} else if (!whatsAppNumber.equals(other.whatsAppNumber))
			return false;
		return true;
	}

	// Constructors
	// =============================================================
	public SocialMediaObject(String linkedInId, String facebookId,
			String whatsAppNumber, String hikeNumber) {
		super();
		this.linkedInId = linkedInId;
		this.facebookId = facebookId;
		this.whatsAppNumber = whatsAppNumber;
		this.hikeNumber = hikeNumber;
	}

	public SocialMediaObject() {
		super();
	}

	// Supportive methods ================================================
	public void updateAll(SocialMediaObject input) {
		this.linkedInId = input.getLinkedInId();
		this.facebookId = input.getFacebookId();
		this.whatsAppNumber = input.getWhatsAppNumber();
		this.hikeNumber = input.getHikeNumber();

	}

	public void updateLinkedInId(SocialMediaObject input) {
		this.linkedInId = input.getLinkedInId();
	}

	public void updateFacebookId(SocialMediaObject input) {
		this.facebookId = input.getFacebookId();
	}

	public void updateWhatsAppNumber(SocialMediaObject input) {
		this.whatsAppNumber = input.getWhatsAppNumber();
	}

	public void updateHikeNumber(SocialMediaObject input) {
		this.hikeNumber = input.getHikeNumber();
	}

}
