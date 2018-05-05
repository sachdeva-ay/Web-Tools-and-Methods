package com.hotelbooking.pojo;




import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_tbl")
public class Reseravtion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reservationID", unique=true, nullable = false)
	private int reservation_id;

	@ManyToOne
	@JoinColumn(name ="roomID")
	private Room room_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")
	private User user_id;
	
	@Column(name = "reservation_Status")
	private String reservation_status;
	
	@OneToOne(mappedBy="reservation")
	private Payment_Detail payment_id;
	
	private String checkIn;
	private String checkOut;
	
	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Reseravtion() {
		super();
	}

	public int getReservation_id() {
		return reservation_id;
	}
	
	

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}


	public Room getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Room room_id) {
		this.room_id = room_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}
	
	
}
