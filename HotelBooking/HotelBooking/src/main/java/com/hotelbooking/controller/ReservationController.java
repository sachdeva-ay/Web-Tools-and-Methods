package com.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.dao.HotelDao;
import com.hotelbooking.dao.ReservationDAO;
import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Reseravtion;
import com.hotelbooking.pojo.Room;
import com.hotelbooking.pojo.RoomRates;

public class ReservationController {

	@Autowired
	HotelDao hoteldao;
	
	
	
	
}
