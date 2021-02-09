package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Motherboard")
public class Motherboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Model_Name")
	private String modelName; 
	
	@Column(name = "Socket_Type")
	private String socketType;
	
	@Column(name = "Expansion_Slots")
	private String expansionSlots;
	
	@Column(name = "Form_Factor")
	private String formFactor;
	
	@Column(name = "Price")
	private String price;
	
	public Motherboard() {
	}
	
	public Motherboard(Integer id, 
					   String manufacturer, 
					   String modelNa, 
					   String socket, 
					   String expansion, 
					   String form, 
					   String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.socketType = socket;
		this.expansionSlots = expansion;
		this.formFactor = form;
		this.price = price;
	}
	
	public Motherboard(String manufacturer, 
					   String modelNa, 
					   String socket, 
					   String expansion, 
					   String form, 
					   String price) {
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.socketType = socket;
		this.expansionSlots = expansion;
		this.formFactor = form;
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
	
	public String getSocket() {
		return socketType;
	}
	
	public void setSocket(String socket) {
		this.socketType = socket;
	}
	
	public String getExpansionSlots() {
		return expansionSlots;
	}
	
	public void setExpansionSlots(String expansion) {
		this.expansionSlots = expansion;
	}
	
	public String getFormFactor() {
		return formFactor;
	}
	
	public void setFormFactor(String form) {
		this.formFactor = form;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Motherboard:" + this.id + ", " + this.manufacturer + ", " +
			   this.modelName + ", " + this.socketType + ", " + 
			   this.expansionSlots + ", " + this.formFactor + ", " + this.price;
	}
}