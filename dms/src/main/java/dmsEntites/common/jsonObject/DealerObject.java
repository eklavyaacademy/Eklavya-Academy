package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class DealerObject implements Serializable {

	//Properties ====================================================
	private static final long serialVersionUID = 1L;
	private long dealerId;
	private String dealerName;
	private ContactInfoObject contact; 
	
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
	
		
	public ContactInfoObject getContact() {
		return contact;
	}
	public void setContact(ContactInfoObject contact) {
		this.contact = contact;
	}
	


	//Constructors =============================================================

	public DealerObject() {
		super();
	}
	
	public DealerObject(long dealerId, String dealerName,
			ContactInfoObject contact) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.contact = contact;
	}
	
	
	
	
	//Override =============================================================
	
	@Override
	public String toString() {
		return "DealerObject [dealerId=" + dealerId + ", dealerName="
				+ dealerName + ", contact=" + contact + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + (int) (dealerId ^ (dealerId >>> 32));
		result = prime * result
				+ ((dealerName == null) ? 0 : dealerName.hashCode());
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
		if (dealerId != other.dealerId)
			return false;
		if (dealerName == null) {
			if (other.dealerName != null)
				return false;
		} else if (!dealerName.equals(other.dealerName))
			return false;
		
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		
		return true;
	}
	
	
	

	
}
