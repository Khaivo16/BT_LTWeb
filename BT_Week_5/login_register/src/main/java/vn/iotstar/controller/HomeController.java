package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = {"/home"})

public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		UserModel u = (UserModel) session.getAttribute("account2");
		if (u == null) {
			req.getRequestDispatcher("/view/web/home.jsp").forward(req, resp);
		}
		else {
			session.setAttribute("username", u.getFullname());
			req.getRequestDispatcher("/view/web/home.jsp").forward(req, resp);
		}
		
	}
}
