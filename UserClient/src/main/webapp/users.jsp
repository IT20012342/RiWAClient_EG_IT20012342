<%@page import="com.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("Username") == null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/users.js"></script>
<script src="Components/auth.js"></script>
</head>
<body>
	<div>
		<button id="btnLogout">LogOut</button>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Users Management V10.1</h1>
				<form id="formItem" name="formItem">
					Item code: <input id="itemCode" name="itemCode" type="text"
						class="form-control form-control-sm"> <br> Item name:
					<input id="itemName" name="itemName" type="text"
						class="form-control form-control-sm"> <br> Item
					price: <input id="itemPrice" name="itemPrice" type="text"
						class="form-control form-control-sm"> <br> Item
					description: <input id="itemDesc" name="itemDesc" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid">
					<%
					User userObj = new User();
					out.print(userObj.readUsers());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
