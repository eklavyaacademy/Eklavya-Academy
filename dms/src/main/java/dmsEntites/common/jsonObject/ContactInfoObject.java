package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class ContactInfoObject implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String localAddress ; 
	private String permanentAddress ; 
	private String linkedInId;
	private String facebookId;
	private String whatsAppNumber;
	private String hikeNumber;
	private String mobile1;
	private String mobile2;
	private String landline;
	private String primaryEmailId;
	private String secondaryEmailId;
	
	
	
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
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
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
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
	public ContactInfoObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactInfoObject(String localAddress, String permanentAddress,
			String linkedInId, String facebookId, String whatsAppNumber,
			String hikeNumber, String mobile1, String mobile2, String landline,
			String primaryEmailId, String secondaryEmailId) {
		super();
		this.localAddress = localAddress;
		this.permanentAddress = permanentAddress;
		this.linkedInId = linkedInId;
		this.facebookId = facebookId;
		this.whatsAppNumber = whatsAppNumber;
		this.hikeNumber = hikeNumber;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.landline = landline;
		this.primaryEmailId = primaryEmailId;
		this.secondaryEmailId = secondaryEmailId;
	}
	
	public void updateAll(ContactInfoObject input){
		this.localAddress = input.getLocalAddress();
		this.permanentAddress= input.getPermanentAddress();
		this.linkedInId = input.getLinkedInId();
		this.facebookId = input.getFacebookId();
		this.whatsAppNumber = input.getWhatsAppNumber();
		this.hikeNumber = input.getHikeNumber();
		this.mobile1 = input.getMobile1();
		this.mobile2 = input.getMobile2();
		this.landline = input.getLandline();
		this.primaryEmailId = input.getPrimaryEmailId();
		this.secondaryEmailId = input.getSecondaryEmailId();
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
				+ ((landline == null) ? 0 : landline.hashCode());
		result = prime * result
				+ ((linkedInId == null) ? 0 : linkedInId.hashCode());
		result = prime * result
				+ ((localAddress == null) ? 0 : localAddress.hashCode());
		result = prime * result + ((mobile1 == null) ? 0 : mobile1.hashCode());
		result = prime * result + ((mobile2 == null) ? 0 : mobile2.hashCode());
		result = prime
				* result
				+ ((permanentAddress == null) ? 0 : permanentAddress.hashCode());
		result = prime * result
				+ ((primaryEmailId == null) ? 0 : primaryEmailId.hashCode());
		result = prime
				* result
				+ ((secondaryEmailId == null) ? 0 : secondaryEmailId.hashCode());
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
		
		ContactInfoObject other = (ContactInfoObject) obj;
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
		if (landline == null) {
			if (other.landline != null)
				return false;
		} else if (!landline.equals(other.landline))
			return false;
		if (linkedInId == null) {
			if (other.linkedInId != null)
				return false;
		} else if (!linkedInId.equals(other.linkedInId))
			return false;
		if (localAddress == null) {
			if (other.localAddress != null)
				return false;
		} else if (!localAddress.equals(other.localAddress))
			return false;
		if (mobile1 == null) {
			if (other.mobile1 != null)
				return false;
		} else if (!mobile1.equals(other.mobile1))
			return false;
		if (mobile2 == null) {
			if (other.mobile2 != null)
				return false;
		} else if (!mobile2.equals(other.mobile2))
			return false;
		if (permanentAddress == null) {
			if (other.permanentAddress != null)
				return false;
		} else if (!permanentAddress.equals(other.permanentAddress))
			return false;
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
		if (whatsAppNumber == null) {
			if (other.whatsAppNumber != null)
				return false;
		} else if (!whatsAppNumber.equals(other.whatsAppNumber))
			return false;
		return true;
	}

	
	
}
