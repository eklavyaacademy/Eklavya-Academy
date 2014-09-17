package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
@JsonSerialize(include = Inclusion.NON_NULL)
public class AdvertisementExpensDataListObject implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<AdvertisementExpensData> advertiesments;

	public List<AdvertisementExpensData> getAdvertiesments() {
		return advertiesments;
	}

	public void setAdvertiesments(List<AdvertisementExpensData> advertiesments) {
		this.advertiesments = advertiesments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AdvertisementExpensDataListObject(
			List<AdvertisementExpensData> advertiesments) {
		super();
		this.advertiesments = advertiesments;
	}

	public AdvertisementExpensDataListObject() {
		super();
	}

	@Override
	public String toString() {
		return "AdvertisementExpensDataListObject [advertiesments="
				+ advertiesments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((advertiesments == null) ? 0 : advertiesments.hashCode());
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
		AdvertisementExpensDataListObject other = (AdvertisementExpensDataListObject) obj;
		if (advertiesments == null) {
			if (other.advertiesments != null)
				return false;
		} else if (!advertiesments.equals(other.advertiesments))
			return false;
		return true;
	}
	
	
}
