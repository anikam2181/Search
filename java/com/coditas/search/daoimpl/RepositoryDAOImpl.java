package com.coditas.search.daoimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.coditas.search.dao.RepositoryDAO;
import com.coditas.search.dto.RepositoryDTO;

@Repository("RepositoryDAO")
public class RepositoryDAOImpl implements RepositoryDAO {

	@Override
	public List<RepositoryDTO> repo_github_list(String username) {
		List<RepositoryDTO> repo_list=new ArrayList();
	     String url = "https://api.github.com/users/"+username+"/repos";
	     try {
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     con.setRequestMethod("GET");
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     JSONArray jsonArray = new JSONArray(response.toString());
	     for(int i=0; i<jsonArray.length(); i++) {
	         JSONObject jsonObject = jsonArray.getJSONObject(i);
	         RepositoryDTO repo=new RepositoryDTO();
	         repo.setId(jsonObject.getBigInteger("id"));
	         repo.setName(jsonObject.getString("name"));
	         repo.setDescription(jsonObject.getString("description"));
	         repo.setHtml_url(jsonObject.getString("html_url"));
	         repo.setCreated_at(jsonObject.getString("created_at"));
	         repo.setUpdated_at(jsonObject.getString("updated_at"));
	         repo_list.add(repo);
	     }
	     }
	     catch(Exception e) {
	    	 System.out.print(e);
	     }	    
		return repo_list;
	   
	}

	@Override
	public List<RepositoryDTO> repo_gitlab_list(String username) {
		List<RepositoryDTO> repo_list=new ArrayList();
	     String url = "https://gitlab.com/api/v4/users/"+username+"/projects";
		try {
			URL obj = new URL(url);
		     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		     con.setRequestMethod("GET");
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     JSONArray jsonArray = new JSONArray(response.toString());
		     for(int i=0; i<jsonArray.length(); i++) {
		         JSONObject jsonObject = jsonArray.getJSONObject(i);
		         RepositoryDTO repo=new RepositoryDTO();
		         repo.setId(jsonObject.getBigInteger("id"));
		         repo.setName(jsonObject.getString("name"));
		         repo.setDescription(jsonObject.getString("description"));
		         repo.setHtml_url(jsonObject.getString("web_url"));
		         repo.setCreated_at(jsonObject.getString("created_at"));
		         repo.setUpdated_at(jsonObject.getString("last_activity_at"));
		         repo_list.add(repo);
		     }
		}catch(Exception e) {
	    	 System.out.print(e);
	     }
		return repo_list;	    
	}

}
