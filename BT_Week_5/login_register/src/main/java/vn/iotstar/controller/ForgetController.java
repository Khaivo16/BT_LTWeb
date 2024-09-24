package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = { "/forget" })
public class ForgetController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String user = req.getParameter("user_name");
		String email = req.getParameter("email");
		String alertMsg = "";
		RequestDispatcher rd;

		UserDaoImpl userDao = new UserDaoImpl();
		UserModel oject =  userDao.findbyUser(user);
		
		if ((userDao.CheckEmailDuplicate(oject.getEmail(),email) == false) || (oject == null)) {
			alertMsg = "User hoặc Email chưa chính xác";
			req.setAttribute("alert", alertMsg);
			rd = req.getRequestDispatcher("/view/Forget.jsp");
			rd.forward(req, resp);
			return;
		}
		HttpSession session = req.getSession(true);
		session.setAttribute("account1", oject);
		rd = req.getRequestDispatcher("/view/Renew_PSW.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		RequestDispatcher rd;
		HttpSession session = req.getSession();
		UserModel u = (UserModel) session.getAttribute("account1");
		String user = u.getUsername();
		UserDaoImpl userDao = new UserDaoImpl();
		String psw = req.getParameter("password");
		userDao.UpdatePswbyUser(user, psw);
		rd = req.getRequestDispatcher("/view/login.jsp");
		rd.forward(req, resp);
		
	}

}
