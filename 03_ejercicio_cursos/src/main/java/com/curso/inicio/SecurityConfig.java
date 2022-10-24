package com.curso.inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{	
	//definición roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("GUEST")
          .and()
        .withUser("user2")
          .password("{noop}user2") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("OPERATOR")
          .and()
        .withUser("user3")
          .password("{noop}user3") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("ADMIN")
          .and()
        .withUser("user4")
          .password("{noop}user4")
          .roles("OPERATOR", "ADMIN");
		
	}
	//definición de políticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/curso").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/curso").hasAnyRole("ADMIN", "OPERATOR")
		.antMatchers(HttpMethod.DELETE,"/curso/{codCurso}").hasAnyRole("ADMIN", "OPERATOR")
		.antMatchers("/cursos").authenticated()
		.and()
		.httpBasic();
	
	}
}
