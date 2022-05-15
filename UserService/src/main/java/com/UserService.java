package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;


import model.User;

@Path("/Users")
public class UserService {

	User userObj = new User();

	//Get Users

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUsers() {
		return userObj.readUsers();
	}

	//Get User By ID

	@GET
	@Path("/getUserbyID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String UserProfileDetails(String userIdData) {
		//Convert the input string to a JSON object 
		JsonObject userObject = new JsonParser().parse(userIdData).getAsJsonObject();
		//Read the values from the JSON object
		String userId = userObject.get("userID").getAsString();
		
		if(userId.isEmpty()) 
		 {
			 return "User ID is required";
		 } 
		
		return userObj.readUserByID(userId);
	}

	//Create user account

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(String userData) {
		//Convert the input string to a JSON object 
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		//Read the values from the JSON object
		String username = userObject.get("username").getAsString();
		String password = userObject.get("password").getAsString();
		String accountNumber = userObject.get("accountNumber").getAsString();
		String address = userObject.get("address").getAsString();
		String NIC = userObject.get("NIC").getAsString();
		String phone = userObject.get("phone").getAsString();
		String reset_code = userObject.get("reset_code").getAsString();
		String userRole = userObject.get("userRole").getAsString();
		
		{	
			if(username.isEmpty()||password.isEmpty()||accountNumber.isEmpty()||address.isEmpty()||NIC.isEmpty()||phone.isEmpty()||reset_code.isEmpty()||userRole.isEmpty()) 
			 {
				 return "Input fields cannot be empty";
			 } 
			 else if(accountNumber.length()!=10) {
				 return "Account number must contain 10 digits";
			 }
			 else if(!NIC.matches("^([0-9]{9}[v|V])")){
				 return "Wrong NIC pattern and it should contain 10 digits";
			 }
			 else if(!phone.matches("(^\\d{10}$)")) {
				 return "Phone number should contain 10 digits and can't have any letters";
			 }
			 else if(password.length()<8||password.length()>20) {
				 return "Password must be more than 8 and less than 20 in length";
			 }
			
		}
			
		String output = userObj.insertUser(username, password, accountNumber, address, NIC, phone, reset_code, userRole);
		return output;
	}

	// Update user account

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData) {
		//Convert the input string to a JSON object 
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		//Read the values from the JSON object
		String userID = userObject.get("userID").getAsString();
		String username = userObject.get("username").getAsString();
		String password = userObject.get("password").getAsString();
		String accountNumber = userObject.get("accountNumber").getAsString();
		String address = userObject.get("address").getAsString();
		String NIC = userObject.get("NIC").getAsString();
		String phone = userObject.get("phone").getAsString();
		String userRole = userObject.get("userRole").getAsString();
		
		{	
			if(userID.isEmpty()||username.isEmpty()||password.isEmpty()||accountNumber.isEmpty()||address.isEmpty()||NIC.isEmpty()||phone.isEmpty()||userRole.isEmpty()) 
			 {
				 return "Input fields cannot be empty";
			 } 
			 else if(accountNumber.length()!=10) {
				 return "Account number must contain 10 digits";
			 }
			 else if(!NIC.matches("^([0-9]{9}[v|V])")){
				 return "Wrong NIC pattern and it should contain 10 digits";
			 }
			 else if(!phone.matches("(^\\d{10}$)")) {
				 return "Phone number should contain 10 digits and can't have any letters";
			 }
			 else if(password.length()<8||password.length()>20) {
				 return "Password must be more than 8 and less than 20 in length";
			 }
			
		}
		
		String output = userObj.updateUser(userID, username, password, accountNumber, address, NIC, phone, userRole);
		return output;
	}

	//Delete user account

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(String userData) {
		//Convert the input string to a JSON object 
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		//Read the values from the JSON object
		String userID = userObject.get("userID").getAsString();
		
		if(userID.isEmpty()) 
		 {
			 return "User ID is required";
		 } 
		
		String output = userObj.deleteUser(userID);
		return output;
	}
}
