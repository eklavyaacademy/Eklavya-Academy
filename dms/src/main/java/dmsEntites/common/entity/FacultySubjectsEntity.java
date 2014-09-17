package dmsEntites.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PersistenceModifier;
import javax.jdo.annotations.Persistent;
import dmsEntites.faculty.BatchEntity;

@PersistenceCapable(objectIdClass = FacultySubjectsEntity.class, table = "faculty_subject_entity", detachable = "true")
public class FacultySubjectsEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;

	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT, column="subject_id")
	private long subjectId; 
	
	@Column( jdbcType = "REAL", name = "percentage")
	private double percentageOnSubject;
	
	@Column(jdbcType = "INTEGER", name = "amount_collected")
	private long amountColleted;
	
	@Persistent(defaultFetchGroup = "true", persistenceModifier = PersistenceModifier.PERSISTENT)
	@Join(table ="faculty_batch" )
	@Column(name="faculty_batchCol")
	private List<BatchEntity> batches;
	
	

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public double getPercentageOnSubject() {
		return percentageOnSubject;
	}

	public void setPercentageOnSubject(double percentageOnSubject) {
		this.percentageOnSubject = percentageOnSubject;
	}

	public long getAmountColleted() {
		return amountColleted;
	}

	public void setAmountColleted(long amountColleted) {
		this.amountColleted = amountColleted;
	}

	public List<BatchEntity> getBatches() {
		return batches;
	}

	public void setBatches(List<BatchEntity> batches) {
		this.batches = batches;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		
		
		StringBuilder result = new StringBuilder("FacultySubjectsEntity{subjectId=" + subjectId
				+ ", percentageOnSubject=" + percentageOnSubject
				+ ", amountColleted=" + amountColleted + ", batches=[" );
		
		if (getBatches() != null)
			for (int i = 0; i < getBatches().size(); i++) {
				BatchEntity data = getBatches().get(i);
				result = result.append(data.toString());
				if (i != getBatches().size() - 1) {
					result = result.append(", ");
				}
			}
		result = result.append("]}");
		return result.toString();
		
	
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

			FacultySubjectsEntity other = (FacultySubjectsEntity) obj;

			if (amountColleted != other.amountColleted)
				return false;

			if (Double.doubleToLongBits(percentageOnSubject) != Double
					.doubleToLongBits(other.percentageOnSubject))
				
				return false;

			if (subjectId != other.subjectId)
				return false;

			if (batches == null) {
				if (other.batches != null)
					return false;
				
			} else {
				
				if (this.batches.size() != ((FacultySubjectsEntity) obj)
						.getBatches().size()) {
					return false;
				}

				for (BatchEntity data : ((FacultySubjectsEntity) obj)
						.getBatches()) {

					boolean isFound = false;

					for (BatchEntity batchData : this.batches) {

						if (batchData.equals(data)) {

							isFound = true;

							break;

						}

					}
					if (isFound == false) {
						return false;
					}
				}

			}
		} else {
			return false;
		}

		return true;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (amountColleted ^ (amountColleted >>> 32));
		result = prime * result + ((batches == null) ? 0 : batches.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentageOnSubject);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
		return result;
	}


	public FacultySubjectsEntity(long subjectId, double percentageOnSubject,
			long amountColleted, List<BatchEntity> batches) {
		super();
		this.subjectId = subjectId;
		this.percentageOnSubject = percentageOnSubject;
		this.amountColleted = amountColleted;
		this.batches = batches;
	}

	public FacultySubjectsEntity() {
		super();
	} 
	
	
	
	
	
	
	

}
