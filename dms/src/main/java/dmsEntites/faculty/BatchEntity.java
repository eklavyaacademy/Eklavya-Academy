package dmsEntites.faculty;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PersistenceModifier;
import javax.jdo.annotations.Persistent;

import dmsEntites.common.relatedobjects.Student;

@PersistenceCapable(objectIdClass = BatchEntity.class, table = "batch_entity", detachable = "true")
public class BatchEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;
	
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT, column="batch_id")
	private long batchId;
	
	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "total_fee_paid")
	private long totalFeePaid;
	
	@Join(table ="batch_students" )
	@Column(name="batch_studentCol")
	@Persistent(defaultFetchGroup = "true")
	List<Student> students;

	public long getBatchId() {
		return batchId;
	}

	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}

	public long getTotalFeePaid() {
		return totalFeePaid;
	}

	public void setTotalFeePaid(long totalFeePaid) {
		this.totalFeePaid = totalFeePaid;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BatchEntity(long batchId, long totalFeePaid, List<Student> students) {
		super();
		this.batchId = batchId;
		this.totalFeePaid = totalFeePaid;
		this.students = students;
	}

	public BatchEntity() {
		super();
	}

	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder( "BatchEntity {batchId=" + batchId + ", totalFeePaid="
				+ totalFeePaid + ", students=[");
		
		if (getStudents() != null)
			for (int i = 0; i < getStudents().size(); i++) {
				Student data = getStudents().get(i);
				result = result.append(data.toString());
				if (i != getStudents().size() - 1) {
					result = result.append(", ");
				}
			}
		result = result.append("]}");
		return result.toString();
		
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (this == obj)
			return true;
		
		if (obj instanceof BatchEntity) {
			
			
			if (getClass() != obj.getClass())
				return false;
			BatchEntity other = (BatchEntity) obj;
			if (batchId != other.batchId)
				return false;
			if (totalFeePaid != other.totalFeePaid)
				return false;

			if (students == null) {
				if (other.students != null)
					return false;
			} else {
				if (this.students.size() != ((BatchEntity) obj).getStudents().size()) {
					return false;
				}

				for (Student data : ((BatchEntity) obj).getStudents()) {
				
					boolean isFound = false;
					
					for (Student studentData : this.students) {
					
						if (studentData.equals(data)) {
							isFound = true;
							break;
						}
					
					}
					if (isFound == false) {
						return false;
					}
				}

			}
		}else {
			
			return false;
			
		}
		return true;
	}

	
	

}
