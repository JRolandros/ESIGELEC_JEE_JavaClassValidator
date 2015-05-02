package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		        req.getSession().invalidate();
		        boolean sessionInvalidated;
		        if(req.getSession()!=null)
		        	sessionInvalidated=false;
		        else
		        	sessionInvalidated=true;
		        req.setAttribute("sessionInvalidated", sessionInvalidated);
		        this.getServletContext().getRequestDispatcher("/MyJSP/logoutPage.jsp").forward(req, resp);
		    }

}
