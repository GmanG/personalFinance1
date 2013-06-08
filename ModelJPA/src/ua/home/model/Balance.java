package ua.home.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the balance database table.
 * 
 */
@Entity
//@NamedNativeQuery (name = "findLastFiveTransaction",
//				query = "select categorietype.Name, balance.Sum, balance.Description  from balance, user, categorietype " +
//						"where balance.UserID=user.ID and categorietype.UserID=user.ID")
public class Balance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private BigDecimal sum;
	
	@Column(name="Description")
	private String descrip;
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="CategorieID")
	private Categorie categorie;

	//bi-directional many-to-one association to Categorietype
	@ManyToOne
	@JoinColumn(name="TypeID")
	private Categorietype categorietype;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public Balance() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getSum() {
		return this.sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorietype getCategorietype() {
		return this.categorietype;
	}

	public void setCategorietype(Categorietype categorietype) {
		this.categorietype = categorietype;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}