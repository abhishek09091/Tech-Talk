package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi i M IN UPDATE Servelet");
		System.out.println(request.getParameter("techTalkDate"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("speaker"));
		System.out.println(request.getParameter("techTalkId"));
		
	}

}
