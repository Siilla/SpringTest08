package com.rubypaper.board.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	SecurityConfig(){
		 System.out.println("===> SecurityConfig 생성자확인" );
	}
		
	
	@Autowired
	private  BoardUserDetailsService  BoardUserDetails;
	
	@Override
	protected   void  configure(HttpSecurity  security) throws Exception {
		
		System.out.println("===> void  configure ");
		
		security.authorizeRequests().antMatchers("/","/system/**").permitAll();
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		security.csrf().disable();
	
		security.formLogin().loginPage("/system/login.do").defaultSuccessUrl("/board/getBoardList.do", true); // (1)
		security.exceptionHandling().accessDeniedPage("/system/accessDenied.do");
		security.logout().logoutUrl("/system/logout.do").invalidateHttpSession(true).logoutSuccessUrl("/");
		security.userDetailsService(BoardUserDetails); // (2)
		// (1) 번은 username 와 password 를 받아온다.
		// (2) 테이블의 값을 받아온다. 
		// (1) 번과 (2)번이 이 매핑되어 인증을 체크한다.		
	}	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("manager")
//		.password("{noop}manager123")
//		.roles("MANAGER");
//		
//		auth.inMemoryAuthentication().withUser("admin")
//		.password("{noop}admin123")
//		.roles("ADMIN");
//	}
	
	
}
