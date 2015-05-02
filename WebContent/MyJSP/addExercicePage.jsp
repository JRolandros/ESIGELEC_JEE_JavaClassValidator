<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type"
	content="text/html; charset=UTF-8, width=device-with, initial-scale=1.0 ">
<link rel="stylesheet" href="./utilities/boostrap/css/bootstrap.min.css">

<title>Add Exercise</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<fieldset>

		<div class="container-fluid">
			<div class="form-log"}>

				<fieldset>
					<legend>Execise 1</legend><br>
					<form method="POST" action="<%=request.getContextPath()%>/AddExerciceServlet">
<!-- la zone reservée à la saisie de l'exercice -->
						<input type="text" name="className" placeholder="file name here" title="the file name must be the same with the class name"> <br>
						<textarea  name="exercise" >
						
/**
 * @author 
*
*/
public class ClassName {
				
	/**
	 * tell about you program here
	 */
	public ClassName() {
							
							
	}
							
	/**
	 * @param args
  	 */
	public static void main(String[] args) {
						
							
	}
}
						</textarea><br><br>
						<input type="submit" name="add" value="Add Exercice" title="Don't forget to match the file name and the class name">
					</form>
				</fieldset>

			</div>
		</div>
	</fieldset>
</body>
</html>