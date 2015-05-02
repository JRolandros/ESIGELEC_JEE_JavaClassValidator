package modelDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;






import model.Student;
import model.Teacher;
import model.User;
import modelDB.DBUtil;

public class UserDB {
	private static String SELECT_User = "SELECT * FROM user";
	private static String SELECT_User_By_Login = "SELECT * FROM user WHERE login_user = ? ";
	// userType=0 => it's a student, userType=1 => it's a teacher
	private static String ADD_User="INSERT into User (login_user,nom_user,password_user,type_user) values(?,?,?,?)";
	
	public static void addUser(User user) throws Exception{
		Connection con = DBUtil.getConnection();
		PreparedStatement stmt = con.prepareStatement(ADD_User); 
		stmt.setString(1, user.getLogin());
		stmt.setString(2, user.getNom());
		stmt.setString(3, user.getPassword());
		if( !(user instanceof Teacher))
			stmt.setInt(4, 1);
		else
			stmt.setInt(4, 0);
		int lines = stmt.executeUpdate();

		if (lines != 1)
			throw new Exception(
					"Invalid quantity of returned lines");
		stmt.close();
		DBUtil.dropConnection(con);
	}
	
	
	
	/**============================== check login and password ======================================================**/
	
	public static boolean checkLogin(String login,String password) throws Exception{
		User u=get_User(login);
		if(u==null)
			return false;
		return u.getPassword().equals(password);
	}
	
	
	/**=========================== get user by login =====================================================================**/
	
	public static User getUser(String login) throws Exception {
		User u=get_User(login);
		if(u == null) 
			return null;
		return u;
	}
	
	
	/**===================================== get owner by login ==========================================================**/
	
	public static Teacher getTeacher(String login) throws Exception{
		User u=get_User(login);
		if(u == null || !(u instanceof Teacher))
			return null;
		return (Teacher) u;
	}
	
	
	/**=========================================== get evaluator by login =====================================================**/
	
	public static Student getStudent(String login) throws Exception {
		User u=get_User(login);
		if(u == null || !(u instanceof Student))
			return null;
		return (Student) u;		
	}
	
	
	/**============================== private static method to retrieve users from the database =========================**/
	
	private static User get_User(String email) throws Exception{
		Connection con = DBUtil.getConnection();
		User user=null;
		PreparedStatement stmt2 = con.prepareStatement(SELECT_User_By_Login);
		stmt2.setString(1, email);
		ResultSet result2 = stmt2.executeQuery();
		
			if(result2.next())
			{
				String name=result2.getString("nom_user");
				//String email1=result2.getString("email");
				String password=result2.getString("password_user");
				if(result2.getInt("type_user")==0){
				 user=new Teacher(email,name,password);
				 //user.setUserType(0);
				}
				else{
				user=new Student(email,name,password);
				//user.setUserType(1);
				}
			}
		
		result2.close();
		stmt2.close();
		DBUtil.dropConnection(con);
		return user;
	}
	
	/**============================== Select All users ===================================================**/
	
	private static List<User> GetAllUsers() throws Exception{
		List<User> AllUsers=new LinkedList<User>();
		Connection con = DBUtil.getConnection();
		User user=null;
		PreparedStatement stmt2 = con.prepareStatement(SELECT_User);
		ResultSet result2 = stmt2.executeQuery();
		while(result2.next()){
			User  user1=null;
			String name=result2.getString("name");
			String email=result2.getString("email");
			String password=result2.getString("password");
			if(result2.getInt("type_user")==0){
				 user1=new Teacher(email,name,password);
				 //user1.setUserType(0);
				}
			else{
				user1=new Student(email,name,password);
				//user1.setUserType(1);
				}
		}
		
		result2.close();
		stmt2.close();
		DBUtil.dropConnection(con);
		
		return AllUsers;
	}
}
