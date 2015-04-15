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
		{ FileInputStream fis = new FileInputStream(exoFileName); // Créer un flux d'entrée avec comme paramètre le nom du fichier à ouvrir
		   int n; 
		   while ((n = fis.available())> 0) 			// tant qu'il y a des données dans le flux...
		   { byte[] b = new byte[n];				 	// récupérer le byte à l'endroit n et le stocker dans un tableau de bytes
		      int result= fis.read(b);					 // lire ce tableau de byte à l'endroit désiré
		      if (result== -1) break; 					// si le byte est -1, c'est que le flux est arrivé à sa fin (par définition)
		      String exercise= new String(b); 			// assembler les bytes pour former une chaîne
		      req.setAttribute("exercise",exercise); 	//insérer cette chaîne dans notre composant de texte
		   }
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

}
