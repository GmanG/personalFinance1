package ua.home.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typecategory database table.
 * 
 */
@Entity
@NamedQueries({
				@NamedQuery(
							name = "Typecategory.getAllTypeCategoryUser",
							query = "select t from Typecategory t where t.user = :user or t.user is null"
							),
				@NamedQuery(
							name = "Typecategory.getOneTypeByName",
							query = "select t from Typecategory t where t.name = :name"
						)
	
})
public class Typecategory implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	//bi-directional many-to-one association to Balance
//	@OneToMany(mappedBy="typecategory")
//	private List<Balance> balances;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public Typecategory() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Balance> getBalances() {
//		return this.balances;
//	}
//
//	public void setBalances(List<Balance> balances) {
//		this.balances = balances;
//	}
//
//	public Balance addBalance(Balance balance) {
//		getBalances().add(balance);
//		balance.setTypecategory(this);
//
//		return balance;
//	}
//
//	public Balance removeBalance(Balance balance) {
//		getBalances().remove(balance);
//		balance.setTypecategory(null);
//
//		return balance;
//	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Typecategory [id=" + id + ", name=" + name + ",  user=" + user + "]";
	}
}