package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followed_cpu")
public class Followed_CPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "cores")
	private String cores;
	
	@Column(name = "socket")
	private String socket;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "follower_id")
	private Integer followerID;
	
	@Column(name = "listing_id")
	private Integer listingID;
	
	public Followed_CPU() {
	}
	
	public Followed_CPU(String frequency, String cores, String socket, String price, Integer followerID) {
		this.frequency = frequency;
		this.cores = cores;
		this.socket = socket;
		this.price = price;
		this.followerID = followerID;
		this.listingID = 0;
	}
	
	public Integer getID() {
		return id;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public String getCores() {
		return cores;
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
