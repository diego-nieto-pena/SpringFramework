package com.security.oauth.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.security.commons.entity.User;
import com.security.oauth.service.IUserService;

import brave.Tracer;
import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private Tracer tracer;
	
	/**
	 * With the authentication object we can get the authenticated
	 * user information
	 */
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String message = "Successful login: " + user.getUsername() + user.getPassword(); 
		logger.info(message);
		tracer.currentSpan().tag("info.message", message);
		User loggedUser = userService.findByUserName(authentication.getName());
		
		if(loggedUser.getTries() != null && loggedUser.getTries() > 0) {
			loggedUser.setTries(0);
			userService.updateUser(loggedUser, loggedUser.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String userName = authentication.getName();
		
		StringBuilder message = new StringBuilder();
		message.append("Failed to login with user: " + userName);
		try {
			User user = userService.findByUserName(userName);
			if(user.getTries() == null) {
				user.setTries(0);
			}
			
			user.setTries(user.getTries() + 1);
			
			if(user.getTries() >= 3) {
				logger.info(String.format("Blocked user %s, number of login tries exceeded!", userName));
				message.append(String.format("Blocked user %s, number of login tries exceeded!", userName));
				user.setEnabled(false);
			}
			
			userService.updateUser(user, user.getId());
			logger.info(message.toString());
			tracer.currentSpan().tag("error.message", message.toString());
			
		} catch(FeignException e) {
			logger.error(String.format("The user %s doesn't exists: ", userName));
			message.append(String.format("The user %s doesn't exists: ", userName));
			tracer.currentSpan().tag("error.message", message.toString());
		}
		
		logger.error("Login failed: " + exception.getMessage());
	}
}
