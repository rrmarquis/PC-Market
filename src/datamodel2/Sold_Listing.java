package datamodel2;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_listing")
public class Sold_Listing {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "part_type")
	private String partType;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "date_sold")
	private String dateSold;
	
	@Column(name = "seller_id")
	private Integer sellerID;
	
	@Column(name = "buyer_id")
	private Integer buyerID;
	
	public Sold_Listing() {
		
	}
	
	public Sold_Listing(Integer id, String partType, String modelName, String price, String dateSold, Integer sellerID, Integer buyerID) {
		this.id = id;
		this.partType = partType;
		this.modelName = modelName;
		this.price = price;
		this.dateSold = dateSold;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getPartType() {
		return partType;
	}
	
	public String getModelName() {
		return modelName;
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
