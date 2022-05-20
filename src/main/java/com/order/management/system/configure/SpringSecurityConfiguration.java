//package com.order.management.system.configure;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("alwaysBest").password("AlwaysBest").roles("Customer")
//		.and().withUser("colmart").password("Colmart").roles("Customer")
//		.and().withUser("top").password("top").roles("Customer");
//		
//		
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//		.antMatchers("/login","/create").hasRole("Customer")
//		.and().formLogin().loginPage("/loginCustomer");
//		
//	}
//}
