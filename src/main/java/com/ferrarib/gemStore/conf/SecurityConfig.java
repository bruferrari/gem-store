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
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/user").authenticated()
			.antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
			.antMatchers("/productManager.jsp").hasRole("ADMIN")
			.antMatchers("/newProduct.jsp").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and().formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDao);
	}

}
