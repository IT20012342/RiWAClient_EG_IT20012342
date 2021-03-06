package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAPI
 */
@WebServlet("/UserAPI")
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User userObj = new User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 {
		 String[] p = param.split("="); 
		 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
		}
	
    public UserAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 String output = userObj.insertUser(
			request.getParameter("username"), 
			request.getParameter("password"), 
			 request.getParameter("accountNumber"), 
			request.getParameter("address"), 
			request.getParameter("nic"),
			request.getParameter("phone"),
			request.getParameter("resetCode"),
			request.getParameter("userRole"));
			response.getWriter().write(output); 
			}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 Map paras = getParasMap(request); 
			 String output = userObj.updateUser(
			paras.get("hidItemIDSave").toString(), 
			 paras.get("username").toString(), 
			paras.get("password").toString(), 
			paras.get("accountNumber").toString(), 
			paras.get("address").toString(),
			paras.get("nic").toString(), 
			paras.get("phone").toString(),
			paras.get("resetCode").toString(),
			paras.get("userRole").toString()); 
			response.getWriter().write(output); 
			} 
	
			protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 Map paras = getParasMap(request); 
			 String output = userObj.deleteUser(paras.get("userID").toString()); 
			response.getWriter().write(output); 
			}

}
