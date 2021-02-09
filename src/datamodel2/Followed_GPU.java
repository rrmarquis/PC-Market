package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followed_gpu")
public class Followed_GPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "clock_speed")
	private String clockSpeed;
	
	@Column(name = "interf")
	private String interf;
	
	@Column(name = "memory")
	private String memory;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "follower_id")
	private Integer followerID;
	
	@Column(name = "listing_id")
	private Integer listingID;
	
	public Followed_GPU() {
	}
	
	public Followed_GPU(String clockSpeed, String interf, String memory, String price, Integer followerID) {
		this.clockSpeed = clockSpeed;
		this.interf = interf;
		this.memory = memory;
		this.price = price;
		this.followerID = followerID;
		this.listingID = 0;
	}

	public Integer getID() {
		return id;
	}
	
	public String getClockSpeed() {
		return clockSpeed;
	}
	
	public String getInterf() {
		return interf;
	}
	
	public String getMemory() {
		return memory;
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
