package datamodel2;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ram")
public class RAM {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "type")
	private String type;

	@Column(name = "capacity")
	private String capacity;

	@Column(name = "speed")
	private String speed;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "seller_id")
	private Integer sellerID;

	public RAM() {
	}

	public RAM(Integer id, 
			   String modelNa, 
			   String type, 
			   String capacity, String speed, 
			   String price, 
			   Integer sellerID) {
		this.id = id;
		this.modelName = modelNa;
		this.type = type;
		this.capacity = capacity;
		this.speed = speed;
		this.price = price;
		this.sellerID = sellerID;
	}

	public Integer getId() {
		return id;
	}

	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelNa) {
		this.modelName = modelNa;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
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
		return "RAM(s):" + this.id + ", " + 
			   this.modelName + ", " +  this.type + ", " + 
			   this.capacity + ", " + this.speed + ", " + 
			   this.price;
	}
}
