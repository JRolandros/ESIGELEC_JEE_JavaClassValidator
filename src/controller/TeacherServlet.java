package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "ExercisesFile";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		openFile(req);
		getServletContext().getRequestDispatcher("/MyJSP/teacherPage.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
	/**
	 * @param req
	 */
	private void openFile(HttpServletRequest req) {
		String appPath = req.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String exoFileName=savePath+File.separator+"Exercise"+".java";
		
		try
		{ FileInputStream fis = new FileInputStream(exoFileName); // Cr�er un flux d'entr�e avec comme param�tre le nom du fichier � ouvrir
		   int n; 
		   while ((n = fis.available())> 0) 			// tant qu'il y a des donn�es dans le flux...
		   { byte[] b = new byte[n];				 	// r�cup�rer le byte � l'endroit n et le stocker dans un tableau de bytes
		      int result= fis.read(b);					 // lire ce tableau de byte � l'endroit d�sir�
		      if (result== -1) break; 					// si le byte est -1, c'est que le flux est arriv� � sa fin (par d�finition)
		      String exercise= new String(b); 			// assembler les bytes pour former une cha�ne
		      req.setAttribute("exercise",exercise); 	//ins�rer cette cha�ne dans notre composant de texte
		   }
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

}
