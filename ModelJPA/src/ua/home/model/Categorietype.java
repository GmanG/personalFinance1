package ua.home.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorietype database table.
 * 
 */
@Entity
public class Categorietype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String name;

	//bi-directional many-to-one association to Balance
	@OneToMany(mappedBy="categorietype")
	private List<Balance> balances;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public Categorietype() {
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

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setCategorietype(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setCategorietype(null);

		return balance;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}