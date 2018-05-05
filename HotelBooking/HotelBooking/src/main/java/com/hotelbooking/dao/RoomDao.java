package com.hotelbooking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Room;



public class RoomDao extends DAO{

public Room addRoom(Room room) throws Exception{
	try {
		begin();
		System.out.println("inside RoomDAO");
		getSession().save(room);
		commit();
		return room;
	} catch (Exception e) {
		rollback();
		throw new Exception("Exception while creating user: " + e.getMessage());
	}
}

public Room updateRoom(Room room) throws Exception{
	try {
		begin();
		System.out.println("inside RoomDAO");
		getSession().update(room);
		commit();
		return room;
	} catch (Exception e) {
		rollback();
		throw new Exception("Exception while creating user: " + e.getMessage());
	}
}
public List<Object[]> list(String hotel) throws Exception {
    try {
        begin();
        Query q = getSession().createQuery("SELECT room_Type FROM hotelbooking.room_tbl "
        		+ "where hotelID = :hotel");
        List<Object[]> list = q.list();
        commit();
        return list;
    } catch (HibernateException e) {
        rollback();
        throw new Exception("Could not list the Rooms", e);
    }
}

public Room getRoom(String roomID) throws Exception {
    try {
        begin();
        Query q = getSession().createQuery("from Room where roomID= :roomID");
        q.setString("roomID",roomID);
        Room room = (Room)q.uniqueResult();
        commit();
        return room;
    } catch (HibernateException e) {
        rollback();
        throw new Exception("Could not list the Room", e);
    }
}
}
