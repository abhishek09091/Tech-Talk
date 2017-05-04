package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;


@WebServlet(urlPatterns = { "/signup" }, initParams = {
		@WebInitParam(name = "drvr_cls", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "db_url", value = "jdbc:mysql://localhost:3306/techtonics"),
		@WebInitParam(name = "user_name", value = "root"),
		@WebInitParam(name = "pass", value = "root") })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO ad;
	public void init() throws ServletException
    {
   	 try
   	 {
   		 ServletConfig sc = getServletConfig();
   		 ad = new DAO(sc.getInitParameter("drvr_cls"),
					sc.getInitParameter("db_url"),
					sc.getInitParameter("user_name"),
					sc.getInitParameter("pass"));
   	 
        }
   	 catch(Exception e)
   	 {
   		 throw new ServletException("Error in init", e);
   	 }
    }
	
    
   
	public void destroy()
	{
		try {
			ad.cleanUp();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	
 
  
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.setAttribute("DAO_INSTANCE", ad);
		response.setContentType("Text/html");
		DAO dao=(DAO)request.getAttribute("DAO_INSTANCE");
		//String employeeName=request.getParameter("employeeName");
		//String employeeEmail=request.getParameter("employeeEmail");
		//String employeePassword=request.getParameter("employeePassword");
		
		boolean flag=dao.registerUser(request.getParameter("employeeName"),request.getParameter("employeeEmail"),request.getParameter("employeePassword"));
			
			if(flag)
			{
				request.setAttribute("info", "You have Successfully Registered! You can SignIn now");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				System.out.println("In if");
				request.setAttribute("info", "User already registereed");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		
	}

}
