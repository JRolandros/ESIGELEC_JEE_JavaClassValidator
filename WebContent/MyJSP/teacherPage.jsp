<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type"
	content="text/html; charset=UTF-8, width=device-with, initial-scale=1.0 ">
<link rel="stylesheet" href="./utilities/boostrap/css/bootstrap.min.css">
<title>Welcome Teacher</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<fieldset>

		<div class="container-fluid">
			<div class="form-log"}>
				<FORM>
					<button>Add new Execise</button>
					<SELECT name="nom" size="1">
						<OPTION selected>Exercice 1
						<OPTION>Exercice 2
						<OPTION>Exercice 3
						<OPTION>Exercice 4
						<OPTION>Exercice 5
					</SELECT><br> <br>
				</FORM>
				<form action="">
					<fieldset>
						<legend>Exercise details</legend>
						<textarea style="width: 100%">
						<%=request.getAttribute("exercise")%>
						</textarea>
						<button align="right">Add Exercice</button>
					</fieldset>
				</form>

			</div>
		</div>
	</fieldset>
</body>
</html>