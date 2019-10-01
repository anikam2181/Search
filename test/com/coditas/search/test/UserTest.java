package com.coditas.search.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coditas.search.dao.RepositoryDAO;
import com.coditas.search.dao.UserDAO;

public class UserTest {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static RepositoryDAO repo;
	private String username="";
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coditas.Search");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		repo = (RepositoryDAO) context.getBean("RepositoryDAO");
	}
	
	@Test
	public void testAddUser() {
		assertEquals("Something went wrong while fetching the list of products!",
				1,repo.repo_github_list("anikammsft").size());	
	}
}
