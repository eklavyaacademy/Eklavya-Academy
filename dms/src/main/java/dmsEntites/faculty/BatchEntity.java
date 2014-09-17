package dmsEntites.faculty;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(objectIdClass = BatchEntity.class, table = "batch_entity", detachable = "true")
@Join(table="batch_students",column="id",primaryKey="id_pk")
public class BatchEntity implements Serializable{

	@NotPersistent
	private static final long serialVersionUID = 1L;
	
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT, column="batch_id")
	private long batchId;
	
	@Column(defaultValue = "0", jdbcType = "INTEGER", name = "total_fee_paid")
	private long totalFeePaid;
	
	
	@Persistent(table = "batch_students")
	@Column(name="batch_studentObject", jdbcType = "CLOB")
	private String students;  //BatchStudentDataListObject

	
	
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

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BatchEntity() {
		super();
	}

	public BatchEntity(long batchId, long totalFeePaid, String students) {
		super();
		this.batchId = batchId;
		this.totalFeePaid = totalFeePaid;
		this.students = students;
	}

	@Override
	public String toString() {
		return "BatchEntity [batchId=" + batchId + ", totalFeePaid="
				+ totalFeePaid + ", students=" + students + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (batchId ^ (batchId >>> 32));
		result = prime * result
				+ ((students == null) ? 0 : students.hashCode());
		result = prime * result + (int) (totalFeePaid ^ (totalFeePaid >>> 32));
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
		BatchEntity other = (BatchEntity) obj;
		if (batchId != other.batchId)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (totalFeePaid != other.totalFeePaid)
			return false;
		return true;
	}

	
	

	/*@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder( "BatchEntity {batchId=" + batchId + ", totalFeePaid="
				+ totalFeePaid + ", students=[");
		
		if (getStudents() != null)
			for (int i = 0; i < getStudents().size(); i++) {
				BatchStudentData data = getStudents().get(i);
				result = result.append(data.toString());
				if (i != getStudents().size() - 1) {
					result = result.append(", ");
				}
			}
		result = result.append("]}");
		return result.toString();
		
	}*/


	/*@Override
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

				for (BatchStudentData data : ((BatchEntity) obj).getStudents()) {
				
					boolean isFound = false;
					
					for (BatchStudentData studentData : this.students) {
					
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
*/
	
	

}
