<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Welcome Teacher</title>
</head>
<body>
	<FORM>
		<button>Add new Execise</button> 
		<SELECT name="nom" size="1">
			<OPTION selected>Exercice 1
			<OPTION>Exercice 2
			<OPTION >Exercice 3
			<OPTION>Exercice 4
			<OPTION>Exercice 5
		</SELECT><br><br>
	</FORM>
	<form action="">
	<fieldset>
	<legend>Exercise details</legend>
	<textarea rows="25" cols="110">
	<%=request.getAttribute("exercise")%>
	</textarea>
	<button align="right">Add Exercice</button>
	</fieldset></form>
</body>
</html>