package com.security.oauth.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
@EnableAuthorizationServer //register as authorization server
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdditionalTokenInfo additionalTokenInfo;
	
	/**
	 * security token registration for creation and validation
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()") //any client can access and generate the token POST /oauth/token
		.checkTokenAccess("isAuthenticated()"); //validates if the client is authenticated
	}

	/**
	 * Register the clients accessing the app,
	 * using it client ID and the client secrets
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
		.inMemory()
		.withClient(environment.getProperty("config.security.oauth.client.id"))//client ID
		.secret(encoder.encode(environment.getProperty("config.security.oauth.client.secret")))
		.scopes("read", "write")//client scope (write data)
		.authorizedGrantTypes("password", "refresh_token") //how it will get the token (user credentials user/passwd) 
		.accessTokenValiditySeconds(3600) //- refresh token allows to get a new token before becomes invalid
		.refreshTokenValiditySeconds(3600);
		//.and().withClient().... adding another client
	}

	/**
	 * Related to the oauth endpoint, where the JWT token will be
	 * generated and returned to the user to access the allowed
	 * resources
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		//enhances the token, adding claims
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(additionalTokenInfo, accessTokenConverter()));
		
		endpoints.authenticationManager(authenticationManager) //register the auth manager
		.tokenStore(tokenStore()) //save the jwtToken
		.accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhancerChain);// toker enhancer chain
	}

	/**
	 * creates ans stores the token
	 * @return
	 */
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	/**
	 * Stores the user data and claims into the jwt token
	 * takes the user data and store it into the token
	 * as base64 encoded data
	 * @return
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(environment.getProperty("config.security.oauth.jwt.key"));//secret for the token signature
		return tokenConverter;
	}
}
