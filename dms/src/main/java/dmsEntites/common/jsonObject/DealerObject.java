package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class DealerObject implements Serializable {

	//Properties ====================================================
	private static final long serialVersionUID = 1L;
	private long dealerId;
	private String dealerName;
	private AddressObject addressObject;
	private PhoneNumberObject phoneNumber; 
	private EmailIdJObject emailIds;
	
	//Getter & Setter ==============================================
	public long getDealerId() {
		return dealerId;
	}
	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public AddressObject getAddressObject() {
		return addressObject;
	}
	public void setAddressObject(AddressObject addressObject) {
		this.addressObject = addressObject;
	}
	public PhoneNumberObject getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumberObject phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public EmailIdJObject getEmailIds() {
		return emailIds;
	}
	public void setEmailIds(EmailIdJObject emailIds) {
		this.emailIds = emailIds;
	}

	//Constructors =============================================================
	public DealerObject(long dealerId, String dealerName,
			AddressObject addressObject, PhoneNumberObject phoneNumber,
			EmailIdJObject emailIds) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.addressObject = addressObject;
		this.phoneNumber = phoneNumber;
		this.emailIds = emailIds;
	}
	
	public DealerObject() {
		super();
	}
	
	//Override =============================================================
	@Override
	public String toString() {
		return "DealerObject [dealerId=" + dealerId + ", dealerName="
				+ dealerName + ", addressObject=" + addressObject
				+ ", phoneNumber=" + phoneNumber + ", emailIds=" + emailIds
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressObject == null) ? 0 : addressObject.hashCode());
		result = prime * result + (int) (dealerId ^ (dealerId >>> 32));
		result = prime * result
				+ ((dealerName == null) ? 0 : dealerName.hashCode());
		result = prime * result
				+ ((emailIds == null) ? 0 : emailIds.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		DealerObject other = (DealerObject) obj;
		if (addressObject == null) {
			if (other.addressObject != null)
				return false;
		} else if (!addressObject.equals(other.addressObject))
			return false;
		if (dealerId != other.dealerId)
			return false;
		if (dealerName == null) {
			if (other.dealerName != null)
				return false;
		} else if (!dealerName.equals(other.dealerName))
			return false;
		if (emailIds == null) {
			if (other.emailIds != null)
				return false;
		} else if (!emailIds.equals(other.emailIds))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	
	

	
}
