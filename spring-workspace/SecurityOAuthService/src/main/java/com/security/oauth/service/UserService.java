package com.security.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.commons.entity.User;
import com.security.oauth.client.UserFeignClient;

import brave.Tracer;
import feign.FeignException;

@Service
public class UserService implements UserDetailsService, IUserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private Tracer tracer;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			User user = userFeignClient.findByUserName(username);
			
			List<GrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.peek(authority -> log.info("Role: " + authority.getAuthority()))
					.collect(Collectors.toList());

			String message = "Authenticated User: " + username;
			log.info(message);
			tracer.currentSpan().tag("info.message", message);
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), 
			user.getEnabled(), true, true, true, authorities);
		} catch(FeignException e) {
			String message = "Nonexistent User" + username; 
			log.error(message);
			tracer.currentSpan().tag("error.message", message);
			throw new UsernameNotFoundException(message);
		}
	}

	@Override
	public User findByUserName(String username) {
		return userFeignClient.findByUserName(username);
	}

	@Override
	public User updateUser(User user, Long id) {
		return userFeignClient.updateUser(user, id);
	}
}
