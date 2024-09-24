package vn.iotstar.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns = { "/Info/home" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024,

		maxFileSize = 1024 * 1024 * 5,

		maxRequestSize = 1024 * 1024 * 5 * 5)
public class EnterInfoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIRECTORY = "E:\\upload";

	public static final String DEFAULT_FILENAME = "default.file";

	private String getFileName(Part part) {

		for (String content : part.getHeader("content-disposition").split(";")) {

			if (content.trim().startsWith("filename"))

				return content.substring(content.indexOf("=") + 2, content.length() - 1);

		}

		return DEFAULT_FILENAME;

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		int roleid = Integer.parseInt(req.getParameter("roleid"));
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		HttpSession session = req.getSession();
		UserModel u = (UserModel) session.getAttribute("account");

		String user = u.getUsername();
		
		UserDaoImpl userDao = new UserDaoImpl();
		u = userDao.UpdateByUser(user, fullname,phone);
		session.setAttribute("account2", u);
		String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ
		//String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project
		File uploadDir = new File(uploadPath);


		 if (!uploadDir.exists())


		 uploadDir.mkdir();



		 try {


		 String fileName = "";


		 for (Part part : req.getParts()) {


		 fileName = getFileName(part);


		 part.write(uploadPath + File.separator + fileName);


		 }

		 	req.setAttribute("message", " Uploaded successfully!");


		 } catch (FileNotFoundException fne) {
			 req.setAttribute("message", "There was an error: " + fne.getMessage());
		 }


		 getServletContext().getRequestDispatcher("/view/result.jsp").forward(req, resp);



//		if (roleid == 1) {
//			resp.sendRedirect(req.getContextPath() + "/home");
//		} else if (roleid == 2) {
//			resp.sendRedirect(req.getContextPath() + "/admin/home");
//		} else
//			resp.sendRedirect(req.getContextPath() + "/manager/home");
		
	}

}
