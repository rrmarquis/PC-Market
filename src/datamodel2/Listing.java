package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listing")
public class Listing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
		
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "part_type")
	private String part_Type;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "sellerID")
	private Integer sellerID;

	public Listing() {
	}

	public Listing(String modelNa,
						String partTy,
						String price,
						Integer sellerID) {
		this.modelName = modelNa;
		this.part_Type = partTy;
		this.price = price;
		this.sellerID = sellerID;
	}
	
	public Integer getID() {
		return id; 
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelNa) {
		this.modelName = modelNa;
	}
	
	public String getPartType() {
		return part_Type;
	}
	
	public void setPartType(String partTy) {
		this.part_Type = partTy;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Integer getSellerID() {
		return sellerID;
	}
	
	@Override
	public String toString() {
		return "Listing:" + this.id + ", " + 
				this.modelName + ", " +  this.part_Type  + ", " + 
				this.price;
	}
}
