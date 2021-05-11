package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadParamServlet
 */
@WebServlet("/ReadParamServlet")
public class ReadParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1:Set content type
		response.setContentType("text/html");
		
		//Step 2: get the prontWriter
		PrintWriter out = response.getWriter();
		
		//Step 3: read parameters from web.xml
		ServletContext context = getServletContext();		//inherited from HttpServlet
		String maxSize = context.getInitParameter("max-cart-size");
		String teamName = context.getInitParameter("team-name");
		
		//Step 4: generate HTML content
		out.println("<html><body>");
		out.println("<h3>Reading context parameters form web.xml</h3>");
		out.println("Maximum size of cart = " + maxSize + "<br><br>");
		out.println("Our team name: " + teamName + "<br><br>");
		out.println("<center>Time on the server: " + new java.util.Date() + "</center>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
