package com.hotelbooking.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userID", unique=true, nullable = false)
	private int user_id;
	
	@Column(name="username", unique=true, nullable = false)
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "emailID")
	@NotNull
	private String Email_Id;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "firstName")
	@NotNull
	private String first_name;
	
	@Column(name = "lastName")
	@NotNull
	private String last_name;
	
	@Column(name = "phoneNumber")
	@NotNull
	private String phone_number;
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY,mappedBy="user_id")
	private Set<Reseravtion> reservations = new HashSet<Reseravtion>();
	
	
	public User() {
	
	}
	
	public User(String first_name, String last_name,String password, 
			String username, String role
			,String phone_number, String Email_Id) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.password= password;
		this.username=username;
		this.phone_number=phone_number;
		this.Email_Id=Email_Id;
		this.role=role;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public Set<Reseravtion> getReservations() {
		return reservations;
	}
	
	public void setReservations(Set<Reseravtion> reservations) {
		this.reservations = reservations;
	}
	
	/*@ManyToMany
    @JoinTable(name = "user_role", joinColumns =@JoinColumn(name = "user_id"), inverseJoinColumns = 
    @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/
	
	
}
