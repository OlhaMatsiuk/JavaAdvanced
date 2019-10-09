package logos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bucket")
public class Bucket {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "magazine_id", referencedColumnName = "id")
	private Magazine magazine;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;

	public Bucket() {}
	
	public Bucket(int id, User user, Magazine magazine, Date purchaseDate) {
		this.id = id;
		this.user = user;
		this.magazine = magazine;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(Integer userId, Integer productId, Date purchaseDate) {
		this.id = id;
		this.user = user;
		this.magazine = magazine;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user.getId();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getMagazine() {
		return magazine.getId();
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Bucket other = (Bucket) obj;
		if (id != other.id)
			return false;
		if (magazine == null) {
			if (other.magazine != null)
				return false;
		} else if (!magazine.equals(other.magazine))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", magazine=" + magazine + ", purchaseDate=" + purchaseDate
				+ "]";
	}

}
