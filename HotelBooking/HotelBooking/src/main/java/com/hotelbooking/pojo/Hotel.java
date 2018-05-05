package com.hotelbooking.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "hotel_tbl")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "hotelID", unique=true, nullable = false)
	private int hotel_id;
	
	@Column(name = "hotel_Name")
	private String hotel_name;
	
	@Column(name = "hotel_Address")
	private String hotel_address;
	
	@Column(name = "hotel_Zipcode")
	private String hotel_zipcode;
	
	@Column(name = "hotel_City")
	private String hotel_city;
	
	@Column(name = "hotel_Country")
	private String hotel_country;
	
	@Column(name = "hotel_Url")
	private String hotel_url;
	
	@Column(name = "hotel_Description")
	private String hotel_description;
	
	@Column(name = "hotel_Location")
	private String hotel_location;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="hotel")  
	private Set<Room> rooms = new HashSet<Room>(); 
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="hotel")  
	private Set<Hotel_Photos> photos = new HashSet<Hotel_Photos>();
	
	@Transient
	private Set<CommonsMultipartFile> photo = new HashSet<CommonsMultipartFile>();
	
public Hotel() {
	super();
}

public int getHotel_id() {
	return hotel_id;
}

public void setHotel_id(int hotel_id) {
	this.hotel_id = hotel_id;
}

public String getHotel_name() {
	return hotel_name;
}

public void setHotel_name(String hotel_name) {
	this.hotel_name = hotel_name;
}

public String getHotel_address() {
	return hotel_address;
}

public void setHotel_address(String hotel_address) {
	this.hotel_address = hotel_address;
}

public String getHotel_zipcode() {
	return hotel_zipcode;
}

public void setHotel_zipcode(String hotel_zipcode) {
	this.hotel_zipcode = hotel_zipcode;
}

public String getHotel_city() {
	return hotel_city;
}

public void setHotel_city(String hotel_city) {
	this.hotel_city = hotel_city;
}

public String getHotel_country() {
	return hotel_country;
}

public void setHotel_country(String hotel_country) {
	this.hotel_country = hotel_country;
}

public String getHotel_url() {
	return hotel_url;
}

public void setHotel_url(String hotel_url) {
	this.hotel_url = hotel_url;
}

public String getHotel_description() {
	return hotel_description;
}

public void setHotel_description(String hotel_description) {
	this.hotel_description = hotel_description;
}

public String getHotel_location() {
	return hotel_location;
}

public void setHotel_location(String hotel_location) {
	this.hotel_location = hotel_location;
}

public Set<Room> getRooms() {
	return rooms;
}

public void setRooms(Set<Room> rooms) {
	this.rooms = rooms;
}

public Set<Hotel_Photos> getPhotos() {
	return photos;
}

public void setPhotos(Set<Hotel_Photos> photos) {
	this.photos = photos;
}

public Set<CommonsMultipartFile> getPhoto() {
	return photo;
}

public void setPhoto(Set<CommonsMultipartFile> photo) {
	this.photo = photo;
}


@Override
public String toString(){
	return hotel_name;
	
}

}
