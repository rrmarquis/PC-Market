package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hard_Drive")
public class Hard_Drive {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Model_Name")
	private String modelName; 

	@Column(name = "Storage_Space")
	private String storageSpace;

	@Column(name = "Rotations_Per_Minute")
	private String rotationsPerMinute;
	
	@Column(name = "Price")
	private String price;

	public Hard_Drive() {
	}

	public Hard_Drive(Integer id, 
					  String manufacturer, 
					  String modelNa, 
					  String storage, 
					  String rpm, 
					  String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.storageSpace = storage;
		this.rotationsPerMinute = rpm;
		this.price = price;
	}

	public Hard_Drive(String manufacturer, 
					  String modelNa, 
					  String storage, 
					  String rpm, 
					  String price) {
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.storageSpace = storage;
		this.rotationsPerMinute = rpm;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelNa) {
		this.modelName = modelNa;
	}
	
	public String getStorageSpace() {
		return storageSpace;
	}

	public void setStorageSpace(String storage) {
		this.storageSpace = storage;
	}

	public String getRotationsPerMinute() {
		return rotationsPerMinute;
	}

	public void setRotationsPerMinute(String rpm) {
		this.rotationsPerMinute = rpm;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hard Drive:" + this.id + ", " + this.manufacturer + ", " +
				this.modelName + ", " + this.storageSpace + ", " + 
				this.rotationsPerMinute + ", " + this.price;
	}
}