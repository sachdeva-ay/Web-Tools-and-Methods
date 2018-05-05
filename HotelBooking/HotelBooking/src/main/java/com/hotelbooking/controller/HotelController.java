package com.hotelbooking.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.dao.HotelDao;
import com.hotelbooking.dao.RateDao;
import com.hotelbooking.pojo.Hotel;
import com.hotelbooking.pojo.Hotel_Photos;
import com.hotelbooking.pojo.Rate;

@Controller
@SessionAttributes("user")
public class HotelController {

	@Autowired
	RateDao ratedao;

	@Autowired
	HotelDao hoteldao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	private String showDashboard() {

		return "admin-dashboard";
	}

	@RequestMapping(value = "/policy.htm", method = RequestMethod.GET)
	private ModelAndView getPolicyPage() {

		return new ModelAndView("addRates", "rate", new Rate());
	}

	@RequestMapping(value = "/AddPolicy.htm", method = RequestMethod.POST)
	protected ModelAndView addPolicy(HttpServletRequest request, @ModelAttribute("rate") Rate rate,
			BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", rate);
		}

		try {

			System.out.print("add policy");
			ratedao.register(rate);
			return new ModelAndView("admin-dashboard");

		} catch (Exception e) {
			System.out.print("registerNewUser" + e);
			return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/hotelManage.htm", method = RequestMethod.GET)
	private ModelAndView getHotelForm() {

		return new ModelAndView("hotel-form", "hotel", new Hotel());
	}

	@RequestMapping(value = "/hotel.htm", method = RequestMethod.POST)
	protected String addHotel(HttpServletRequest request, @ModelAttribute("hotel") Hotel hotel,
			BindingResult result) throws Exception {
		
		Set<Hotel_Photos> multiphotos = new HashSet<Hotel_Photos>();
		
		Iterator<CommonsMultipartFile> i = hotel.getPhoto().iterator();
		while (i.hasNext()) 
				{
			try{

				if (hotel.getHotel_name().trim() != "" || hotel.getHotel_name() != null) {
					File directory;
					String check = File.separator; 
				
					String path = null;
					if (check.equalsIgnoreCase("\\")) {
						path = servletContext.getRealPath("").replace("build\\", ""); 
					}

					if (check.equalsIgnoreCase("/")) {
						path = servletContext.getRealPath("").replace("build/", "");
						path += "/"; // Adding trailing slash for Mac systems.
					}
					directory = new File(path + "\\" + hotel.getHotel_name());
					boolean temp = directory.exists();
					if (!temp) {
						temp = directory.mkdir();
					}
					if (temp) {
						// We need to transfer to a file
						CommonsMultipartFile photoInMemory = i.next();

						String fileName = photoInMemory.getOriginalFilename();
						// could generate file names as well

						File localFile = new File(fileName);

						// move the file from memory to the file

						photoInMemory.transferTo(localFile);
						Hotel_Photos photos = new Hotel_Photos();
						
						photos.setFile_name(localFile.getPath());
						photos.setHotel(hotel);
						
						hoteldao.registerPhotos(photos);
						
						multiphotos.add(photos);
						
						System.out.println("File is stored at" + localFile.getPath());
						System.out.print("registerNewUser");
						

					} else {
						System.out.println("Failed to create directory!");
					}

				}
}		
			catch (IllegalStateException e) {
				System.out.println("*** IllegalStateException: " + e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("*** IOException: " + e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
		
		try{
				hotel.setPhotos(multiphotos);
				//hoteldao.registerHotel(hotel);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin-dashboard";
	}
}