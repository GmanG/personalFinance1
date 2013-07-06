package ua.home.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the balance database table.
 * 
 */
@Entity
@NamedQueries ({ 
				@NamedQuery(
							name = "Balance.findLastFiveTransaction",
//							query = "select b.id as id, b.sum as summ, b.description as descrip, t.name as name from Balance b join b.typecategory t where b.user = :user and b.typecategory = t and b.status = :status"),
							query = "select b from Balance b join b.typecategory t where b.user = :user and b.typecategory = t and b.status = :status"),
				@NamedQuery(
							name = "Balance.getTotalSum",
							query = "select b from Balance b, Typecategory t where b.user = :user and t.user = :user and b.typecategory = t"),
				@NamedQuery(
							name = "Balance.getSumByUserAndStatus",
							query = "select sum(b.sum) as total from Balance b where b.user = :user and b.status = :status"
						)
})
public class Balance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String description;

	private BigDecimal sum;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategorieID")
	private Category category;

	//bi-directional many-to-one association to Typecategory
	@ManyToOne
	@JoinColumn(name="TypeID")
	private Typecategory typecategory;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="StatusID")
	private Balancestatus status;

	@Override
	public String toString() {
		return "Balance [id=" + id + ", description=" + description + ", sum="
				+ sum + ", category=" + category + ", typecategory="
				+ typecategory + ", user=" + user + ", status=" + status + "]";
	}

	public Balance() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getSum() {
		return this.sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Typecategory getTypecategory() {
		return this.typecategory;
	}

	public void setTypecategory(Typecategory typecategory) {
		this.typecategory = typecategory;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Balancestatus getStatus() {
		return status;
	}

	public void setStatus(Balancestatus status) {
		this.status = status;
	}

}