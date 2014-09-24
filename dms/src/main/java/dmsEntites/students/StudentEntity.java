package dmsEntites.students;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Joins;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(objectIdClass = StudentEntity.class, table = "student_entity", detachable = "true")
@Joins ( 
		 { @Join(table="contact_student",column="id",primaryKey="id_pk"),
		   @Join(table="student_branch",column="id",primaryKey="id_pk"),
		   @Join(table="student_subjects",column="id",primaryKey="id_pk")
		 }
      )

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
	private boolean schoolOrCollege = true; // false = school 	//true = college

	
	//JSON objects 
	@Column(name = "contact", jdbcType = "CLOB")
	@Persistent(table = "contact_student")
	private String contact;//ContactInfoObject

	@Column(name = "branch", jdbcType = "CLOB")
	@Persistent(table = "student_branch")
	private String branch; //BranchObject
	
	@Column(name = "subjects", jdbcType = "CLOB")
	@Persistent(table = "student_subjects")
	private String subjects; //StudentSubjectListObject
	
	
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StudentEntity() {
		super();
	}

	public StudentEntity(long studentId, String studentName,
			Date dateOfJoining, Date registrationDate, Date dateOfBirth,
			String instituteName, boolean schoolOrCollege,
			String contact, String branch, String subjects) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfJoining = dateOfJoining;
		this.registrationDate = registrationDate;
		this.dateOfBirth = dateOfBirth;
		this.instituteName = instituteName;
		this.schoolOrCollege = schoolOrCollege;
		this.contact = contact;
		this.branch = branch;
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName="
				+ studentName + ", dateOfJoining=" + dateOfJoining
				+ ", registrationDate=" + registrationDate + ", dateOfBirth="
				+ dateOfBirth + ", instituteName=" + instituteName
				+ ", schoolOrCollege=" + schoolOrCollege + ", contact="
				+ contact + ", branch=" + branch + ", subjects="
				+ subjects + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result
				+ ((contact == null) ? 0 : contact.hashCode());
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
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
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


	public void updateAll(StudentEntity input){
		
		this.studentId = input.studentId;
		
		this.studentName = input.studentName;
		
		this.dateOfJoining = input.dateOfJoining;
		
		this.registrationDate = input.registrationDate;

		this.dateOfBirth = input.dateOfBirth;

		this.instituteName = input.instituteName;

		this.schoolOrCollege = input.schoolOrCollege;

		this.contact = input.contact;

		this.branch = input.branch;
		
		this.subjects = input.subjects;
		
	}
	
	
}
