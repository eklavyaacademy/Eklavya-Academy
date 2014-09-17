package dmsEntites.common.jsonObject;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class BranchObject implements Serializable{

	private static final long serialVersionUID = 1L;

	//Properties =============================================================
	private String branchName ; 
	
	private String semester ;

	
	//Getter & setter =============================================================
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	

	//Constructors =============================================================
	public BranchObject( String branchName, String semester) {
		super();
		this.branchName = branchName;
		this.semester = semester;
	}

	public BranchObject() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	//Supportive methods =============================================================
	public void updateAll(BranchObject input){
		this.branchName = input.getBranchName();
		this.semester = input.getSemester() ; 
	}
	
	public void updateBranchName (BranchObject input){
		this.branchName = input.getBranchName();
	}
	
	public void updateSemester (BranchObject input){
		this.semester = input.getSemester() ; 
	}

	@Override
	public String toString() {
		return "BranchEntity [branchName=" + branchName + ", semester="
				+ semester + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result
				+ ((semester == null) ? 0 : semester.hashCode());
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
		BranchObject other = (BranchObject) obj;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}
	
	
	
}
