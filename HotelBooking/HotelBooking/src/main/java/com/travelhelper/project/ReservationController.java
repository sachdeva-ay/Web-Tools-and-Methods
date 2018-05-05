package com.travelhelper.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.dao.HotelDao;
import com.hotelbooking.dao.ReservationDAO;
import com.travelhelper.pojo.Hotel;
import com.travelhelper.pojo.Reseravtion;
import com.travelhelper.pojo.Room;
import com.travelhelper.pojo.RoomRates;

public class ReservationController {

	@Autowired
	HotelDao hoteldao;
	
	
	
	
}
