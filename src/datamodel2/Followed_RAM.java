package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followed_ram")
public class Followed_RAM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "capacity")
	private String capacity;
	
	@Column(name = "speed")
	private String speed;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "follower_id")
	private Integer followerID;
	
	@Column(name = "listing_id")
	private Integer listingID;
	
	public Followed_RAM() {
	}
	
	public Followed_RAM(String type, String capacity, String speed, String price, Integer followerID) {
		this.type = type;
		this.capacity = capacity;
		this.speed = speed;
		this.price = price;
		this.followerID = followerID;
		this.listingID = 0;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public String getPrice() {
		return price;
	}
	
	public Integer getFollowerID() {
		return followerID;
	}
	
	public Integer getListingID() {
		return listingID;
	}
}
