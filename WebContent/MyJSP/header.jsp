<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"  http-equiv="Content-Type" content="text/html; charset=UTF-8, width=device-with, initial-scale=1.0 ">
<link rel="stylesheet" href="./utilities/boostrap/css/bootstrap.min.css">
<style type="text/css">
nav {
	height: 40px;
	text-align: center;
}

fieldset {
	background-color: #E4EFFF;
	border: 1px solid #9FC6FF;
	margin: 5px;
	border-radius: 30px;
}
textarea {
  height: 300px;
  width:100%;
  max-width: 100%;
  box-sizing:border-box;
  margin:0;
  border: 3px solid #ddd;
  border-radius: 0;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  resize: none;
}
</style>
<script type="text/javascript" src="./utilities/JS/AlertFile.js"></script>
<title>login</title>
</head>
<body>
	<center>
		<fieldset>
			<nav>
			<center>
				<div class="container-fluid">
					<div class="navbar-header">
					<div style="float: right">
					<form method="post" action="" id="form-login">
					<!-- here is the menu -->
					<div id="sideBar">
						<img alt="user image" src="utilities/images/tn_userImage.jpg">&nbsp;
						&nbsp;&nbsp; <a href="#" id="sideBarTab">${connectedUser.nom}</a>
						<div id="sideBarContents">
							<div id="sideBarContentsInner">
								<ul>
									<li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- end of the menu -->
				</form>
				</div>
						<span class="navbar-brand"><h1>Java Certification Tool</h1><br><br></span>
					</div>
				</div>
			</center>
			</nav>
		</fieldset>
	</center>
</body>
</html>