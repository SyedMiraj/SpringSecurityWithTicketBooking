package com.miraj.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		secured with the matchers for user
//		http.csrf().disable().authorizeRequests().antMatchers("/api/user/**").
//		hasAnyRole("admin","user","super-admin").and().formLogin();
		
//		secured with the matchers for admin
//		http.csrf().disable().authorizeRequests().antMatchers("/api/admin/**").
//		hasAnyRole("admin","super-admin").and().formLogin();
		
		/*
		 * To combine multiple matchers in one line 
		 * 
		 * secured with matchers for both admin and user
		 * */
		
		http.csrf().disable().authorizeRequests().antMatchers("/api/user/**").hasAnyRole("admin","user","super-admin").
		and().authorizeRequests().antMatchers("/api/admin/**").hasAnyRole("admin","super-admin").and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
//		auth.inMemoryAuthentication().withUser("Miraj").password("miraj@123").roles("user","admin","super-admin");
//		auth.inMemoryAuthentication().withUser("Saddam").password("miraj@123").roles("user");
		
		/*
		 * To combine multiple user in one line 
		 * 
		 * secured with username and password for both admin and user
		 * */
		auth.inMemoryAuthentication().withUser("Miraj").password("miraj@123").roles("user","admin","super-admin").
		and().withUser("Saddam").password("miraj@123").roles("user");
		
		
	}
}
