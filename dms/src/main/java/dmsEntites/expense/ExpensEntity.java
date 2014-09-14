package dmsEntites.expense;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PersistenceModifier;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(objectIdClass=ExpensEntity.class, table="expens_entity",detachable="true")
public class ExpensEntity implements Serializable{

	
	
	@NotPersistent
	private static final long serialVersionUID = 1L;

	
	@Persistent(primaryKey="true", valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id;
	
	@Column(defaultValue = "null", jdbcType = "VARCHAR", name = "expenseName")
	private String expenseName;
	
	@Column(jdbcType="INTEGER" , name="totalCost")
	private long totalCost;
	
	@Join(table ="expense_purpose" )
	@Column(name="expense_purposeCol")
	@Persistent(persistenceModifier = PersistenceModifier.PERSISTENT, defaultFetchGroup = "true")
	List<PurposeEntity> purpose;
	
	
	
	
	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getExpenseName() {
		return expenseName;
	}




	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}




	public long getTotalCost() {
		return totalCost;
	}




	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}




	public List<PurposeEntity> getPurpose() {
		return purpose;
	}




	public void setPurpose(List<PurposeEntity> purpose) {
		this.purpose = purpose;
	}




	public ExpensEntity() {
		super();
	}




	public ExpensEntity(long id, String expenseName, long totalCost,
			List<PurposeEntity> purpose) {
		super();
		this.id = id;
		this.expenseName = expenseName;
		this.totalCost = totalCost;
		this.purpose = purpose;
	}




	@Override
	public String toString() {
		return "ExpensEntity [id=" + id + ", expenseName=" + expenseName
				+ ", totalCost=" + totalCost + ", purpose=" + purpose + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expenseName == null) ? 0 : expenseName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + (int) (totalCost ^ (totalCost >>> 32));
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
		ExpensEntity other = (ExpensEntity) obj;
		if (expenseName == null) {
			if (other.expenseName != null)
				return false;
		} else if (!expenseName.equals(other.expenseName))
			return false;
		if (id != other.id)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (totalCost != other.totalCost)
			return false;
		return true;
	}

	
	
}
