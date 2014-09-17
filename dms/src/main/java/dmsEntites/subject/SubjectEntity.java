package dmsEntites.subject;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(objectIdClass=SubjectEntity.class, table="subjects_entity",detachable="true")
public class SubjectEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;

	//Properties=====================================
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long subjectId;

	@Column(jdbcType="INTEGER" , name="fee")
	private long subjectFee;
	
	@Column(defaultValue="null", jdbcType="VARCHAR" , name="name")
	private String subjectName;
	
	@Column(defaultValue="null", jdbcType="VARCHAR" , name="code")
	private String subjectCode;
	
	@Column(defaultValue="null", jdbcType="VARCHAR" , name="semester")
	private String semester ; 
	
	
	
	
	//Getter&Setter==================================
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getSubjectFee() {
		return subjectFee;
	}

	public void setSubjectFee(long subjectFee) {
		this.subjectFee = subjectFee;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}



	//Override methods ====================================================

	@Override
	public String toString() {
		return "subjectEntity [subjectId=" + subjectId + ", subjectName="
				+ subjectName + ", subjectFee=" + subjectFee + ", subjectCode="
				+ subjectCode + ", semester=" + semester + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((semester == null) ? 0 : semester.hashCode());
		result = prime * result
				+ ((subjectCode == null) ? 0 : subjectCode.hashCode());
		result = prime * result + (int) (subjectFee ^ (subjectFee >>> 32));
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		SubjectEntity other = (SubjectEntity) obj;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (subjectCode == null) {
			if (other.subjectCode != null)
				return false;
		} else if (!subjectCode.equals(other.subjectCode))
			return false;
		if (subjectFee != other.subjectFee)
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
	
	//Constructor's =====================================================

	public SubjectEntity() {
		super();
	}

	public SubjectEntity(long subjectId, String subjectName, long subjectFee,
			String subjectCode, String semester) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectFee = subjectFee;
		this.subjectCode = subjectCode;
		this.semester = semester;
	}

	
	
	//Supportive methods =================================================
	public void updateAll ( SubjectEntity input){
		this.subjectCode = input.getSubjectCode();
		this.semester = input.getSemester();
		this.subjectFee = input.getSubjectFee();
		this.subjectName = input.getSubjectName();
	}
	
	
}
