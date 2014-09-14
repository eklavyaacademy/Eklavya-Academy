package dmsEntites.common.jsonObject;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class AddressObject implements Serializable {

	
	
	//Properties ====================================================
	private static final long serialVersionUID = 1L;
	private String localAddress ; 
	private String permanentAddress ; 
	
	//Getter & Setter ==============================================
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

	//Constructors =============================================================
	public AddressObject() {
		super();
	}


	public AddressObject(String localAddress, String permanentAddress) {
		super();
		this.localAddress = localAddress;
		this.permanentAddress = permanentAddress;
	}

	//Override =============================================================
	@Override
	public String toString() {
		return "AddressObject [localAddress=" + localAddress
				+ ", permanentAddress=" + permanentAddress + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((localAddress == null) ? 0 : localAddress.hashCode());
		result = prime
				* result
				+ ((permanentAddress == null) ? 0 : permanentAddress.hashCode());
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
		AddressObject other = (AddressObject) obj;
		if (localAddress == null) {
			if (other.localAddress != null)
				return false;
		} else if (!localAddress.equals(other.localAddress))
			return false;
		if (permanentAddress == null) {
			if (other.permanentAddress != null)
				return false;
		} else if (!permanentAddress.equals(other.permanentAddress))
			return false;
		return true;
	}

	//Supportive methods ================================================
	public void updateAll(AddressObject input){
		this.localAddress = input.getLocalAddress();
		this.permanentAddress= input.getPermanentAddress();
	}
	
	public void updateLocalAddress(AddressObject input){
		this.localAddress = input.getLocalAddress();
	}
	
	public void updatePermanentAddress(AddressObject input){
		this.permanentAddress= input.getPermanentAddress();
	}
	
	
}
