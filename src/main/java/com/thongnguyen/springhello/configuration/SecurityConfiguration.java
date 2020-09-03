package com.thongnguyen.springhello.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
								.antMatchers("/book/**").hasAnyRole("ADMIN","USER")
								.anyRequest().permitAll()
			.and().formLogin().loginPage("/login").loginProcessingUrl("/login")
								.usernameParameter("username")
								.passwordParameter("password")
								.failureUrl("/login")
			.and().logout().logoutSuccessUrl("/login")
			.and().exceptionHandling().accessDeniedPage("/accessDenied");	
	}	
		
		
//		http.csrf().disable()
//			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/book/**").hasAnyRole("USER","ADMIN")
//			.anyRequest().permitAll()
//			.and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.failureUrl("/login")
//			.and().logout().logoutSuccessUrl("/login")
//			.and().exceptionHandling().accessDeniedPage("/accessDenied");
	
	
}
