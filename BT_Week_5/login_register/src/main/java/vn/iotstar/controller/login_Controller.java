package vn.iotstar.controller;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = {"/login"})
public class login_Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// mã hóa UTF-8
    			resp.setCharacterEncoding("UTF-8");
    			req.setCharacterEncoding("UTF-8");
    			resp.setContentType("text/html");

    			// lấy tham số từ view
    			String username = req.getParameter("user_name");
    			String password = req.getParameter("password");
    			String remember = req.getParameter("remember");

    			// Xử lý bài toán
    			String alertMsg = "";
    			boolean isRememberMe = false;
    			if ("on".equals(remember)) {
    				isRememberMe = true;
    			}
    			if (username.isEmpty() || password.isEmpty()) {
    				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
    				req.setAttribute("alert", alertMsg);
    				req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    				return;
    			}
    			UserModel user = service.login(username, password);
    			if (user != null) {
    				HttpSession session = req.getSession(true);
    				session.setAttribute("account", user);
    				session.setAttribute("username", user.getFullname());
    				if (isRememberMe) {
    					saveRemeberMe(resp, username);
    			}
    				resp.sendRedirect(req.getContextPath() + "/waiting");
    			} else {
    				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
    				req.setAttribute("alert", alertMsg);
    				req.getRequestDispatcher("/view/login.jsp").forward(req, resp);

    			}
    }
	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}
}
