package hello_world12.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/home","/trangchu"})
public class hello123456 extends HttpServlet {
	private static final long serialVersionUID = 1087146507475474768L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String ten1 = req.getParameter("ten"); 
		String ho = req.getParameter("ho"); 
		// dua du lieu ra view
		req.setAttribute("fname", ten1);
		req.setAttribute("lname", ho);
		RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
//		PrintWriter printW = resp.getWriter();
//		printW.print(ho+" "+ten1);
		rd.forward(req, resp);
		
//		printW.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
