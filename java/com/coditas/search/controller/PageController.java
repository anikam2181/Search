package com.coditas.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coditas.search.dao.RepositoryDAO;
import com.coditas.search.dao.UserDAO;
import com.coditas.search.dto.RepositoryDTO;
import com.coditas.search.dto.UserDTO;

@Controller
public class PageController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RepositoryDAO repositoryDAO;
	
	@RequestMapping("/")
	public String display() {
		return "index";
	}

	@RequestMapping(value = "/searchuser")
	public ModelAndView Result(HttpServletRequest request) {
		String username = request.getParameter("name");
		ModelAndView mv = new ModelAndView("user");
		 UserDTO gituser=userDAO.get_github_user(username); 
		 UserDTO gitlabuser=userDAO.get_gitlab_user(username);
		 mv.addObject("github",gituser);
		 mv.addObject("gitlab",gitlabuser); 
		return mv;
	}

	@RequestMapping(value = "/{username}/repo")
	public ModelAndView getResult(@PathVariable String username) {
		ModelAndView mv = new ModelAndView("repository");
		List<RepositoryDTO> repository=repositoryDAO.repo_github_list(username);
		List<RepositoryDTO> project=repositoryDAO.repo_gitlab_list(username); 
		 mv.addObject("repository",repository);
		 mv.addObject("project",project); 
		return mv;
	}
}