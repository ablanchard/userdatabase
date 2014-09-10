package fr.epf.userdatabase.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.userdatabase.domain.User;
import fr.epf.userdatabase.service.UserDBService;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get a service
		UserDBService userDBService = UserDBService.getInstance();
		
		
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
	
	

}
