package dmsEntites.expense;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import constats.DMSConstants;



@PersistenceCapable(objectIdClass = PurposeEntity.class, table = "purpose_entity", detachable = "true")
@Join(table="purpose_advertiesment",column="id",primaryKey="id_pk")
public class PurposeEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;

	//Properties ==============================================================
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long purposeId;
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "purposeName")
	private String purposeName;
	
	@Column(defaultValue = "null", jdbcType = "INTEGER", name = "totalCost")
	private long totalCost;
	
	@Column(jdbcType = "DATE", name = "expenseDate")
	private Date expenseDate;
	
	@Column(defaultValue = DMSConstants.SINGLE_VALUE_EXPENSE , jdbcType = "INTEGER", name = "totalCost")
	private String typeOfPurpose; 
	
	/*@Join
	@Element(column="advertisementDetails",table="advertisement_details",dependent="true")
	private List<String> advertisementDetails = null; // if typeOfpurpose is multi value
	*/
	
	
	@Column(name = "advertiesment", jdbcType = "CLOB")
	@Persistent(table = "purpose_advertiesment")
	private String advertisementDetails ; //AdvertisementExpensDataListObject

	// Getter & setter =============================================================
	public long getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(long purposeId) {
		this.purposeId = purposeId;
	}

	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getTypeOfPurpose() {
		return typeOfPurpose;
	}

	public void setTypeOfPurpose(String typeOfPurpose) {
		this.typeOfPurpose = typeOfPurpose;
	}

	public String getAdvertisementDetails() {
		return advertisementDetails;
	}

	public void setAdvertisementDetails(String advertisementDetails) {
		this.advertisementDetails = advertisementDetails;
	}


	// Constructors =============================================================
	public PurposeEntity(long purposeId, String purposeName, long totalCost,
			Date expenseDate, String typeOfPurpose, String advertisementDetails) {
		super();
		this.purposeId = purposeId;
		this.purposeName = purposeName;
		this.totalCost = totalCost;
		this.expenseDate = expenseDate;
		this.typeOfPurpose = typeOfPurpose;
		this.advertisementDetails = advertisementDetails;
	}
	
	public PurposeEntity() {
		super();

	}

	// Override methods =====================================================
	@Override
	public String toString() {
		return "PurposeEntity [purposeId=" + purposeId + ", purposeName="
				+ purposeName + ", totalCost=" + totalCost + ", expenseDate="
				+ expenseDate + ", typeOfPurpose=" + typeOfPurpose
				+ ", advertisementDetails=" + advertisementDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((advertisementDetails == null) ? 0 : advertisementDetails
						.hashCode());
		result = prime * result
				+ ((expenseDate == null) ? 0 : expenseDate.hashCode());
		result = prime * result + (int) (purposeId ^ (purposeId >>> 32));
		result = prime * result
				+ ((purposeName == null) ? 0 : purposeName.hashCode());
		result = prime * result + (int) (totalCost ^ (totalCost >>> 32));
		result = prime * result
				+ ((typeOfPurpose == null) ? 0 : typeOfPurpose.hashCode());
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
		PurposeEntity other = (PurposeEntity) obj;
		if (advertisementDetails == null) {
			if (other.advertisementDetails != null)
				return false;
		} else if (!advertisementDetails.equals(other.advertisementDetails))
			return false;
		if (expenseDate == null) {
			if (other.expenseDate != null)
				return false;
		} else if (!expenseDate.equals(other.expenseDate))
			return false;
		if (purposeId != other.purposeId)
			return false;
		if (purposeName == null) {
			if (other.purposeName != null)
				return false;
		} else if (!purposeName.equals(other.purposeName))
			return false;
		if (totalCost != other.totalCost)
			return false;
		if (typeOfPurpose == null) {
			if (other.typeOfPurpose != null)
				return false;
		} else if (!typeOfPurpose.equals(other.typeOfPurpose))
			return false;
		return true;
	}

	// Supportive methods =============================================================
	public void updateAll(PurposeEntity input) {
		this.purposeId = input.purposeId;
		this.purposeName = input.purposeName;
		this.totalCost = input.totalCost;
		this.expenseDate = input.expenseDate;
		this.typeOfPurpose = input.typeOfPurpose;
		this.advertisementDetails = input.advertisementDetails;
	}
	
	

	public void updatePhoneNumber(PurposeEntity input){
		this.advertisementDetails = input.advertisementDetails;
	}
	
	
	
	
}
