package ua.home.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
				@NamedQuery (
							name ="User.findUserByEmailAndPass",
							query = "select u from User u where u.email = :email and u.pass = :pass" 
						)
	
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String email;

	private String pass;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to Balance
	@OneToMany(mappedBy="user")
	private List<Balance> balances;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="user")
	private List<Category> categories;

	//bi-directional many-to-one association to Typecategory
	@OneToMany(mappedBy="user")
	private List<Typecategory> typecategories;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<Balance> getBalances() {
		return this.balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	public Balance addBalance(Balance balance) {
		getBalances().add(balance);
		balance.setUser(this);

		return balance;
	}

	public Balance removeBalance(Balance balance) {
		getBalances().remove(balance);
		balance.setUser(null);

		return balance;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setUser(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setUser(null);

		return category;
	}

	public List<Typecategory> getTypecategories() {
		return this.typecategories;
	}

	public void setTypecategories(List<Typecategory> typecategories) {
		this.typecategories = typecategories;
	}

	public Typecategory addTypecategory(Typecategory typecategory) {
		getTypecategories().add(typecategory);
		typecategory.setUser(this);

		return typecategory;
	}

	public Typecategory removeTypecategory(Typecategory typecategory) {
		getTypecategories().remove(typecategory);
		typecategory.setUser(null);

		return typecategory;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", created=" + created + ", email=" + email
				+ ", pass=" + pass + ", updated=" + updated + ", balances="
				+ balances + ", categories=" + categories + ", typecategories="
				+ typecategories + "]";
	}

}