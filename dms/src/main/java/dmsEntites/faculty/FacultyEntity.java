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


@PersistenceCapable(objectIdClass = FacultyEntity.class, table = "faculty_entity", detachable = "true")
@Joins({
		@Join(table = "contact_faculty", column = "id", primaryKey = "id_pk"),
		@Join(table = "faculty_advance_amount_paid", column = "id", primaryKey = "id_pk"),
		@Join(table = "faculty_qualification", column = "id", primaryKey = "id_pk")
	  })

public class FacultyEntity implements Serializable {

	@NotPersistent
	private static final long serialVersionUID = 1L;

	// Properties =============================================================
	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
	private long facultyId;

	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "faculty_Name")
	private String facultyName;

	@Column(jdbcType = "BIT", name = "isActive")
	private boolean isActive = true;

	@Column(jdbcType = "DATE", name = "DOJ")
	private Date dateOfJoining;

	@Column(jdbcType = "DATE", name = "payement_date")
	private Date paymentDate;

	@Column(jdbcType = "DATE", name = "DOB")
	private Date dateOfBirth;

	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "basic_salary")
	private long basicSalary;

	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "amount_paid")
	private long totalAdvanceAmountPaid;

	// JSON Object Properties =============================================================

	@Column(name = "contact", jdbcType = "CLOB")
	@Persistent(table = "contact_faculty")
	private String contact; //contactinfoObject

	@Column(name = "advanceAmount", jdbcType = "CLOB")
	@Persistent(table = "faculty_advance_amount_paid")
	private String advances; // AdvanceAmountListObject

	@Column(name = "qualification", jdbcType = "CLOB")
	@Persistent(table = "faculty_qualification")
	private String qualifications; // DegreeDataListObject

	// Interrelated Properties =============================================================

	@Persistent(defaultFetchGroup = "true", persistenceModifier = PersistenceModifier.PERSISTENT, dependent="true")
	@Join(table = "faculty_subjects")
	@Column(name = "faculty_subjects")
	private List<FacultySubjectsEntity> subjects;
	
	

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(long basicSalary) {
		this.basicSalary = basicSalary;
	}

	public long getTotalAdvanceAmountPaid() {
		return totalAdvanceAmountPaid;
	}

	public void setTotalAdvanceAmountPaid(long totalAdvanceAmountPaid) {
		this.totalAdvanceAmountPaid = totalAdvanceAmountPaid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAdvances() {
		return advances;
	}

	public void setAdvances(String advances) {
		this.advances = advances;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public List<FacultySubjectsEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<FacultySubjectsEntity> subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FacultyEntity() {
		super();
	}

	public FacultyEntity(long facultyId, String facultyName, boolean isActive,
			Date dateOfJoining, Date paymentDate, Date dateOfBirth,
			long basicSalary, long totalAdvanceAmountPaid,
			String contact, String advances, String qualifications,
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
		this.contact = contact;
		this.advances = advances;
		this.qualifications = qualifications;
		this.subjects = subjects;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder("FacultyEntity {facultyId="
				+ facultyId + ", facultyName=" + facultyName + ", isActive="
				+ isActive + ", dateOfJoining=" + dateOfJoining
				+ ", paymentDate=" + paymentDate + ", dateOfBirth="
				+ dateOfBirth + ", basicSalary=" + basicSalary
				+ ", totalAdvanceAmountPaid=" + totalAdvanceAmountPaid
				+ ", contact=" + contact + ", advances=" + advances
				+ ", qualifications=" + qualifications + ", subjects=[");

		if (getSubjects() != null)
			for (int i = 0; i < getSubjects().size(); i++) {
				FacultySubjectsEntity data = getSubjects().get(i);
				result = result.append(data.toString());
				if (i != getSubjects().size() - 1) {
					result = result.append(", ");
				}
			}
		result = result.append("]}");
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advances == null) ? 0 : advances.hashCode());
		result = prime * result + (int) (basicSalary ^ (basicSalary >>> 32));
		result = prime * result
				+ ((contact == null) ? 0 : contact.hashCode());
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
				+ ((qualifications == null) ? 0 : qualifications.hashCode());
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

		if (obj instanceof BatchEntity) {
			FacultyEntity other = (FacultyEntity) obj;

			if (advances == null) {
				if (other.advances != null)
					return false;
			} else if (!advances.equals(other.advances))
				return false;

			if (basicSalary != other.basicSalary)
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

			if (qualifications == null) {
				if (other.qualifications != null)
					return false;
			} else if (!qualifications.equals(other.qualifications))
				return false;

			if (totalAdvanceAmountPaid != other.totalAdvanceAmountPaid)
				return false;

			if (subjects == null) {
				if (other.subjects != null)
					return false;
			} else {

				if (this.subjects.size() != ((FacultyEntity) obj).getSubjects()
						.size()) {
					return false;
				}

				for (FacultySubjectsEntity data : ((FacultyEntity) obj)
						.getSubjects()) {

					boolean isFound = false;

					for (FacultySubjectsEntity innerData : this.subjects) {

						if (innerData.equals(data)) {

							isFound = true;

							break;

						}

					}
					if (isFound == false) {
						return false;
					}
				}

			}

		}
		return true;
	}

}
