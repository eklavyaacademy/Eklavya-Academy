package dmsEntites.subjectFacultyRelation;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

@PersistenceCapable(objectIdClass = SubjectFacultyRelationEntity.class, table = "subject_faculty_relation_entity", detachable = "true")
@Join(table="faculty_subject_rel",column="id",primaryKey="id_pk")

public class SubjectFacultyRelationEntity implements Serializable{
	
	@NotPersistent
	private static final long serialVersionUID = 1L;

	//Properties =============================================================
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id;
	
	@Unique
	@Column(jdbcType = "INTEGER", name = "subjectId")
	private long subjectId; 
	
	@Column(name = "faculties", jdbcType = "CLOB")
	@Persistent(table = "faculty_subject_rel")
	private String faculties; //SubjectFacultyDataListObject
	
	
	//Getter&Setter==================================
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public long getSubjectId() {
		return subjectId;
	}



	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}


	public String getFaculties() {
		return faculties;
	}

	public void setFaculties(String faculties) {
		this.faculties = faculties;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//Constructor's =====================================================
	public SubjectFacultyRelationEntity() {
		super();
	}


	public SubjectFacultyRelationEntity(long id, long subjectId,
			String faculties) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.faculties = faculties;
	}
	
	
	// Supportive methods =================================================
	public void updateAll(SubjectFacultyRelationEntity input) {
		this.subjectId = input.getSubjectId();
		this.faculties = input.getFaculties();
	}
	
	//Override methods ====================================================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((faculties == null) ? 0 : faculties.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
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
		SubjectFacultyRelationEntity other = (SubjectFacultyRelationEntity) obj;
		if (faculties == null) {
			if (other.faculties != null)
				return false;
		} else if (!faculties.equals(other.faculties))
			return false;
		if (id != other.id)
			return false;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectFacultyRelationEntity [id=" + id + ", subjectId="
				+ subjectId + ", faculties=" + faculties + "]";
	}

	public void updateFaculties(SubjectFacultyRelationEntity input) {
		this.faculties = input.getFaculties();
	}
	

	
	
}
