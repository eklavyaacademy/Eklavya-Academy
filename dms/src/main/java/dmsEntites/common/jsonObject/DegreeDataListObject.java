package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
@JsonSerialize(include = Inclusion.NON_NULL)
public class DegreeDataListObject implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<DegreeData> degrees;

	public List<DegreeData> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<DegreeData> degrees) {
		this.degrees = degrees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DegreeDataListObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DegreeDataListObject(List<DegreeData> degrees) {
		super();
		this.degrees = degrees;
	}

	@Override
	public String toString() {
		return "DegreeDataListObject [degrees=" + degrees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((degrees == null) ? 0 : degrees.hashCode());
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
		DegreeDataListObject other = (DegreeDataListObject) obj;
		if (degrees == null) {
			if (other.degrees != null)
				return false;
		} else if (!degrees.equals(other.degrees))
			return false;
		return true;
	}
	
	
}
