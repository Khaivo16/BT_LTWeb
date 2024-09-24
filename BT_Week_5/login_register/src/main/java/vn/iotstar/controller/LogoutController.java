package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false); // get the session if it exists
		session.removeAttribute("account");
		session.removeAttribute("account1");
		session.removeAttribute("account2");

		// Remove remember me cookie if it exists
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0); // delete the cookie
					resp.addCookie(cookie); // add the deleted cookie to the response
					break;
				}
			}
		}

		// Redirect to login page or home page after logout
		resp.sendRedirect(req.getContextPath() + "/login");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
