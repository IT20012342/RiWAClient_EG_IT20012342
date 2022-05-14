package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "root");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public String readUsers() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for reading."; 
	 } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>User ID</th> <th>User Name</th><th>Account Number</th>"
	 + "<th>Address</th> <th>NIC</th> <th>Phone</th> <th>User Role</th><th>Update</th><th>Remove</th></tr>"; 
	 String query = "select * from user"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
		 String userID = Integer.toString(rs.getInt("userID"));
			String username = rs.getString("username");
			String address = rs.getString("address");
			String accountNumber = Integer.toString(rs.getInt("accountNumber"));
			String NIC = rs.getString("NIC");
			String phone = rs.getString("phone");
			String role = rs.getString("userRole");
	 // Add into the html table
	output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + userID
	 + "'>" + "</td></tr>"; 
	output += "<tr><td>" + userID + "</td>";
	output += "<td>" + username + "</td>";
	output += "<td>" + accountNumber + "</td>";
	output += "<td>" + address + "</td>";
	output += "<td>" + NIC + "</td>";
	output += "<td>" + phone + "</td>";
	output += "<td>" + role + "</td>";
	 // buttons
	output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-itemid='"+ userID + "'>" + "</td>"
	 + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"+ userID + "'>" + "</td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the users."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String insertUser(String username, String password, String accountNumber, String address, String NIC, String phone, String reset_code, String userRole) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting to the database for inserting."; 
			 } 
			 // create a prepared statement
			 String query = " insert into user (`userID`,`username`,`password`,`accountNumber`,`address`,`NIC`,`phone`, `reset_code`, `userRole`)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, username);
				preparedStmt.setString(3, password);
				preparedStmt.setInt(4, Integer.parseInt(accountNumber));
				preparedStmt.setString(5, address);
				preparedStmt.setString(6, NIC);
				preparedStmt.setString(7, phone);
				preparedStmt.setString(8, reset_code);
				preparedStmt.setString(9, userRole);
					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					 String newUsers = readUsers(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newUsers + "\"}"; 
					 } 
					 catch (Exception e) 
					 { 
					 output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
					 System.err.println(e.getMessage()); 
					 } 
					 return output; 
					 } 

}
