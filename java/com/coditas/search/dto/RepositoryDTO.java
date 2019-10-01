package com.coditas.search.dto;

import java.math.BigInteger;

public class RepositoryDTO {

	BigInteger id;
	String name;
	String html_url;
	String description;
	String created_at;
	String updated_at;
	
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
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString() {
		return "RepositoryDTO [id=" + id + ", name=" + name + ", html_url=" + html_url + ", description=" + description
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}	
}
