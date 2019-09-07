package ua.lviv.lgs.basic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Magazine {
	
	private int id; 
    private String title;
    private String category;
    private double price;
	private LocalDate publish_date;
	
	public Magazine(int id, String title, String category, double price, LocalDate publish_date) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publish_date = publish_date;
	}

	public Magazine(String title, String category, double price, LocalDate publish_date) {
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

	public LocalDate getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
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
		LocalDate publish_date = result.getDate("publish_date").toLocalDate();
		
		return new Magazine(id,title,category,price,publish_date);
	}
	
}
