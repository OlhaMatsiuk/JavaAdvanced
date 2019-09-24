package logos.domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Magazine {
	
	private int id; 
    private String title;
    private String category;
    private double price;
	private Date publish_date;
	
	public Magazine(int id, String title, String category, double price, Date publish_date) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publish_date = publish_date;
	}

	public Magazine(String title, String category, double price, Date publish_date) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.publish_date = publish_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publish_date == null) ? 0 : publish_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Magazine other = (Magazine) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publish_date == null) {
			if (other.publish_date != null)
				return false;
		} else if (!publish_date.equals(other.publish_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", title=" + title + ", category=" + category + ", price=" + price
				+ ", publish_date=" + publish_date + "]\n";
	}
	
	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String title = result.getString("title");
		String category = result.getString("category");
		int price = result.getInt("price");
		Date publish_date = new Date(result.getDate("start").getTime());
		
		return new Magazine(id,title,category,price,publish_date);
	}
	
}
