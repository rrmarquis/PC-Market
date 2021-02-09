package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followed_motherboard")
public class Followed_Motherboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="expansion_slots")
	private String expansionSlots;
	
	@Column(name = "socket")
	private String socket;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "follower_id")
	private Integer followerID;
	
	@Column(name = "listing_id")
	private Integer listingID;
	
	public Followed_Motherboard() {
	}
	
	public Followed_Motherboard(String expansionSlots, String socket, String price, Integer followerID) {
		this.expansionSlots = expansionSlots;
		this.socket = socket;
		this.price = price;
		this.followerID = followerID;
		this.listingID = 0;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getExpansionSlots() {
		return expansionSlots;
	}
	
	public String getSocket() {
		return socket;
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
