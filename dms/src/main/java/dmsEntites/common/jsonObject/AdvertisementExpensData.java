package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class AdvertisementExpensData implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//Properties ====================================================
	private String name;
	
	private Date date;
	
	private long size_Length ; 
	
	private long size_Width ; 
	
	private long size_Height ; 

	private int quantity;
	
	private DealerObject dealerDetails;
	
	private long totalCost;

	//Getter & Setter ==============================================
	

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSize_Length() {
		return size_Length;
	}

	public void setSize_Length(long size_Length) {
		this.size_Length = size_Length;
	}

	public long getSize_Width() {
		return size_Width;
	}

	public void setSize_Width(long size_Width) {
		this.size_Width = size_Width;
	}

	public long getSize_Height() {
		return size_Height;
	}

	public void setSize_Height(long size_Height) {
		this.size_Height = size_Height;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DealerObject getDealerDetails() {
		return dealerDetails;
	}

	public void setDealerDetails(DealerObject dealerDetails) {
		this.dealerDetails = dealerDetails;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((dealerDetails == null) ? 0 : dealerDetails.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
		result = prime * result + (int) (size_Height ^ (size_Height >>> 32));
		result = prime * result + (int) (size_Length ^ (size_Length >>> 32));
		result = prime * result + (int) (size_Width ^ (size_Width >>> 32));
		result = prime * result + (int) (totalCost ^ (totalCost >>> 32));
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
		AdvertisementExpensData other = (AdvertisementExpensData) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dealerDetails == null) {
			if (other.dealerDetails != null)
				return false;
		} else if (!dealerDetails.equals(other.dealerDetails))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (size_Height != other.size_Height)
			return false;
		if (size_Length != other.size_Length)
			return false;
		if (size_Width != other.size_Width)
			return false;
		if (totalCost != other.totalCost)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdvertisementExpensObject [name=" + name + ", date=" + date
				+ ", size_Length=" + size_Length + ", size_Width=" + size_Width
				+ ", size_Height=" + size_Height + ", quantity=" + quantity
				+ ", dealerDetails=" + dealerDetails + ", totalCost="
				+ totalCost + "]";
	}

	public AdvertisementExpensData() {
		super();
	}

	public AdvertisementExpensData(String name, Date date, long size_Length,
			long size_Width, long size_Height, int quantity,
			DealerObject dealerDetails, long totalCost) {
		super();
		this.name = name;
		this.date = date;
		this.size_Length = size_Length;
		this.size_Width = size_Width;
		this.size_Height = size_Height;
		this.quantity = quantity;
		this.dealerDetails = dealerDetails;
		this.totalCost = totalCost;
	}

	
	

}
