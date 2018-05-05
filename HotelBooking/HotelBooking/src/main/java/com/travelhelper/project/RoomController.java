package com.travelhelper.project;


import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.dao.HotelDao;
import com.hotelbooking.dao.RateDao;
import com.hotelbooking.dao.RoomDao;
import com.travelhelper.pojo.Hotel;
import com.travelhelper.pojo.Room;

@Controller
public class RoomController {
	
	@Autowired
	HotelDao hoteldao;
	
	@Autowired
	RoomDao roomdao;
	
	@Autowired
	RateDao ratedao;
	

	@RequestMapping(value = "/room.htm", method = RequestMethod.GET)
	private ModelAndView getAllHotel() throws Exception {
		
/*	List<String> roomType = new List<String>();
		roomType.add("Regular");
		roomType.add("Delux");
		roomType.add("Suite");
		*/
	
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotellist", hoteldao.list());
		mv.addObject("room", new Room());
		mv.setViewName("room-form");
		
		return mv;
	}
	
	@RequestMapping(value = "/addroom.htm", method = RequestMethod.POST)
	private String addRoom(@ModelAttribute("room") Room room, BindingResult result) throws Exception {
		
		try {	

			Hotel hotel =hoteldao.get(room.getHotel().getHotel_name());
			room.setHotel(hotel);
			roomdao.addRoom(room);
								
			return "admin-dashboard";

		} catch (Exception e) {
			System.out.print("registerNewUser" + e);
			return "error";
		}
	}
}
