<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"  http-equiv="Content-Type" content="text/html; charset=UTF-8, width=device-with, initial-scale=1.0 ">
<link rel="stylesheet" href="./utilities/boostrap/css/bootstrap.min.css">
<style type="text/css">
nav {
	height: 30px;
	text-align: center;
}

fieldset {
	background-color: #E4EFFF;
	border: 1px solid #9FC6FF;
	margin: 5px;
	border-radius: 30px;
}
</style>
<script type="text/javascript" src="./utilities/JS/AlertFile.js"></script>
<title>login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<center>
		<fieldset>
			<div class="container-fluid">
				<div class="form-log"}>

					<form method="post" action="LoginServlet" id="form-login">
						<p><br><br><br>
						<article>
						<p>say something about the project</p>
						
						</article><br><br>
							&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label for="login">login
							</label> <input name="login" type="email" id="login" placeholder="e-mail"/> <br><br>
							<label for="password">&nbsp; &nbsp;&nbsp;password</label>
							<input name="password" type="password" id="password" /><br><br>
							&nbsp;&nbsp;&nbsp; <input type="submit" value="Log in" /> <br />
						</p><br><br>
					</form>

				</div>
			</div>
		</fieldset>
	</center>
</body>
</html>