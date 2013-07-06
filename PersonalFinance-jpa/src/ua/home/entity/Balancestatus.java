package ua.home.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the balancestatus database table.
 * 
 */
@Entity
@NamedQueries({
				@NamedQuery (
							name = "Balancestatus.getName",
							query = "select b from Balancestatus b where b.statusName = :status"
						    ),
				@NamedQuery (
							name = "Balancestatus.getStatusByID",
							query = "select b from Balancestatus b where b.id = :id"
						    )		    
})
public class Balancestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String statusName;

	public Balancestatus() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "Balancestatus [id=" + id + ", statusName=" + statusName + "]";
	}

}