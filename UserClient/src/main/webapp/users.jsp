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

	<div class="container">
		<div style="padding-top:20px">
			<button class="btn btn-success" id="btnLogout" style="box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);">LogOut</button>
		</div>
		<div class="row" style="padding-top:20px">
			<div class="col-6" style="background-color: #F3F3F3">
				<h1>Users Management V10.1</h1>
				<form id="formItem" name="formItem">
					Username: <input id="username" name="username" type="text"
						class="form-control form-control-sm"> <br> Password:
					<input id="password" name="password" type="text"
						class="form-control form-control-sm"> <br> Account
					Number: <input id="accountNumber" name="accountNumber" type="text"
						class="form-control form-control-sm"> <br> Address: <input
						id="address" name="address" type="text"
						class="form-control form-control-sm"> <br> NIC: <input
						id="nic" name="nic" type="text"
						class="form-control form-control-sm"> <br> Phone: <input
						id="phone" name="phone" type="text"
						class="form-control form-control-sm"> <br> Reset
					Code: <input id="resetCode" name="resetCode" type="text"
						class="form-control form-control-sm"> <br> User Role:
					<input id="userRole" name="userRole" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				<br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				</div>
				<br>
				<div id="divItemsGrid">
					<%
					User userObj = new User();
					out.print(userObj.readUsers());
					%>
				</div>
			</div>
		
	</div>
</body>
</html>
