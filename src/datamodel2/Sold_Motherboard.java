package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_motherboard")
public class Sold_Motherboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="expansion_slots")
	private String expansionSlots;
	
	@Column(name = "socket")
	private String socket;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "date_sold")
	private String dateSold;
	
	@Column(name = "sellerID")
	private Integer sellerID;
	
	@Column(name = "buyerID")
	private Integer buyerID;
	
	public Sold_Motherboard() {
	}
	
	public Sold_Motherboard(String expansionSlots, String socket, String price, String dateSold, Integer sellerID, Integer buyerID) {
		this.expansionSlots = expansionSlots;
		this.socket = socket;
		this.price = price;
		this.dateSold = dateSold;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
	}
	
	public String getExpansionSlots() {
		return expansionSlots;
	}
	
	public String getSocket() {
		return socket;
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
