package vti.com.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import vti.com.config.exceptionHandler.AuthExceptionHandler;
import vti.com.service.IAccountService;

@Component
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private IAccountService service;
	
	@Autowired
	private AuthExceptionHandler exceptionHandler;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		
		
	}
	protected void configure(HttpSecurity http)  throws Exception{
		http
		.cors()
		.and()
		.exceptionHandling()
			.authenticationEntryPoint(exceptionHandler)
			.accessDeniedHandler(exceptionHandler)
		.and()
		.authorizeRequests()
			.antMatchers("/api/v1/departments/**").hasAnyAuthority("ADMIN", "MANAGER")
			.antMatchers("/api/v1/accounts/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
		
	}
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
	    configuration.applyPermitDefaultValues();
	    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	

}
