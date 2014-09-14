package dmsEntites.common.jsonObject;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class PhoneNumberObject implements Serializable {

	private static final long serialVersionUID = 1L;

	// Properties ====================================================

	private String mobile1;

	private String mobile2;

	private String landline;

	// Getter & Setter ==============================================
	
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

	// Constructors ===========================================================
	public PhoneNumberObject(long id, String mobile1, String mobile2,
			String landline) {
		super();
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.landline = landline;
	}

	public PhoneNumberObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	//override methods ================================================================
	@Override
	public String toString() {
		return "PhoneNumberJSONObject [mobile1=" + mobile1 + ", mobile2="
				+ mobile2 + ", landline=" + landline + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((landline == null) ? 0 : landline.hashCode());
		result = prime * result + ((mobile1 == null) ? 0 : mobile1.hashCode());
		result = prime * result + ((mobile2 == null) ? 0 : mobile2.hashCode());
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
		PhoneNumberObject other = (PhoneNumberObject) obj;
		if (landline == null) {
			if (other.landline != null)
				return false;
		} else if (!landline.equals(other.landline))
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
		return true;
	}

	// Supportive methods ================================================
	public void updateAll(PhoneNumberObject input) {
		this.mobile1 = input.getMobile1();
		this.mobile2 = input.getMobile2();
		this.landline = input.getLandline();
	}

	public void updateFirstMobile(PhoneNumberObject input) {
		this.mobile1 = input.getMobile1();
	}

	public void updateSecondMobile(PhoneNumberObject input) {
		this.mobile2 = input.getMobile2();
	}

	public void updateLandline(PhoneNumberObject input) {
		this.landline = input.getLandline();
	}
}
