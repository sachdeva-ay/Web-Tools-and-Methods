package com.travelhelper.pojo;



import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rate_tbl")
public class Rate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "rateID", unique=true, nullable = false)
	private int rate_id;
	
	@ManyToMany(mappedBy="rates")
	private Set<Room> room = new HashSet<Room>();
	
	@Column(name="rate_Name")
	private String rate_name;
	
	@Column(name="date_From")
	private Date date_from;
	
	@Column(name="date_To")
	private Date date_to;
	
	@Column(name="price")
	private int price;
	
	public Rate() {
		super();
	}

	public int getRate_id() {
		return rate_id;
	}

	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
	}

	public String getRate_name() {
		return rate_name;
	}

	public void setRate_name(String rate_name) {
		this.rate_name = rate_name;
	}

	public Date getDate_from() {
		return date_from;
	}

	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}

	public Date getDate_to() {
		return date_to;
	}

	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<Room> getRoom() {
		return room;
	}

	public void setRoom(Set<Room> room) {
		this.room = room;
	}
	
	@Override 
	public String toString(){
		return rate_name;
	}
	
	
}
