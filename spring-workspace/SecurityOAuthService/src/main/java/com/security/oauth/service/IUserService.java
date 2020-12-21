package com.security.oauth.service;

import com.security.commons.entity.User;

public interface IUserService {

	User findByUserName(String username);
	
	public User updateUser(User user, Long id);
}
