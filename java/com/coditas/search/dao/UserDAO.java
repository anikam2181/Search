package com.coditas.search.dao;

import java.util.List;

import com.coditas.search.dto.UserDTO;

public interface UserDAO {

	UserDTO get_github_user(String username);

	UserDTO get_gitlab_user(String username);
}
