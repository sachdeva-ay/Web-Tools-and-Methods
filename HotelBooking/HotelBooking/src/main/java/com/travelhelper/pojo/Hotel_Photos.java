package com.travelhelper.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "hotel_photos_tbl")
public class Hotel_Photos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "photoID", unique=true, nullable = false)
	private int photo_id;

	
	@Column(name = "file_Name")
	private String file_name;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="hotelID")
	private Hotel hotel;
	
	public Hotel_Photos() {
		super();
	}

	public Hotel_Photos(String file_name){
		super();
		this.file_name = file_name;
	}
	

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	
	
}
