package dmsEntites.faculty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Joins;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PersistenceModifier;
import javax.jdo.annotations.Persistent;

import dmsEntites.common.entity.FacultySubjectsEntity;
import dmsEntites.common.jsonObject.AmountObject;
import dmsEntites.common.jsonObject.DegreeObject;
import dmsEntites.students.StudentEntity;

@PersistenceCapable(objectIdClass = FacultyEntity.class, table = "faculty_entity", detachable = "true")
@Join(table="contact_faculty",column="id_ref",primaryKey="id_pk")

public class FacultyEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;

	// Properties =============================================================
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long facultyId;
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "faculty_Name")
	private String facultyName; 

	@Column(jdbcType = "BIT", name = "isActive")
	private boolean isActive = true; 

	
	@Column(jdbcType = "DATE", name = "DOJ")
	private Date dateOfJoining;

	@Column( jdbcType = "DATE", name = "payement_date")
	private Date paymentDate;
	
	@Column(jdbcType = "DATE", name = "DOB")
	private Date dateOfBirth;
	
	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "basic_salary")
	private long basicSalary;
	
	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "amount_paid")
	private long totalAdvanceAmountPaid;
	
	
		// JSON Object Properties =============================================================

	@Column(name = "contactObject", jdbcType = "CLOB")
	@Persistent(table = "contact_faculty")
	private String contactObject;
	
		// JSON List Object Properties =============================================================

	@Column(name = "advanceAmountObject", jdbcType = "CLOB")
	@Persistent(table = "faculty_advance_amount_paid")
	private List<String> advance ;  //AdvanceAmountObject
	
	
		// Interrelated Properties =============================================================

	@Join(table ="faculty_qualification" )
	@Column(name="faculty_qualificationCol")
	@Persistent(defaultFetchGroup = "true")	
	private List<DegreeObject> qualification; 
	
	@Persistent(defaultFetchGroup = "true", persistenceModifier = PersistenceModifier.PERSISTENT)
	@Join(table ="faculty_subjects" )
	@Column(name="faculty_subjectsCol")
	private List<FacultySubjectsEntity> subjects;

	
	
	public FacultyEntity() {
		super();
	}



	public FacultyEntity(long facultyId, String facultyName, boolean isActive,
			Date dateOfJoining, Date paymentDate, Date dateOfBirth,
			long basicSalary, long totalAdvanceAmountPaid,
			String contactObject, List<String> advance,
			List<DegreeObject> qualification,
			List<FacultySubjectsEntity> subjects) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.isActive = isActive;
		this.dateOfJoining = dateOfJoining;
		this.paymentDate = paymentDate;
		this.dateOfBirth = dateOfBirth;
		this.basicSalary = basicSalary;
		this.totalAdvanceAmountPaid = totalAdvanceAmountPaid;
		this.contactObject = contactObject;
		this.advance = advance;
		this.qualification = qualification;
		this.subjects = subjects;
	}



	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName="
				+ facultyName + ", isActive=" + isActive + ", dateOfJoining="
				+ dateOfJoining + ", paymentDate=" + paymentDate
				+ ", dateOfBirth=" + dateOfBirth + ", basicSalary="
				+ basicSalary + ", totalAdvanceAmountPaid="
				+ totalAdvanceAmountPaid + ", contactObject=" + contactObject
				+ ", advance=" + advance + ", qualification=" + qualification
				+ ", subjects=" + subjects + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advance == null) ? 0 : advance.hashCode());
		result = prime * result + (int) (basicSalary ^ (basicSalary >>> 32));
		result = prime * result
				+ ((contactObject == null) ? 0 : contactObject.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + (int) (facultyId ^ (facultyId >>> 32));
		result = prime * result
				+ ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result
				+ ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result
				+ ((subjects == null) ? 0 : subjects.hashCode());
		result = prime
				* result
				+ (int) (totalAdvanceAmountPaid ^ (totalAdvanceAmountPaid >>> 32));
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
		FacultyEntity other = (FacultyEntity) obj;
		if (advance == null) {
			if (other.advance != null)
				return false;
		} else if (!advance.equals(other.advance))
			return false;
		if (basicSalary != other.basicSalary)
			return false;
		if (contactObject == null) {
			if (other.contactObject != null)
				return false;
		} else if (!contactObject.equals(other.contactObject))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (facultyId != other.facultyId)
			return false;
		if (facultyName == null) {
			if (other.facultyName != null)
				return false;
		} else if (!facultyName.equals(other.facultyName))
			return false;
		if (isActive != other.isActive)
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		if (totalAdvanceAmountPaid != other.totalAdvanceAmountPaid)
			return false;
		return true;
	}
	
}
