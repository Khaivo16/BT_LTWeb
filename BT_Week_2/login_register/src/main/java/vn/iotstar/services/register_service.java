package vn.iotstar.services;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = { "/Register", "/dangki"})
public class register_service extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String user = req.getParameter("user");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("psw");
		String alertMsg ="";
		RequestDispatcher rd;

		UserDaoImpl userDao = new UserDaoImpl();
		if (userDao.CheckUserExist(user) == true ) {
			alertMsg = "User đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			rd = req.getRequestDispatcher("/view/inform_register.jsp");
			rd.forward(req, resp);
			return;

		}
		
		if (userDao.CheckEmailExist(email) == true) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			rd = req.getRequestDispatcher("/view/inform_register.jsp");
			rd.forward(req, resp);
			return;
		}

		userDao.insert(new UserModel(user, email, fullname, "null", password));
		rd = req.getRequestDispatcher("/view/form_login.html");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
