package lk.asiripr.auth_02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth->auth
						.requestMatchers("/main.css").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(form->form
						.loginProcessingUrl("/perform_login")
						.loginPage("/login")
						.permitAll()
				)
				.logout(logout->logout
						.logoutSuccessUrl("/login?logout") 
						.logoutUrl("/logout")
						.permitAll()
				)
				.build();
	}
	@Bean
	UserDetailsService userDetailsService() {
		var user = User.withUsername("rohit").password("{noop}1234").build();
		return new InMemoryUserDetailsManager(user);
	}
}
