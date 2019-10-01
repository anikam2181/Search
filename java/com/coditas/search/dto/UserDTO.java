package com.coditas.search.dto;

import java.math.BigInteger;

public class UserDTO{
    

	BigInteger id;
	String name;
	String username;
	String avatar_url;
	String web_url;
	String source;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", username=" + username + ", avatar_url=" + avatar_url + ", web_url="
				+ web_url + ", source=" + source + "]";
	}

   
}
			
			