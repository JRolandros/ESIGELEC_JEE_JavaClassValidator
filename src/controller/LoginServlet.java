package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import model.Teacher;
import model.User;
import modelDB.UserDB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session=req.getSession(true);


		String login = req.getParameter("login");
		String password = req.getParameter("password");
		try {
			User u=UserDB.getUser("ros@yahoo.fr");
			boolean a=UserDB.checkLogin(u.getLogin(), u.getPassword());
			System.out.println(u.getNom()+"check method :"+a);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(login==null){
			this.getServletContext().getRequestDispatcher("/MyJSP/loginPage.jsp").forward(req, resp);
			return;
		}
		try{
			if(UserDB.checkLogin(login, password))
			{
				User connectedUser=UserDB.getUser(login);
				if(connectedUser instanceof Student)
				{
					Student student= (Student) connectedUser;
					session.setAttribute("connectedUser", connectedUser);
					this.getServletContext().getRequestDispatcher("/MyJSP/workPage.jsp").forward(req, resp);
				}
				else
				{
					Teacher teacher= (Teacher) connectedUser;
					session.setAttribute("connectedUser", connectedUser);
					this.getServletContext().getRequestDispatcher("/MyJSP/teacherPage.jsp").forward(req, resp);
				}
			}
			else
			{
				String str="Your login or password is not correct, please cry again!!!";
				req.setAttribute("connectionError", str);
				login=null;
				str=null;
				this.getServletContext().getRequestDispatcher("/JSP_Folder/LoginForm.jsp").forward(req, resp);
			}
		}catch(Exception e){
			log(" A login exception occurred :"+ e.getMessage());
			e.printStackTrace();
		}

	}

}
