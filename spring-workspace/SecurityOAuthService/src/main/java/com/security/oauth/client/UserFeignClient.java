package com.security.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.commons.entity.User;

@FeignClient("user-service")
public interface UserFeignClient {

	@GetMapping(path = "/user-repo/search/get-by-username")
	public User findByUserName(@RequestParam String username);
	
	@PutMapping(path="/user-repo/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id);
}
