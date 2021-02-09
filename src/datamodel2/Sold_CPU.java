package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_cpu")
public class Sold_CPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "cores")
	private String cores;
	
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
	
	public Sold_CPU() {
	}
	
	public Sold_CPU(String frequency, String cores, String socket, String price, String dateSold, Integer sellerID, Integer buyerID) {
		this.frequency = frequency;
		this.cores = cores;
		this.socket = socket;
		this.price = price;
		this.dateSold = dateSold;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public String getCores() {
		return cores;
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
