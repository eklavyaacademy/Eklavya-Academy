package dmsEntites.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(objectIdClass = StudentSubjectEntity.class, table = "student_subject_entity", detachable = "true")
public class StudentSubjectEntity implements Serializable {

	@NotPersistent
	private static final long serialVersionUID = 1L;

	// Foreign key's
	@Column(defaultValue = "-1", jdbcType = "INTEGER", name = "subject_id")
	private long subjectId = -1; // SubjectEntity

	@Column(defaultValue = "-1", jdbcType = "INTEGER", name = "faculty_id")
	private long facultyId = -1; // FacultyEntity

	@Column(defaultValue = "-1", jdbcType = "INTEGER", name = "batch_id")
	private long batchId = -1; // BatchEntity

	@Column(jdbcType = "DATE", name = "fee_submission_date")
	private Date feeSubmissionDate;

	@Column(jdbcType = "INTEGER", name = "subject_fee")
	private long subjectFee; // will obtained corresponding to subject_id from
								// Subject Entity

	@Column(jdbcType = "INTEGER", name = "amount_paid")
	private long amountPaid; // how much amount student has paid as installment

	@Column(name = "advance_Amount", jdbcType = "CLOB")
	@Persistent(table = "student_advance_amount_paid")
	private List<String> installment; // AmountObject

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}

	public long getBatchId() {
		return batchId;
	}

	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}

	public Date getFeeSubmissionDate() {
		return feeSubmissionDate;
	}

	public void setFeeSubmissionDate(Date feeSubmissionDate) {
		this.feeSubmissionDate = feeSubmissionDate;
	}

	public long getSubjectFee() {
		return subjectFee;
	}

	public void setSubjectFee(long subjectFee) {
		this.subjectFee = subjectFee;
	}

	public long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public List<String> getInstallment() {
		return installment;
	}

	public void setInstallment(List<String> installment) {
		this.installment = installment;
	}

	public StudentSubjectEntity() {
		super();
	}

	public StudentSubjectEntity(long subjectId, long facultyId, long batchId,
			Date feeSubmissionDate, long subjectFee, long amountPaid,
			List<String> installment) {
		super();
		this.subjectId = subjectId;
		this.facultyId = facultyId;
		this.batchId = batchId;
		this.feeSubmissionDate = feeSubmissionDate;
		this.subjectFee = subjectFee;
		this.amountPaid = amountPaid;
		this.installment = installment;
	}

	@Override
	public String toString() {
		return "StudentSubjectEntity [subjectId=" + subjectId + ", facultyId="
				+ facultyId + ", batchId=" + batchId + ", feeSubmissionDate="
				+ feeSubmissionDate + ", subjectFee=" + subjectFee
				+ ", amountPaid=" + amountPaid + ", installment=" + installment
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amountPaid ^ (amountPaid >>> 32));
		result = prime * result + (int) (batchId ^ (batchId >>> 32));
		result = prime * result + (int) (facultyId ^ (facultyId >>> 32));
		result = prime
				* result
				+ ((feeSubmissionDate == null) ? 0 : feeSubmissionDate
						.hashCode());
		result = prime * result
				+ ((installment == null) ? 0 : installment.hashCode());
		result = prime * result + (int) (subjectFee ^ (subjectFee >>> 32));
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

		StudentSubjectEntity other = (StudentSubjectEntity) obj;
		if (amountPaid != other.amountPaid)
			return false;

		if (batchId != other.batchId)
			return false;

		if (facultyId != other.facultyId)
			return false;

		if (subjectFee != other.subjectFee)
			return false;
		if (subjectId != other.subjectId)
			return false;

		if (feeSubmissionDate == null) {
			if (other.feeSubmissionDate != null)
				return false;
		} else if (!feeSubmissionDate.equals(other.feeSubmissionDate))
			return false;

		if (installment == null) {
			if (other.installment != null)
				return false;
		} else {

			if (this.installment.size() != ((StudentSubjectEntity) obj)
					.getInstallment().size()) {
				return false;
			}

			for (String data : ((StudentSubjectEntity) obj).getInstallment()) {

				boolean isFound = false;

				for (String stringData : this.installment) {

					if (stringData.equals(data)) {

						isFound = true;

						break;

					}

				}
				if (isFound == false) {
					return false;
				}
			}
		}
		return true;
	}

}
