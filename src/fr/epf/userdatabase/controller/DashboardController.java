package fr.epf.userdatabase.controller;

import java.io.IOException;

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
		UserDBService userDBService = new UserDBService();
		
		//Display users
		StringBuilder html = new StringBuilder("<html>");
		html.append("<body>")
			.append("<table>")
			.append("<th>")
			.append("<td>id</td>")
			.append("<td>First name</td>")
			.append("<td>Last name</td>")
			.append("</th>");
		
		for(User user : userDBService.getAll()){
			html.append("<tr>")
			.append("<td>")
			.append(user.getId())
			.append("</td>")
			.append("<td>")
			.append(user.getFirstName())
			.append("</td>").append("<td>")
			.append(user.getLastName())
			.append("</td>")
			.append("</tr>");
			
		}
		
		html.append("</table>")
		.append("</body>")
		.append("</html>");
		resp.getWriter().append(html.toString());
		
	}
	
	

}
