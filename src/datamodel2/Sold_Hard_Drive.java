package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_hard_drive")
public class Sold_Hard_Drive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="rpm")
	private String rpm;
	
	@Column(name = "storage")
	private String storage;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "date_sold")
	private String dateSold;
	
	@Column(name = "sellerID")
	private Integer sellerID;
	
	@Column(name = "buyerID")
	private Integer buyerID;
	
	public Sold_Hard_Drive() {
	}
	
	public Sold_Hard_Drive(String rpm, String storage, String price, String dateSold, Integer sellerID, Integer buyerID) {
		this.rpm = rpm;
		this.storage = storage;
		this.price = price;
		this.dateSold = dateSold;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
	}
	
	public String getRPM() {
		return rpm;
	}
	
	public String getStorage() {
		return storage;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getDateSold() {
		return dateSold;
	}
	
	public Integer getSellerID() {
		return sellerID;
	}
	
	public Integer getBuyerID() {
		return buyerID;
	}
}
