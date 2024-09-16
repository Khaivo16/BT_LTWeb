package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = { "/Info/home" })
public class EnterInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		int roleid = Integer.parseInt(req.getParameter("roleid"));
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		HttpSession session = req.getSession();
		UserModel u = (UserModel) session.getAttribute("account");
		String user = u.getUsername();

		UserDaoImpl userDao = new UserDaoImpl();


		userDao.UpdateByUser(user,fullname,roleid,phone);
		if (roleid == 1) {
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		else if (roleid == 2) {
			resp.sendRedirect(req.getContextPath() + "/admin/home");
		}
		else resp.sendRedirect(req.getContextPath() + "/manager/home");
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
