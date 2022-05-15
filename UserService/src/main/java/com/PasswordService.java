package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import model.Password;

@Path("/password")
public class PasswordService {
	Password password = new Password();

	@POST
	@Path("/loginUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String validateLogin(String loginData) 
	{
		//Convert the input string to a JSON object 
		JsonObject loginObject = new JsonParser().parse(loginData).getAsJsonObject();
		//Read the values from the JSON object
		String userName = loginObject.get("username").getAsString();
		String passWord = loginObject.get("password").getAsString();
		
		if(userName.isEmpty() || passWord.isEmpty()) 
		 {
			 return "Username & Password fields cannot be empty";
		 } 
		String output = password.loginUser(userName, passWord);
		return output;
	}

	@PUT
	@Path("/resetPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String resetPassword(String resetData) 
	{
		//Convert the input string to a JSON object 
		JsonObject resetObject = new JsonParser().parse(resetData).getAsJsonObject();
		//Read the values from the JSON object
		String userCode = resetObject.get("usercode").getAsString();
		String newpassword = resetObject.get("newpassword").getAsString();
		
		if(userCode.isEmpty() || newpassword.isEmpty()) 
		 {
			 return "Usercode & Newpassword fields cannot be empty";
		 } 
		else if(newpassword.length()<8||newpassword.length()>20) {
			 return "Password must be more than 8 and less than 20 in length";
		 }
		
		String output = password.resetPassword(userCode,newpassword);
		return output;
	}
}
