package com.security.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.security.commons.entity.User;
import com.security.oauth.service.IUserService;

/**
 * Allow to add additional info into the token
 * add claims to the token
 * @author diego.nieto
 *
 */
@Component
public class AdditionalTokenInfo implements TokenEnhancer {

	@Autowired
	IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userService.findByUserName(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("name", user.getName());
		info.put("lastname", user.getLastname());
		info.put("email", user.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}
