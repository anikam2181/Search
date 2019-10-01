package com.coditas.search.daoimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.coditas.search.dao.UserDAO;
import com.coditas.search.dto.UserDTO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {


	public UserDTO get_github_user(String username){
			UserDTO gituser=new UserDTO();
			String url = "https://api.github.com/users/"+username; 
	     try {
	    	 URL obj = new URL(url);
		     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		     // optional default is GET
		     con.setRequestMethod("GET");
		     //add request header
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     int responseCode = con.getResponseCode();
		     System.out.println("Response Code : " + responseCode);
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     System.out.println(response.toString());
		     JSONObject myResponse = new JSONObject(response.toString());
		     gituser.setId(myResponse.getBigInteger("id"));
		     gituser.setName(myResponse.getString("name"));
		     gituser.setAvatar_url(myResponse.getString("avatar_url"));
		     gituser.setUsername(myResponse.getString("login"));
		     gituser.setWeb_url(myResponse.getString("html_url"));
		     gituser.setSource("Github");
	     }catch(Exception e) {
	    	 System.out.print(e);
	     }	    
	     return gituser;
	}

	public UserDTO get_gitlab_user(String username) {
		UserDTO gitlabuser=new UserDTO();
	     String url = "https://gitlab.com/api/v4/users?username="+username;
	     try {
	    	 
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     System.out.println(response.toString());
	     System.out.println((response.toString()).length());
	     String result=response.substring(1);
	     result=result.substring(0, result.length() - 1);
	     System.out.println(result);
	     JSONObject myResponse = new JSONObject(result.toString());
	     gitlabuser.setId(myResponse.getBigInteger("id"));
	     gitlabuser.setName(myResponse.getString("name"));
	     gitlabuser.setAvatar_url(myResponse.getString("avatar_url"));
	     gitlabuser.setUsername(myResponse.getString("username"));
	     gitlabuser.setWeb_url(myResponse.getString("web_url"));
	     gitlabuser.setSource("GitLab");
	     return gitlabuser;
	     }catch(Exception e) {
	    	 System.out.print(e);
	     }	    
	     return gitlabuser;
	   }
}
