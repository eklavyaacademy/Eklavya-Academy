package dmsEntites.common.jsonObject;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class AmountData implements Serializable {

	// Properties ====================================================
	private static final long serialVersionUID = 1L;
	private long amount;
	private Date date;

	// Getter & Setter ==============================================
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Constructors
	// =============================================================
	public AmountData(long amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public AmountData() {
		super();
	}

	// Override =============================================================
	@Override
	public String toString() {
		return "AdvanceAmountObject [amount=" + amount + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		AmountData other = (AmountData) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	// Supportive methods ================================================
	public void updateAll(AmountData input) {
		this.amount = input.getAmount();
		this.date = input.getDate();

	}

}
