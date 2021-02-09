package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_ram")
public class Sold_RAM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "capacity")
	private String capacity;
	
	@Column(name = "speed")
	private String speed;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "date_sold")
	private String dateSold;
	
	@Column(name = "sellerID")
	private Integer sellerID;
	
	@Column(name = "buyerID")
	private Integer buyerID;
	
	public Sold_RAM() {
	}
	
	public Sold_RAM(String type, String capacity, String speed, String price, String dateSold, Integer sellerID, Integer buyerID) {
		this.type = type;
		this.capacity = capacity;
		this.speed = speed;
		this.price = price;
		this.dateSold = dateSold;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public String getSpeed() {
		return speed;
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
