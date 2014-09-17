package dmsEntites.students;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PersistenceModifier;
import javax.jdo.annotations.Persistent;

import dmsEntites.common.entity.FacultySubjectsEntity;
import dmsEntites.common.entity.StudentSubjectEntity;


@PersistenceCapable(objectIdClass = StudentEntity.class, table = "student_entity", detachable = "true")
@Join(table="contact_student",column="id_ref",primaryKey="id_pk")

public class StudentEntity implements Serializable {

	@NotPersistent
	private static final long serialVersionUID = 1L;
	
	
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT, column="student_registration_id")
	private long studentId;
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "student_name")
	private String studentName;
	
	@Column(defaultValue = "null", jdbcType = "DATE", name = "DOJ")
	private Date dateOfJoining;
	
	@Column(defaultValue = "null", jdbcType = "DATE", name = "registration_date")
	private Date registrationDate;

	@Column(defaultValue = "null", jdbcType = "DATE", name = "DOB")
	private Date dateOfBirth;


	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "institute_name")
	private String instituteName;

	@Column(jdbcType = "BIT", name = "schoolOrCollege")
	private boolean schoolOrCollege = false; // false = school 	//true = college

	@Column(name = "contactObject", jdbcType = "CLOB")
	@Persistent(table = "contact_student")
	private String contactObject;
	
	@Persistent(persistenceModifier = PersistenceModifier.PERSISTENT, defaultFetchGroup = "true")
	@Column(name = "branch")
	private BranchEntity branch;	
	
	@Persistent(defaultFetchGroup = "true", persistenceModifier = PersistenceModifier.PERSISTENT)
	@Join(table ="student_subjects" )
	@Column(name="student_subjectsCol")
	private List<StudentSubjectEntity> subjects;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public boolean isSchoolOrCollege() {
		return schoolOrCollege;
	}

	public void setSchoolOrCollege(boolean schoolOrCollege) {
		this.schoolOrCollege = schoolOrCollege;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public List<StudentSubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<StudentSubjectEntity> subjects) {
		this.subjects = subjects;
	}

	public StudentEntity() {
		super();
	}

	public StudentEntity(long studentId, String studentName,
			Date dateOfJoining, Date registrationDate, Date dateOfBirth,
			String instituteName, boolean schoolOrCollege,
			String contactObject, BranchEntity branch,
			List<StudentSubjectEntity> subjects) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfJoining = dateOfJoining;
		this.registrationDate = registrationDate;
		this.dateOfBirth = dateOfBirth;
		this.instituteName = instituteName;
		this.schoolOrCollege = schoolOrCollege;
		this.contactObject = contactObject;
		this.branch = branch;
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName="
				+ studentName + ", dateOfJoining=" + dateOfJoining
				+ ", registrationDate=" + registrationDate + ", dateOfBirth="
				+ dateOfBirth + ", instituteName=" + instituteName
				+ ", schoolOrCollege=" + schoolOrCollege + ", contactObject="
				+ contactObject + ", branch=" + branch + ", subjects="
				+ subjects + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result
				+ ((contactObject == null) ? 0 : contactObject.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result
				+ ((instituteName == null) ? 0 : instituteName.hashCode());
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + (schoolOrCollege ? 1231 : 1237);
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result
				+ ((subjects == null) ? 0 : subjects.hashCode());
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
		StudentEntity other = (StudentEntity) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
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
		if (instituteName == null) {
			if (other.instituteName != null)
				return false;
		} else if (!instituteName.equals(other.instituteName))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (schoolOrCollege != other.schoolOrCollege)
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	
}
