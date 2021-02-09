package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "All_Listings")
public class All_Listings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
		
	@Column(name = "Model_Name")
	private String modelName; 
	
	@Column(name = "Part_Type")
	private String part_Type;
	
	@Column(name = "Price")
	private String price;

	public All_Listings() {
	}

	public All_Listings(Integer id,
						String modelNa,
						String partTy,
						String price) {
		this.id = id;
		this.modelName = modelNa;
		this.part_Type = partTy;
		this.price = price;
	}

	public All_Listings(String modelNa,
						String partTy,
						String price) {
		this.modelName = modelNa;
		this.part_Type = partTy;
		this.price = price;
	}
	
	public Integer getId() {
		return id; 
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "CPU(s):" + this.id + ", " + 
				this.modelName + ", " +  this.part_Type  + ", " + 
				this.price;
	}
}
