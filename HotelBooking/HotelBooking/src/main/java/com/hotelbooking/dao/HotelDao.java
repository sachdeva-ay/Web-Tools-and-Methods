package com.hotelbooking.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Hotel_Photos;
import com.hotelbooking.pojo.Reseravtion;

public class HotelDao extends DAO{
	
	public HotelDao() {
	}
	
	public Hotel registerHotel(){
		return null;
		
	}
	
    public List<Hotel> list() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Hotel");
            List<Hotel> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the Hotels", e);
        }
    }
    
    public Hotel get(String hotel_name) throws Exception{
    	try{begin();
    	Query q = getSession().createQuery("from Hotel where hotel_name= :name");
    	 q.setString("name",hotel_name);
    	 Hotel hotel = (Hotel)q.uniqueResult();
    	 commit();
		return hotel;
    	}
    	catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the Hotels", e);
        }
    }
	
	public Hotel registerHotel(Hotel hotel) throws Exception{
		try {
			begin();
			System.out.println("inside HotelDAO");
			getSession().save(hotel);
			commit();
			return hotel;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	public Reseravtion booking(Reseravtion reserve) throws Exception{
		try {
			begin();
			System.out.println("inside HotelDAO");
			getSession().save(reserve);
			commit();
			return reserve;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating booking: " + e.getMessage());
		}
	}
	public Hotel_Photos registerPhotos(Hotel_Photos hotel_photos) throws Exception{
		
		try {
			begin();
			System.out.println("inside Hotel_PhotosDAO");
			getSession().save(hotel_photos);
			commit();
			return hotel_photos;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
    public List<Object[]> listSearch(String hotel, String city, Date dateFrom, Date dateTo) throws Exception {
        try {

        	begin();
        	Query q ;
        	
        	if(hotel=="" && city==""){
        		System.out.println("inside Hotel_all");
           // Query q = getSession().createQuery("from Hotel where hotel_name= :hotel_name or hotel_city= :city or hotel_country= :country");
             q = getSession().createSQLQuery("SELECT hotel_tbl.hotelID, hotel_Name, "
            		+ "file_Name, price, room_type, room_tbl.roomID, COUNT(roomID) FROM hotelbooking.hotel_photos_tbl, "
            		+ "hotelbooking.hotel_tbl, hotelbooking.rate_tbl, hotelbooking.room_tbl "
            		+ "where hotel_tbl.hotelID = room_tbl.hotelID "
            		+ "and hotel_tbl.hotelID = hotel_photos_tbl.hotelID "
            		+ "and room_tbl.roomID = rate_tbl.rateID "
            		+ "and rate_tbl.date_To >= :dateTo "
            		+ "and rate_tbl.date_From <= :dateFrom "
            		+ "and room_tbl.roomID NOT IN "
            		+ "(SELECT roomID FROM hotelbooking.reservation_tbl "
            		+ "where checkIn = :dateFrom and checkOut = :dateTo) ;"); 
             
             q.setDate("dateTo", dateTo);
             q.setDate("dateFrom", dateFrom);
             //q.setString("price", price)
             }
        	else if(city!=""){
        		System.out.println("inside Hotel_all");
                // Query q = getSession().createQuery("from Hotel where hotel_name= :hotel_name or hotel_city= :city or hotel_country= :country");
                  q = getSession().createSQLQuery("SELECT hotel_tbl.hotelID, hotel_Name, "
                 		+ "file_Name, price, room_type, room_tbl.roomID, COUNT(roomID) FROM hotelbooking.hotel_photos_tbl, "
                 		+ "hotelbooking.hotel_tbl, hotelbooking.rate_tbl, hotelbooking.room_tbl "
                 		+ "where hotel_tbl.hotelID = room_tbl.hotelID "
                 		+ "and hotel_tbl.hotelID = hotel_photos_tbl.hotelID "
                 		+ "and room_tbl.roomID = rate_tbl.rateID "
                 		+ "and rate_tbl.date_To >= :dateTo "
                 		+ "and hotel_tbl.hotel_City = :city "
                 		+ "and rate_tbl.date_From <= :dateFrom "
                 		+ "and room_tbl.roomID NOT IN "
                 		+ "(SELECT roomID FROM hotelbooking.reservation_tbl "
                 		+ "where checkIn = :dateFrom and checkOut = :dateTo) ;"); 
                  
                  q.setString("city", city);
                  q.setDate("dateTo", dateTo);
                  q.setDate("dateFrom", dateFrom);
                  //q.setString("price", price)
                  }
        	
        	else{
        		q = getSession().createSQLQuery("SELECT hotel_tbl.hotelID, hotel_Name, "
                		+ "file_Name, price, room_type, room_tbl.roomID, COUNT(roomID) FROM hotelbooking.hotel_photos_tbl, "
                		+ "hotelbooking.hotel_tbl, hotelbooking.rate_tbl, hotelbooking.room_tbl "
                		+ "where hotel_tbl.hotelID = room_tbl.hotelID "
                		+ "and hotel_tbl.hotelID = hotel_photos_tbl.hotelID "
                		+ "and room_tbl.roomID = rate_tbl.rateID "
                		+ "and rate_tbl.date_To >= :dateTo "
                		+ "and hotel_name = :hotel "
                		+ "and rate_tbl.date_From <= :dateFrom "
                		+ "and room_tbl.roomID NOT IN "
                		+ "(SELECT roomID FROM hotelbooking.reservation_tbl "
                		+ "where checkIn = :dateFrom and checkOut = :dateTo) ;");
        	
        		q.setString("hotel", hotel);
                q.setDate("dateTo", dateTo);
                q.setDate("dateFrom", dateFrom);
        	}
/*            q.setString("hotel_name", hotel);
            q.setString("city", city);
            q.setString("country", city);*/
            
            //q.setString("hotel", hotel);
            
        	List<Object[]> result = q.list();
        
            commit();
            return result;
        } catch (HibernateException e) { 
            rollback();
            throw new Exception("Could not list the Hotels", e);
        }
    }
}
