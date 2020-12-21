package com.service.zuul.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@RefreshScope
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${config.security.oauth.jwt.key}")
	private String jwtKey;
	//@Autowired
	//private Environment environment;
	
	/**
	 * to protect the token
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	/**
	 * To protect private routes and resources (endpoints)
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll() //public anyone can access the endpoint
		.antMatchers(HttpMethod.GET, "/api/products/find", "/api/items/query", "/api/users/user-repo").permitAll()
		.antMatchers(HttpMethod.GET, "/api/products/find/{id}", "/query/{id}/quantity/{quantity}", "/api/users/user-repo/get-by-username").hasAnyRole("ADMIN", "USER")		
		.antMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
		.anyRequest().authenticated() //any other URL that isn't defined must be accesed authenticated
		// Adding CORS configuration (Cross-origin resource sharing)
		// resource exchange between application placed in different servers
		// Through HTTP headers
		.and().cors().configurationSource(corsConfigurationSource());
	}
	/**
	This configurations are optional, just in case
	that our clients resides in another domain e.g. a react client
	hosted in other domain**/
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		// set allowed clients
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		// Set allowed methods
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		corsConfig.setAllowCredentials(true);
		// Allowed headers
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}

	/** Creates a filter for the entire application not just for spring security */
	@Bean 
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}
	
	
	@Bean
	public JwtTokenStore tokenStore() {
		JwtTokenStore tokenStorage = new JwtTokenStore(accessTokenConverter());
		return tokenStorage;
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtKey); //same secret kay as the token generator
		return tokenConverter;
	}
}
