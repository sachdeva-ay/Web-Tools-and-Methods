package com.hotelbooking.controller;

import java.util.*;
import javax.servlet.jsp.jstl.sql.Result;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.dao.HotelDao;
import com.hotelbooking.dao.PhotosDao;
import com.hotelbooking.dao.ReservationDAO;
import com.hotelbooking.dao.RoomDao;
import com.hotelbooking.dao.UserDao;
import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Hotel_Photos_Object;
import com.hotelbooking.pojo.Rate;
import com.hotelbooking.pojo.Reseravtion;
import com.hotelbooking.pojo.Room;
import com.hotelbooking.pojo.RoomRates;
import com.hotelbooking.pojo.User;

@Controller

public class HomeController {

	@Autowired
	HotelDao hoteldao;
	
	@Autowired
	PhotosDao photosdao;

	@Autowired
	RoomDao roomdao;
	
	@Autowired
	UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {	
		return "login";
	}
	
	@RequestMapping(value = "/admin-dashboard.htm", method = RequestMethod.GET)
	public String adminhome(Locale locale, Model model) throws Exception {	
		return "admin-dashboard";
	}
	
	@RequestMapping(value = "/bookHotel.htm*", method = RequestMethod.GET)
	private ModelAndView bookHotel(HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String hotel=request.getParameter("hotel");
		String dateFrom=request.getParameter("dateFrom");//checkin
		String dateTo=request.getParameter("dateTo");//checkout
		String price=request.getParameter("hotelrate");//price

		
		String roomid=request.getParameter("roomid");
		Room  rid=roomdao.getRoom(roomid);//roomid
		
		
		
		Integer userid=(Integer) request.getSession().getAttribute("userid");
		User  uid=userDao.getUser(userid);//userid
		
		System.out.println(rid);
		System.out.println(request.getParameter("hotel"));
		//System.out.println(request.getSession().getAttribute("userid"));
		System.out.println(dateFrom);
		System.out.println(uid.getFirst_name() + uid.getLast_name());
		
		mv.addObject("price", price);
		mv.addObject("dateFrom", dateFrom);
		mv.addObject("dateTo", dateTo);
		mv.addObject("hotel", hotel);
		mv.addObject("rid", rid);
		mv.addObject("roomtype", rid.getRoom_type());
		mv.addObject("userid", uid);
		mv.addObject("username", uid.getFirst_name() + uid.getLast_name());
		mv.addObject("reserve", new Reseravtion());
		mv.setViewName("roomselection");

		return mv;
	}
	
	@RequestMapping(value = "/searchresult.htm", method = RequestMethod.GET)
	private ModelAndView booking(HttpServletRequest request, @ModelAttribute("reserve") Reseravtion reserve,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return new ModelAndView("home", "reserve", reserve);
		}

		try {

			System.out.print("NewBooking");
				
			
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String checkin=request.getParameter("dateFrom");
			
				String hotel=request.getParameter("hotel");
				String checkout=request.getParameter("dateTo");
				
				String roomid=request.getParameter("roomid");
				Room  rid=roomdao.getRoom(roomid);//roomid
				
				Integer userid=(Integer) request.getSession().getAttribute("userid");
				User  uid=userDao.getUser(userid);//userid
				
				reserve.setRoom_id(rid);
				reserve.setUser_id(uid);
				reserve.setCheckIn(checkin);
				reserve.setReservation_status("confirmed");
				reserve.setCheckOut(checkout);
				
			    Reseravtion r=hoteldao.booking(reserve);
			    request.getSession().setAttribute("reserveid", reserve.getReservation_id());
			    ModelAndView mv=new ModelAndView();
			    mv.addObject("reservationid", r.getReservation_id());
			    mv.addObject("hotelname", hotel);
			    mv.addObject("dateFrom", checkin);
				mv.addObject("dateTo", checkout);
			    mv.setViewName("bookingconfirmed");
			    return mv;

		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
			
	}
	
	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	private ModelAndView getSearchResult(HttpServletRequest request) throws Exception {
		System.out.println(request.getParameter("keywordHotel"));
		System.out.println(request.getParameter("keywordCity"));
		System.out.println(request.getParameter("dateFrom"));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		//HttpSession session = (HttpSession) request.getSession();
		
		String hotel = request.getParameter("keywordHotel");
		String city = request.getParameter("keywordCity");
		Date dateto = formatter.parse(request.getParameter("dateTo"));
		Date datefrom = formatter.parse(request.getParameter("dateFrom"));
		System.out.print(datefrom);
		List<Object[]> rs= hoteldao.listSearch(hotel, city, datefrom, dateto);
		
		//ModelAndView mv= new ModelAndView();
		
		request.setAttribute("dateTo", dateto);
		request.setAttribute("dateFrom", datefrom);
		
		return new ModelAndView("search-Result","searchedHotel", rs) ;
	}
}
