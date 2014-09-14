package dmsEntites.students;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(objectIdClass = BranchEntity.class, table = "branch_entity", detachable = "true")
public class BranchEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;

	//Properties =============================================================

	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long branchId; 
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "name")
	private String branchName ; 
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "semester")
	private String semester ;

	//Getter & setter =============================================================
	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

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
	public BranchEntity(long branchId, String branchName, String semester) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.semester = semester;
	}

	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	//Supportive methods =============================================================
	public void updateAll(BranchEntity input){
		this.branchName = input.getBranchName();
		this.semester = input.getSemester() ; 
	}
	
	public void updateBranchName (BranchEntity input){
		this.branchName = input.getBranchName();
	}
	
	public void updateSemester (BranchEntity input){
		this.semester = input.getSemester() ; 
	}

	//Override methods =============================================================
	@Override
	public String toString() {
		return "BranchEntity [branchId=" + branchId + ", branchName="
				+ branchName + ", semester=" + semester + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (branchId ^ (branchId >>> 32));
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
		BranchEntity other = (BranchEntity) obj;
		if (branchId != other.branchId)
			return false;
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
