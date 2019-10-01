package com.coditas.search.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coditas.search.dao.RepositoryDAO;
import com.coditas.search.dao.UserDAO;

public class RepositoryTest {

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
	public void testFindRpository() {
		assertEquals("Something went wrong while fetching the Repositories!",
				1,repo.repo_github_list("anikammsft").size());
		assertEquals("Something went wrong while fetching Repositories!",
						1,repo.repo_gitlab_list("Cintia.Santos").size());	
	}
}
