<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type"
	content="text/html; charset=UTF-8, width=device-with, initial-scale=1.0 ">
<link rel="stylesheet" href="./utilities/boostrap/css/bootstrap.min.css">
<title>logged out</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<fieldset>

		<div class="container-fluid">
			<div class="form-log"}>


				<center>
					<p>Good Bye and see you soon on this web site!</p>
					<br> <a href="<%=request.getContextPath()%>/LoginServlet"><button>Click
							here to log in again to the Java Certification Tool web site !!!</button></a>
				</center>

			</div>
		</div>
	</fieldset>
</body>
</html>