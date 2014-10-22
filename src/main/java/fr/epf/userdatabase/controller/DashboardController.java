package fr.epf.userdatabase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.epf.userdatabase.domain.User;
import fr.epf.userdatabase.service.UserDBService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private UserDBService userDBService;
	
	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<User> users = new ArrayList<>();
		
		//GEt user with id 1
		//users.add(userDBService.get(1l));
		
		//Add the user list
		req.setAttribute("users", userDBService.getAll());
		
		//
		
		//Get the dispatcher JSP
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/dashboard.jsp");

		//Forward the request
		dispatcher.forward(req, resp);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Get user form request
		User user = populateUser(req);
		

		System.out.println(user);
		
				
		//Persist the user
		userDBService.create(user);
		
		doGet(req,resp);
		
		
	}

	private User populateUser(HttpServletRequest req) {
		//GEt form data
		String firstName = (String)req.getParameter("firstName");
		String lastName = (String)req.getParameter("lastName");
		
		User user = User.builder()
				.firstName(firstName)
				.lastName(lastName)
				.build();
		return user;
	}
	
	
	
	

}
