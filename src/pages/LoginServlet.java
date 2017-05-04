package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import model.DAO;
import pojos.Employee;
import pojos.TechTalk;



@WebServlet(urlPatterns = { "/login" }, initParams = {
		@WebInitParam(name = "drvr_cls", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "db_url", value = "jdbc:mysql://localhost:3306/techtonics"),
		@WebInitParam(name = "user_name", value = "root"),
		@WebInitParam(name = "pass", value = "root") })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO ad;
	public void init() throws ServletException
    {
   	 try
   	 {
   		 System.out.println("Inside init method of Login Servlet");
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("DAO_INSTANCE", ad);
		response.setContentType("Text/html");
		System.out.println(ad);
		System.out.println("Hi I m here");
		String employeeEmailUser=request.getParameter("employeeEmail");
		String employeePassword=request.getParameter("employeePassword");
		System.out.println(employeeEmailUser+employeePassword);
		
		
		try {
			Employee employee=ad.verifyUser(request.getParameter("employeeEmail"),request.getParameter("employeePassword"));
			System.out.println("after statement");
			if(employee!=null)
			{
				session.setAttribute("employee",employee);
				ArrayList<TechTalk> techtalks=ad.getTechTalk();
				session.setAttribute("techtalks",techtalks);
				System.out.println(techtalks);
				if(employee.getEmployeeEmail().equals("admin@atmecs.com") && employee.getPassword().equals("123@g.Co"))
				{
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
				
			}
			else
			{
				System.out.println("I m in inside else block");
				request.setAttribute("info", "Either UserName is not Registered or Password is Wrong");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
