package datamodel2;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gpu")
public class GPU{
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "clock_speed")
	private String clockSpeed;
	
	@Column(name = "interf")
	private String interfaceType;
	
	@Column(name = "memory")
	private String memorySize;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "seller_id")
	private Integer sellerID;
	
	public GPU() {
	}
	
	public GPU(Integer id, 
			   String modelNa,
			   String clockSpeed,
			   String interf, 
			   String memory, 
			   String price,
			   Integer sellerID) {
		this.id = id;
		this.modelName = modelNa;
		this.clockSpeed = clockSpeed;
		this.interfaceType = interf;
		this.memorySize = memory;
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
	
	public String getClockSpeed() {
		return clockSpeed;
	}
	
	public void setClockSpeed(String clockSpeed) {
		this.clockSpeed = clockSpeed;
	}
	
	public String getInterfaceType() {
		return interfaceType;
	}
	
	public void setInterfaceType(String interf) {
		this.interfaceType = interf;
	}
	
	public String getMemorySize() {
		return memorySize;
	}
	
	public void setMemorySize(String memory) {
		this.memorySize = memory;
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
		return "GPU:" + this.id + ", " +
			   this.modelName + ", " + this.interfaceType + ", " + 
			   this.memorySize + ", " + this.price;
	}
}