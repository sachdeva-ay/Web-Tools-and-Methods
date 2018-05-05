package com.travelhelper.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.travelhelper.validator.UserValidator;
import com.hotelbooking.dao.UserDao;
import com.travelhelper.pojo.User;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	private String showDashboard(){
		
		return "login";
	}
	
	@RequestMapping(value = "/userlogin.htm", method = RequestMethod.POST  )
	private String loginUser(HttpServletRequest request) throws Exception {
		System.out.println("in login user1");
		HttpSession session = (HttpSession) request.getSession();
	System.out.println(request.getParameter("username"));
	System.out.println(request.getParameter("password"));
	System.out.println(request.getParameter("role"));
		try {

			System.out.print("loginUser 1");
		    if(request.getParameter("role")==null){

		    	User user = userDao.getCustomer(request.getParameter("username"), request.getParameter("password"));
				if(user == null){
					System.out.println("UserName/Password does not exist");
					session.setAttribute("errorMessage", "UserName/Password does not exist");
					return "error";
				}
				
				session.setAttribute("userid", user.getUser_id());
				session.setAttribute("userfirstname", user.getFirst_name());
				System.out.println(user);
				return "home";}
		    else{
		    	System.out.print("loginUser else part 1");
		    	User user = userDao.getAdmin(request.getParameter("username"), request.getParameter("password"));
				if(user == null){
					System.out.println("UserName/Password does not exist");
					session.setAttribute("errorMessage", "UserName/Password does not exist");
					return "error";
					
				}
				session.setAttribute("userid", user.getUser_id());
				session.setAttribute("userfirstname", user.getFirst_name());
				
				return "admin-dashboard";
		    	
		    }

		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}
	
	
	@RequestMapping(value = "/UserRegistration.htm", method = RequestMethod.GET)
	private ModelAndView userRegistration(){
		
		return new ModelAndView("UserRegistration", "user", new User());
	}
	
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) 
			throws Exception {

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", user);
		}

		try {

			System.out.print("registerNewUser");

			User u =  new User(user.getFirst_name(), user.getPhone_number(), user.getEmail_Id(),
					user.getLast_name(),user.getPassword(), user.getUsername(),user.getRole()); 
			request.getSession().setAttribute("user",u);
			
			User us=userDao.register(u);
			if(user.getRole().equals("customer")){
				request.getSession().setAttribute("user", us);
			    return new ModelAndView("home", "user", us);
			}
			else{
				request.getSession().setAttribute("user", us);
			    return new ModelAndView("admin-dashboard", "user", us);
			}

		} catch (Exception e) {
			System.out.print("registerNewUser" + e);

			User u =  new User(); 
			request.getSession().setAttribute("user",u);
			
			return new ModelAndView("home", "user", u);
		}
	}
}

