package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

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
		//openFile(req);
		
		getServletContext().getRequestDispatcher("/MyJSP/addExercicePage.jsp").forward(req, resp);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ok here!");
		
		int result=saveFile(req);
		if(result==1)
		{
			System.out.println("probleme de caract�re sp�ciaux !!");
			getServletContext().getRequestDispatcher("/MyJSP/addExercicePage.jsp").forward(req, resp);
		}
		if(result==2)
		{
			System.out.println("incoh�rence entre le nom du fichier java et le nom de la classe!!");
			getServletContext().getRequestDispatcher("/MyJSP/addExercicePage.jsp").forward(req, resp);
		}
		
		
		
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
	private int saveFile(HttpServletRequest req) {
		String appPath = req.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String fileName=req.getParameter("className");
		//validation du nom du fichier
		fileName=fileName.replaceAll(" ", "");
		 String regExpression = "[a-zA-Z_0-9]*";
		 if(!fileName.matches(regExpression)) 					// s'il y a des caract�re sp�ciaux sort de la methode
			 return 1;
		 String exerciseText=req.getParameter("exercise"); 			// r�cup�ration du contenu de l'exercice
		 
		 // comparaison du nom de fichier avec le nom de la classe
		 
		 String strTest="publicclass"+fileName+"{"; 				//nom de la classe attendu sans caract�re espace
		 String allExo=exerciseText.replaceAll(" ", "");
		 if(!allExo.contains(strTest))
			 return 2;
		String exoFileName=savePath+File.separator+fileName+".java";
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
		return 0;
	}
	

}
