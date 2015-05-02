package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Buffer;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/WorkServlet")
public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "ExercisesFile";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		
		try {
			// this code goes in doPost and you have to retrieve the file first here
			InputStream inputError=validatorJavaClass(req);
			if(inputError!=null){
				String appPath = req.getServletContext().getRealPath("");
				String savePath = appPath + File.separator + SAVE_DIR;
				String exoFileName=savePath+File.separator+"Exercise"+".java";
				File fichier=new File(savePath); //a file with exercises and where to store class file generated
				Process runtime;
				InputStream inputErrors=null;
				try{
					runtime = Runtime.getRuntime().exec("java "+savePath+" Exercise.class",null, fichier);
					
					InputStream input= runtime.getInputStream();
					InputStreamReader reader=new InputStreamReader(input);
					BufferedReader lecteur=new BufferedReader(reader);
					String str=" ";
					while((str=lecteur.readLine())!=null){
						System.out.println("here is what you want: "+str);
					}
					runtime.waitFor();
				}catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			openFile(req);
			getServletContext().getRequestDispatcher("/MyJSP/teacherPage.jsp").forward(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * this method allows you to compile a java code and return an input stream which can be examine 
	 * to see if you did it well or not
	 * @param req
	 */
	private InputStream validatorJavaClass(HttpServletRequest req) {
		String appPath = req.getServletContext().getRealPath("");  		// the real path of the application, it gives it dynamically
		String savePath = appPath + File.separator + SAVE_DIR;     		//the path to the directory where will be store all our files
		String exoFileName=savePath+File.separator+"Exercise"+".java";	// file name
		File fichier=new File(savePath); //a file with exercises and where to store class file generated
		Process runtime;
		InputStream inputError=null;
		try {
			runtime = Runtime.getRuntime().exec("javac -d "+savePath+" Exercise.java",null, fichier); // compilation of the java file
			
		System.out.println("path appli :"+savePath);
		//runtime.exec("java Exercise.class",null,fichier);
		
		inputError= runtime.getErrorStream();
		InputStreamReader reader=new InputStreamReader(inputError);
		BufferedReader lecteur=new BufferedReader(reader);
		String str=" ";
		while((str=lecteur.readLine())!=null){
			System.out.println("here is what you want: "+str);
		}
		runtime.waitFor();
	//javac -d savePath exoFileName;
		//runtime.
		runtime.destroy();
		
		
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputError;
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
