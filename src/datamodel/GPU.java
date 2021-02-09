package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GPU")
public class GPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Model_Name")
	private String modelName; 
	
	@Column(name = "Port_Type")
	private String portType;
	
	@Column(name = "Interface_Type")
	private String interfaceType;
	
	@Column(name = "Memory_Size")
	private String memorySize;
	
	@Column(name = "Price")
	private String price;
	
	public GPU() {
	}
	
	public GPU(Integer id, 
			   String manufacturer, 
			   String modelNa, 
			   String port, 
			   String interf, 
			   String memory, 
			   String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.portType = port;
		this.interfaceType = interf;
		this.memorySize = memory;
		this.price = price;
	}
	
	public GPU(String manufacturer, 
			   String modelNa, 
			   String port, 
			   String interf, 
			   String memory, 
			   String price) {
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.portType = port;
		this.interfaceType = interf;
		this.memorySize = memory;
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
	
	public String getPortType() {
		return portType;
	}
	
	public void setPortType(String port) {
		this.portType = port;
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
	
	@Override
	public String toString() {
		return "GPU:" + this.id + ", " + this.manufacturer + ", " +
			   this.modelName + ", " + this.portType + ", " +
			   this.interfaceType + ", " + this.memorySize + ", " + 
			   this.price;
	}
}