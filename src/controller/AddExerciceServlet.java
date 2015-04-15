package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddExerciceServlet
 */
@WebServlet("/AddExerciceServlet")
public class AddExerciceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "ExercisesFile";
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		openFile(req);
		
		getServletContext().getRequestDispatcher("/MyJSP/addExercicePage.jsp").forward(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok here!");
		
		saveFile(req);
		
		
		
	}
	
	

	/**
	 * @param req
	 */
	private void openFile(HttpServletRequest req) {
		String appPath = req.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String exoFileName=savePath+File.separator+"Exercise"+".java";
		
		try
		{ FileInputStream fis = new FileInputStream(exoFileName);
		// Cr�er un flux d'entr�e avec comme param�tre le nom du fichier � ouvrir
		   int n; 
		   while ((n = fis.available())> 0) // tant qu'il y a des donn�es dans le flux...
		   { byte[] b = new byte[n]; // r�cup�rer le byte � l'endroit n et le stocker dans un tableau de bytes
		      int result= fis.read(b); // lire ce tableau de byte � l'endroit d�sir�
		      if (result== -1) break; // si le byte est -1, c'est que le flux est arriv� � sa fin (par d�finition)
		      String exercise= new String(b); // assembler les bytes pour former une cha�ne
		      req.setAttribute("exercise",exercise); //ins�rer cette cha�ne dans notre composant de texte
		   }
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	

	/**
	 * @param req
	 */
	private void saveFile(HttpServletRequest req) {
		String appPath = req.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String exoFileName=savePath+File.separator+"Exercise"+".java";
		String exerciseText=req.getParameter("exercise");
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		try
		{ FileWriter lu = new FileWriter(exoFileName);
		// Cr�er un objet java.io.FileWriter avec comme argument le mon du fichier dans lequel enregsitrer
		   BufferedWriter out = new BufferedWriter(lu);
		// Mettre le flux en tampon (en cache)
		   out.write(exerciseText); //Balancer dans le flux le contenu de la zone de texte
		   out.flush();
		   out.close(); // Fermer le flux (c'est toujours mieux de le fermer explicitement)
		   System.out.println("done well");
		 } catch (IOException er) {
			 er.printStackTrace();
		 }
	}
	

}
