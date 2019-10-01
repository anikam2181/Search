package com.coditas.search.dao;

import java.util.List;

import com.coditas.search.dto.RepositoryDTO;

public interface RepositoryDAO {
		List<RepositoryDTO> repo_github_list(String username);
		
		List<RepositoryDTO> repo_gitlab_list(String username);
}
