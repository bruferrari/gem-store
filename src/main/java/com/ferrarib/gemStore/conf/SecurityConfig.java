package com.ferrarib.gemStore.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ferrarib.gemStore.dao.UserDAO;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.formLogin().and()
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/user").authenticated()
			.antMatchers(HttpMethod.DELETE, "/api/products/**").authenticated()
			.antMatchers(HttpMethod.DELETE, "/api/users/**").authenticated()
			.antMatchers(HttpMethod.GET, "/api/users").authenticated()
			.antMatchers(HttpMethod.POST, "/api/products").authenticated()
			.antMatchers("/productManager.jsp").authenticated()
			.antMatchers("/newProduct.jsp").authenticated()
			.anyRequest().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDao);
	}

}
