package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
@JsonSerialize(include = Inclusion.NON_NULL)
public class AdvanceAmountListObject implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<AmountData> advance ;

	public List<AmountData> getAdvance() {
		return advance;
	}

	public void setAdvance(List<AmountData> advance) {
		this.advance = advance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AdvanceAmountListObject(List<AmountData> advance) {
		super();
		this.advance = advance;
	}

	public AdvanceAmountListObject() {
		super();
	}

	@Override
	public String toString() {
		return "AdvanceAmountObject [advance=" + advance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advance == null) ? 0 : advance.hashCode());
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
		AdvanceAmountListObject other = (AdvanceAmountListObject) obj;
		if (advance == null) {
			if (other.advance != null)
				return false;
		} else if (!advance.equals(other.advance))
			return false;
		return true;
	}  
	
	
	
	
}
