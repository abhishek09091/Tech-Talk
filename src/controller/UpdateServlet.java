package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("Text/html");
		System.out.println("Hi i M IN UPDATE Servelet");
		System.out.println(request.getParameter("techTalkDate"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("speaker"));
		System.out.println(request.getParameter("techTalkId"));
		
		PrintWriter out=response.getWriter();
		
		
		out.print("<%@ page language='java' contentType='text/html; charset=ISO-8859-1'"+
			    "pageEncoding='ISO-8859-1'%>"+
			"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>"+
			"<html lang='en'>");

		out.print(" <head>");
					
		out.print("<meta charset='utf-8'>");
		out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print(" <title>Tech Talk Form</title>");

		out.print("<!-- CSS -->");
			out.print("<link href='http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css' rel='stylesheet'>");
			out.print(" <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600'>");
			out.print("<link rel='stylesheet' href='assests/assets/bootstrap/css/bootstrap.min.css'>");
			out.print("<link rel='stylesheet' href='assests/assets/css/form-elements.css'>");
			out.print("<link rel='stylesheet' href='assests/assets/css/style.css'>");

			out.print(" <!-- Favicon and touch icons -->");
			out.print("<link rel='shortcut icon' href='assets/assets/ico/favicon.png'>");
			out.print("<link rel='apple-touch-icon-precomposed' sizes='144x144' href='assests/assets/ico/apple-touch-icon-144-precomposed.png'>");
			out.print("<link rel='apple-touch-icon-precomposed' sizes='114x114' href='assests/assets/ico/apple-touch-icon-114-precomposed.png'>");
			out.print("<link rel='apple-touch-icon-precomposed' sizes='72x72' href='assests/assets/ico/apple-touch-icon-72-precomposed.png'>");
			out.print("<link rel='apple-touch-icon-precomposed' href='assests/assets/ico/apple-touch-icon-57-precomposed.png'>");
			out.print("<style>");
			out.print("span#sizing-addon1 {");
			out.print(" font-size: larger;");
			out.print("height: 49px;");
			out.print("}");
			out.print("</style>");
			out.print("<style>");
			out.print(".input-append .add-on:last-child, .input-append .btn:last-child, .input-append .btn-group:last-child>.dropdown-toggle {");
			out.print("-webkit-border-radius: 0 4px 4px 0;");
			out.print(" -moz-border-radius: 0 4px 4px 0;");
			out.print(" border-radius: 0 4px 4px 0;");
			out.print("height: 50px;");
			out.print(" font-size: smaller;");
			out.print("}");
			out.print("</style>");
				 
			    
			out.print("<script type='text/javascript'");
			out.print("src='http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js'>");
			out.print(" </script>"); 
			out.print("</head>");

			out.print("<body>");

			out.print("<!-- Top content -->");
			out.print(" <div class='top-content'>");
			        	
			out.print("<div class='inner-bg'>");
			out.print("<div class='container'>");
			out.print(" <div class='row'>");
			out.print(" <div class='col-sm-8 col-sm-offset-2 text'>");
			out.print(" <h1 style='color:#000;'>Tech Talk Form</h1>");
			out.print("<div class='description'>");
			out.print(" <p style='color:#000;'>");
			out.print("We need technology in every classroom and in every student and teachers hand, because it is the pen and paper of our time, and it is the lens through which we experience much of our world.");
			out.print("<p style='color:#000'> - David Warlick </p>");
			out.print("</p>");
			out.print("  </div>");
			out.print(" </div>");
			out.print(" </div> ");
			out.print(" <div class='row'>");
			out.print("<div class='col-sm-6 col-sm-offset-3 form-box'>");
			out.print("<div class='form-top'>");
			         	out.print("<h3>Tech Talk Update Form</h3>");
			            			out.print("<p>Fill in the for Tech Talk</p>");
							out.print("</div>");
							out.print("<div >");       							
			                           
							out.print("<form role='form' action='updateservletsecond' method='post'>");        									
							out.print("<div class='form-group'>");
							out.print("<label class='sr-only' for='title'>Title</label>");
							out.print("<input type='text' name='title' placeholder='Title of Tech Talk...' class='contact-email form-control' id='contact-email''readonly'>"+request.getParameter("title")+"</input>");
							out.print("</div>");        											
							out.print("<div class='form-group'>");
							out.print("<label class='sr-only' for='speaker'>Speaker</label>");
							out.print("<input type='text' name='speaker' placeholder='Presenter Of Tech Talk' class='contact-email form-control' id='contact-email'>"+request.getParameter("speaker")+"</input>");
							out.print("</div>");       																	
							out.print("	<div id='datetimepicker4' class='input-append form-group'>");
			                out.print("	<input data-format='yyyy-MM-dd' type='text'  name='techTalkDate' >"+request.getParameter("techTalkDate")+"</input>");
							out.print("<span class='add-on mychange'  id='sizing-addon1'>");
							out.print("	<i class='fa fa-calendar fa-th-large' aria-hidden='true'></i>");
							out.print("	</i>");
							out.print("	</span>");
							out.print("	</div>");

							out.print(" <div class='form-group'>");
							out.print("<label class='sr-only' for='contact-message'>Description</label>");
							out.print("<textarea name='description' placeholder='Description about Tech Talk...' class='contact-message form-control' id='contact-message'>"+request.getParameter("description")+"</textarea>");
						    out.print(" </div>");
						    out.print(" <div><input class='btn btn-info btn-block login' value='Add Tech Talk'   type='submit'/></div>");
						                                     
						    out.print("</form>");
					                 
						    out.print("</div>");
						   	out.print("</div>");
						   out.print("</div>");
						   out.print("</div>");
			            
						   out.print("</div> ");

						   out.print("<!-- Javascript -->");
					
					
						   out.print("<script type='text/javascript'>");
								   out.print("$(function() {");
										   out.print(" $('#datetimepicker4').datetimepicker({");
			    	out.print("   pickTime: false");
			    			out.print(" });");
			    					out.print("});");
			    							out.print("</script>");
			    									out.print("<script type='text/javascript'>");
			    											out.print(" $(function() {");
			    													out.print("$('#datetimepicker3').datetimepicker({");
			    															out.print("  pickDate: false");
			    																	out.print("});");
			    																			out.print(" });");
			    																					out.print("</script>");	
			out.print("<script type='text/javascript'>");
					out.print(" $(function() {");
							out.print("   $('#datetimepicker5').datetimepicker({");
									out.print("   pickDate: false");
											out.print(" });");
													out.print("  });");
															out.print("</script>");
					
			       
			      
																	out.print("  <script type='text/javascript'");
																			out.print("  src='http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js'>");
																					out.print("  </script>");
			    out.print("  <script type='text/javascript'");
			    		out.print(" src='http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js'>");
			    				out.print("</script>");
			    						out.print(" <script type='text/javascript'");
			    								out.print("  src='http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js'>");
			    										out.print(" </script>");
			    												out.print("   <script src='assests/assets/js/jquery.backstretch.min.js'></script>");
			    														out.print("    <script src='assests/assets/js/scripts.js'></script>");
			        

			    																out.print(" </body>");

			    																		out.print("</html>");
		
	}

}
