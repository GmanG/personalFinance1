package ua.home.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
//@NamedQuery 
//(name ="findUserByEmailAndPass",
// query = "select o from User o where o.email=:email and o.pass=:pass")
@NamedQueries ({
			@NamedQuery
			(name = "getUserByEmail",
	 		 query = "select u from User u where u.email = :email"),
			@NamedQuery 
			(name ="findUserByEmailAndPass",
			 query = "select u from User u where u.email = :email and u.pass = :pass"),
			 @NamedQuery
				(name = "getUsers",
		 		 query = "select u from User u"),
			
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

	//bi-directional many-to-one association to Categorie
	@OneToMany(mappedBy="user")
	private List<Categorie> categories;

	//bi-directional many-to-one association to Categorietype
	@OneToMany(mappedBy="user")
	private List<Categorietype> categorietypes;

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

	public List<Categorie> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Categorie addCategory(Categorie category) {
		getCategories().add(category);
		category.setUser(this);

		return category;
	}

	public Categorie removeCategory(Categorie category) {
		getCategories().remove(category);
		category.setUser(null);

		return category;
	}

	public List<Categorietype> getCategorietypes() {
		return this.categorietypes;
	}

	public void setCategorietypes(List<Categorietype> categorietypes) {
		this.categorietypes = categorietypes;
	}

	public Categorietype addCategorietype(Categorietype categorietype) {
		getCategorietypes().add(categorietype);
		categorietype.setUser(this);

		return categorietype;
	}

	public Categorietype removeCategorietype(Categorietype categorietype) {
		getCategorietypes().remove(categorietype);
		categorietype.setUser(null);

		return categorietype;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", created=" + created + ", email=" + email
				+ ", pass=" + pass + ", updated=" + updated ;
	}
	

}