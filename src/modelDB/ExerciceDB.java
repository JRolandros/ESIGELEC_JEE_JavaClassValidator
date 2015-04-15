package modelDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Exercice;
import modelDB.DBUtil;

public class ExerciceDB {
	private static String ADD = "INSERT into exercice_exo (path_exo) values (?)";
	private static String SELECT_ALL_Exo = "SELECT *FROM exercice_exo";
	private static String SELECT_Exo = "SELECT *FROM exercice_exo WHERE path_exo = ?";
	
	
	
	
	
	
	
/**================================= Select all Exercise ======================================================**/
	
	public static List<Exercice> GetAllProjects() throws Exception{
		List<Exercice> AllExercice=new LinkedList<Exercice>();
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt1 = con.prepareStatement(SELECT_ALL_Exo);
		ResultSet result = stmt1.executeQuery();
		
		while(result.next()){
			
			Exercice Exercice1 = new Exercice(result.getString("path_exo"));
			AllExercice.add(Exercice1);
		}
		result.close();
		stmt1.close();
		DBUtil.dropConnection(con);
		return AllExercice;
	}
	

}
