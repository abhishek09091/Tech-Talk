package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;
import model.DAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Register Servlet");
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("submit"));
		HttpSession session=request.getSession();
		DAO dao=(DAO)session.getAttribute("DAO_INSTANCE");
		Employee emp=(Employee)session.getAttribute("employee");
		emp.getEmployeeEmail();
		if(request.getParameter("submit").equals("register"))
		{
			String result=dao.registerUserInTable(emp.getEmployeeEmail(),request.getParameter("title"));
			if(result.equals("successfull"))
			{
				request.setAttribute("mess", "You have been success fullyregister for "+request.getParameter("title")+" techtalk");
				request.getRequestDispatcher("homepage.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("mess", "You have been already registered "+request.getParameter("title")+" techtalk");
				request.getRequestDispatcher("homepage.jsp").include(request, response);
			}
		}
		else
		{
			String result=dao.UnregisterUserInTable(emp.getEmployeeEmail(),request.getParameter("title"));
			if(result.equals("successfull"))
			{
				request.setAttribute("mess", "You have been success-fully unregistered for "+request.getParameter("title")+" techtalk");
				request.getRequestDispatcher("homepage.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("mess", "Unable to  unregistered for "+request.getParameter("title")+" techtalk");
				request.getRequestDispatcher("homepage.jsp").include(request, response);
			}
		}
	}

}
