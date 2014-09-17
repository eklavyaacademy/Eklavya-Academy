package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property="@class" ) 
public class StudentSubjectData implements Serializable {

	private static final long serialVersionUID = 1L;

	// Foreign key's
	private long subjectId = -1; // SubjectEntity

	private long facultyId = -1; // FacultyEntity

	private long batchId = -1; // BatchEntity

	private Date feeSubmissionDate;

	private long subjectFee; // will obtained corresponding to subject_id from
								// Subject Entity

	private long amountPaid; // how much amount student has paid as installment

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

	public StudentSubjectData() {
		super();
	}

	public StudentSubjectData(long subjectId, long facultyId, long batchId,
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

		StudentSubjectData other = (StudentSubjectData) obj;
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

			if (this.installment.size() != ((StudentSubjectData) obj)
					.getInstallment().size()) {
				return false;
			}

			for (String data : ((StudentSubjectData) obj).getInstallment()) {

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
