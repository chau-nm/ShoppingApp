package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.request.LoginRequest;

import java.io.IOException;

import common.Messages;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("appName", "ShoppingApp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginRequest loginRequest = new LoginRequest(username, password);
		if (loginRequest.isValid()) {
			response.sendRedirect(request.getContextPath() + "/hello");
		} else {
			request.setAttribute("errorMessage", Messages.LOGIN_FAIL);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
