package dmsEntites.inquary;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Joins;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * @author Nitin
 *
 */

@PersistenceCapable(objectIdClass = InquaryEntity.class, table = "inquary_entity", detachable = "true")
@Joins ( 
		 { @Join(table="contact_inquary",column="id",primaryKey="id_pk"),
		   @Join(table="inquary_subject",column="id",primaryKey="id_pk")
		 }
       )

public class InquaryEntity implements Serializable {

	// Properties =============================================================
	@NotPersistent
	private static final long serialVersionUID = 1L;

	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long inqaryId;

	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "studentName")
	private String studentName;

	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "branch")
	private String branch;

	@Column(defaultValue = "null", jdbcType = "LONGVARCHAR", name = "instituteName")
	private String instituteName;

	@Column(defaultValue = "null", jdbcType = "DATE", name = "inquaryDate")
	private Date inquaryDate;

	@Column(jdbcType = "BIT", name = "schoolOrCollege")
	private boolean schoolOrCollege = false; // false = school 
											//true = college

	@Column(jdbcType = "BIT", name = "subjectMedium")
	private boolean subjectMedium = false; // false = Hindi 
										   //true = English

	@Column(jdbcType = "BIT", name = "registeredUser")
	private boolean registeredUser = false; // false = non-register 
											//true =  registered user

	@Column(name = "contact", jdbcType = "CLOB")
	@Persistent(table = "contact_inquary")
	private String contact; //ContactInfoObject

	@Column(name = "inquarySubject", jdbcType = "CLOB")
	@Persistent(table = "inquary_subject")
	private String inquarySubjects; //InquarySubjectDataListObject

	
	
	// Getter & setter =============================================================
	public long getInqaryId() {
		return inqaryId;
	}

	public void setInqaryId(long inqaryId) {
		this.inqaryId = inqaryId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Date getInquaryDate() {
		return inquaryDate;
	}

	public void setInquaryDate(Date inquaryDate) {
		this.inquaryDate = inquaryDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getInquarySubjects() {
		return inquarySubjects;
	}

	public void setInquarySubjects(String inquarySubjects) {
		this.inquarySubjects = inquarySubjects;
	}

	public boolean isSchoolOrCollege() {
		return schoolOrCollege;
	}

	public void setSchoolOrCollege(boolean schoolOrCollege) {
		this.schoolOrCollege = schoolOrCollege;
	}

	public boolean isSubjectMedium() {
		return subjectMedium;
	}

	public void setSubjectMedium(boolean subjectMedium) {
		this.subjectMedium = subjectMedium;
	}

	public boolean isRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(boolean registeredUser) {
		this.registeredUser = registeredUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructors =============================================================
	public InquaryEntity() {
		super();
	}


	public InquaryEntity(long inqaryId, String studentName, String branch,
			String instituteName, Date inquaryDate, boolean schoolOrCollege,
			boolean subjectMedium, boolean registeredUser,
			String contact, String inquarySubjects) {
		super();
		this.inqaryId = inqaryId;
		this.studentName = studentName;
		this.branch = branch;
		this.instituteName = instituteName;
		this.inquaryDate = inquaryDate;
		this.schoolOrCollege = schoolOrCollege;
		this.subjectMedium = subjectMedium;
		this.registeredUser = registeredUser;
		this.contact = contact;
		this.inquarySubjects = inquarySubjects;
	}

	

	// Supportive methods =============================================================
	public void updateAll(InquaryEntity input) {
		this.inqaryId = input.getInqaryId();
		this.studentName = input.getStudentName();
		this.branch = input.getBranch();
		this.instituteName = input.getInstituteName();
		this.inquaryDate = input.getInquaryDate();
		this.schoolOrCollege = input.isSchoolOrCollege();
		this.subjectMedium = input.isSubjectMedium();
		this.registeredUser = input.isRegisteredUser();
		this.contact = input.getContact();
		this.inquarySubjects = input.getInquarySubjects();
	}

	public void updateContact(InquaryEntity input){
		this.contact = input.contact;
	}
	
	public void updateRegisterUserProperty(InquaryEntity input){
		this.registeredUser = input.isRegisteredUser();
	}
	// Override methods =====================================================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + (int) (inqaryId ^ (inqaryId >>> 32));
		result = prime * result
				+ ((inquaryDate == null) ? 0 : inquaryDate.hashCode());
		result = prime
				* result
				+ ((inquarySubjects == null) ? 0 : inquarySubjects
						.hashCode());
		result = prime * result
				+ ((instituteName == null) ? 0 : instituteName.hashCode());
		result = prime * result + (registeredUser ? 1231 : 1237);
		result = prime * result + (schoolOrCollege ? 1231 : 1237);
		result = prime * result
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + (subjectMedium ? 1231 : 1237);
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
		InquaryEntity other = (InquaryEntity) obj;
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
		if (inqaryId != other.inqaryId)
			return false;
		if (inquaryDate == null) {
			if (other.inquaryDate != null)
				return false;
		} else if (!inquaryDate.equals(other.inquaryDate))
			return false;
		if (inquarySubjects == null) {
			if (other.inquarySubjects != null)
				return false;
		} else if (!inquarySubjects.equals(other.inquarySubjects))
			return false;
		if (instituteName == null) {
			if (other.instituteName != null)
				return false;
		} else if (!instituteName.equals(other.instituteName))
			return false;
		if (registeredUser != other.registeredUser)
			return false;
		if (schoolOrCollege != other.schoolOrCollege)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (subjectMedium != other.subjectMedium)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InquaryEntity [inqaryId=" + inqaryId + ", studentName="
				+ studentName + ", branch=" + branch + ", instituteName="
				+ instituteName + ", inquaryDate=" + inquaryDate
				+ ", schoolOrCollege=" + schoolOrCollege + ", subjectMedium="
				+ subjectMedium + ", registeredUser=" + registeredUser
				+ ", contact=" + contact + ", inquarySubjects="
				+ inquarySubjects + "]";
	}


}
