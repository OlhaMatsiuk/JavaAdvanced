package ua.lviv.lgs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.basic.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userService.saveUser(new User(firstName, lastName, email, password));
		
		request.setAttribute("email", email);		
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}
	
}
