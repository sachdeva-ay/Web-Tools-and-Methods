package com.hotelbooking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotelbooking.pojo.Hotel_Photos;

public class PhotosDao extends DAO{

	public List<Object> getPhotos(Integer hotelID) throws Exception{
		
		try {
			begin();
			System.out.println("inside Hotel_PhotosDAO");
			 Query q = getSession().createSQLQuery("SELECT file_Name FROM travelhelper.hotel_photos_tbl where hotelID = :hotelID");
			 q.setInteger("hotelID", hotelID);
			 List<Object> photos = q.list();
			 commit();
			 return photos;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
}
