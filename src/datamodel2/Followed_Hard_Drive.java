package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followed_hard_drive")
public class Followed_Hard_Drive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="rpm")
	private String rpm;
	
	@Column(name = "storage")
	private String storage;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "follower_id")
	private Integer followerID;
	
	@Column(name = "listing_id")
	private Integer listingID;
	
	public Followed_Hard_Drive() {
	}
	
	public Followed_Hard_Drive(String rpm, String storage, String price, Integer followerID) {
		this.rpm = rpm;
		this.storage = storage;
		this.price = price;
		this.followerID = followerID;
		this.listingID = 0;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getRPM() {
		return rpm;
	}
	
	public String getStorage() {
		return storage;
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
