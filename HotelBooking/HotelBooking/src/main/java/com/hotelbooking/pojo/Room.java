package com.hotelbooking.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.velocity.runtime.directive.Parse;

@Entity
@Table(name = "room_tbl")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "roomID", unique=true, nullable = false)
	private int room_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hotelID")
	private Hotel hotel;
	
	@Column(name = "room_Number")
	private int room_number;
	
	@Column(name = "room_Type")
	private String room_type;
	
	@Column(name = "room_Amenities")
	private String amenities;
	
	
	@ManyToMany
    @JoinTable (
       name="Room_Rate_table",                                 
       joinColumns = {@JoinColumn(name="roomID", nullable = false, updatable = false)},
       inverseJoinColumns = {@JoinColumn(name="rateID" )}
    )
	private Set<Rate> rates = new HashSet<Rate>();
	
	public Room() {
		super();
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Set<Rate> getRates() {
		return rates;
	}
	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}

	@Override
	public String toString(){
		return String.valueOf(room_number);
	}
}
