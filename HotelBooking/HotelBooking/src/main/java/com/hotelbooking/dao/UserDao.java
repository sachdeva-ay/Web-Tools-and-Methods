package com.hotelbooking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotelbooking.pojo.User;

public class UserDao extends DAO{

	public UserDao() {
	}
	
	public User getCustomer(String username, String password) throws Exception {
		try {
			begin();
			//String r="customer";
			Query q = getSession().createQuery("from User where userName = :username and password = :password and role = 'customer' ");
			q.setString("username", username);
			q.setString("password", password);
			//q.setString("role", r);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}
	
	public User getUser(Integer userID) throws Exception {
		try {
			begin();
			//String r="customer";
			Query q = getSession().createQuery("from User where userID = :userID");
			q.setInteger("userID", userID);
			//System.out.println("user_id");
			System.out.println(userID);
			//q.setString("role", r);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + userID, e);
		}
	}
	
	public User getAdmin(String username, String password) throws Exception {
		try {
			begin();
			//String r="admin";
			Query q = getSession().createQuery("from User where userName = :username and password = :password and role = 'admin' ");
			q.setString("username", username);
			q.setString("password", password);
			//q.setString("role", r);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}
	
	public User register(User u) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(u);
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(User user) throws Exception {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete user " + e.getMessage());
		}
	}
}
