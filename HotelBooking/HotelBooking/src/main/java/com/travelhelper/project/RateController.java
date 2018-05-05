package com.travelhelper.project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import com.travelhelper.pojo.Rate;
import com.travelhelper.pojo.Room;
import com.travelhelper.pojo.RoomRates;

@Controller
public class RateController {

	@Autowired
	HotelDao hoteldao;

	@Autowired
	RoomDao roomdao;

	@Autowired
	RateDao ratedao;

	@RequestMapping(value = "/setRate.htm", method = RequestMethod.GET)
	private ModelAndView getAllHotel() throws Exception {

		return new ModelAndView("set-Hotel-rates", "hotellist", hoteldao.list());
	}

	@RequestMapping(value = "/setRate1.htm*", method = RequestMethod.GET)
	private ModelAndView getHotel(HttpServletRequest request) throws Exception {

		// System.out.println(request.getParameter("hotel"));
		// Hotel hotel = hoteldao.get(request.getParameter("hotel"));

		// Set<Room> roomList = hotel.getRooms();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotel", request.getParameter("hotel"));
		mv.addObject("roomRates", new RoomRates());
		mv.addObject("rates", ratedao.list());
		mv.setViewName("set-rates");

		return mv;
	}

	@RequestMapping(value = "/setRoomRate.htm*", method = RequestMethod.POST)
	private String setRates(HttpServletRequest request, @ModelAttribute("roomRates") RoomRates roomRate,
			BindingResult result) throws Exception {

		System.out.println("Inside room rate");
		System.out.println(request.getParameter("room_type"));
		System.out.println(request.getParameter("rate"));
		System.out.println(request.getParameter("hotel"));

		String roomType = request.getParameter("room_type");
		String rateName = request.getParameter("rate");
		Hotel hotel = hoteldao.get(request.getParameter("hotel"));
		Set<Room> roomList = hotel.getRooms();

		Set<Room> sortedRooms = new HashSet<Room>();

		Iterator it = roomList.iterator();

		while (it.hasNext()) {
			Room room = (Room) it.next();
			System.out.println("Object Room type= " + room.getRoom_type());
			System.out.println("request parameter= " + roomType);
			if (room.getRoom_type().equalsIgnoreCase(roomType)) {
				sortedRooms.add(room);
			}
		}

		Rate rate = ratedao.getRate(rateName);
		Set<Room> setRoom = rate.getRoom();

		Iterator srtRoom = sortedRooms.iterator();

		while (srtRoom.hasNext()) {
			Room room = (Room) srtRoom.next();
			Set<Rate> setRate = room.getRates();
			setRate.add(rate);
			setRoom.add(room);
			roomdao.updateRoom(room);
		}

		// Set<Room> roomList = Set<Room> request.getAttribute("roomList");
		return "admin-dashboard";
	}
}
