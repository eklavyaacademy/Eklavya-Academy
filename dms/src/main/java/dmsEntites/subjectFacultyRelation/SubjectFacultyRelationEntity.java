package dmsEntites.subjectFacultyRelation;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

import dmsEntites.common.jsonObject.FacultyObject;
import dmsEntites.inquary.InquaryEntity;

@PersistenceCapable(objectIdClass = InquaryEntity.class, table = "subject_faculty_relation_entity", detachable = "true")
@Join(table="faculty_object",column="id_ref",primaryKey="id_pk")
public class SubjectFacultyRelationEntity implements Serializable{
	
	@NotPersistent
	private static final long serialVersionUID = 1L;

	//Properties =============================================================
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id;
	
	@Unique
	@Column(jdbcType = "INTEGER", name = "subjectId")
	private long subjectId; 
	
	@Column(name = "facultiesObject", jdbcType = "CLOB")
	@Persistent(table = "faculty_object")
	private String facultiesObject;
	
	
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



	public String getFacultiesObject() {
		return facultiesObject;
	}

	public void setFacultiesObject(String facultiesObject) {
		this.facultiesObject = facultiesObject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//Constructor's =====================================================
	public SubjectFacultyRelationEntity() {
		super();
	}


	public SubjectFacultyRelationEntity(long id, long subjectId,
			String facultiesObject) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.facultiesObject = facultiesObject;
	}
	
	//Override methods ====================================================
	@Override
	public String toString() {
		return "SubjectFacultyRelationEntity [id=" + id + ", subjectId="
				+ subjectId + ", facultiesJsonObject=" + facultiesObject
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((facultiesObject == null) ? 0 : facultiesObject.hashCode());
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
		if (facultiesObject == null) {
			if (other.facultiesObject != null)
				return false;
		} else if (!facultiesObject.equals(other.facultiesObject))
			return false;
		if (id != other.id)
			return false;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}

	// Supportive methods =================================================
	public void updateAll(SubjectFacultyRelationEntity input) {
		this.subjectId = input.getSubjectId();
		this.facultiesObject = input.getFacultiesObject();
	}
	
	public void updateFaculties(SubjectFacultyRelationEntity input) {
		this.facultiesObject = input.getFacultiesObject();
	}
	

	
	
}
