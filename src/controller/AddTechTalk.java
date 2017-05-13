package controller;

import java.io.IOException;
import java.util.Date;


import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import model.DAO;




@WebServlet("/addtechtalk")
public class AddTechTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		DAO dao=(DAO)session.getAttribute("DAO_INSTANCE");
		System.out.println("I m here in add tech talk controller");
		try {
			
			
			String title=request.getParameter("title");
			String speaker=request.getParameter("speaker");
			String techTalkDate=request.getParameter("techTalkDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = (Date)sdf.parse(techTalkDate);
			java.sql.Date sql = new java.sql.Date(startDate.getTime());
			
			//String techTalkStartTime=request.getParameter("techTalkStartTime");
			//DateFormat stf = new SimpleDateFormat("hh:mm:ss");
			//Date date = (Date) stf.parse(techTalkStartTime);
			//String techTalkEndTime=request.getParameter("techTalkEndTime");
			String description=request.getParameter("description");
			System.out.println("Hi I m inside add tech controller try blockhere");
			System.out.println(title+speaker+techTalkDate+description);
			System.out.println(dao);
			dao.addTechTalk(request.getParameter("title"),request.getParameter("speaker"),request.getParameter("description"),sql);
			System.out.println("AFTER SUCCESSFULLY ADDING A TALK");
			request.setAttribute("info", "You have Successfully Registered! For the New Tech Talk");
			response.setHeader("REFRESH", "1;url="+request.getContextPath());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	}


