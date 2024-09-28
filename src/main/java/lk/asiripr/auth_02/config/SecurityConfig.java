//package lk.asiripr.auth_02.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	 http
//     .authorizeHttpRequests(auth -> auth
//         .requestMatchers("/admin/**").hasRole("ADMIN")
//         .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Allow access to login page and static resources
//         .anyRequest().authenticated()
//     )
//     .formLogin(login -> login
//         .loginPage("/login") 
//         .loginProcessingUrl("/perform_login") 
//         .defaultSuccessUrl("/home", true) // Redirect to home after successful login
//         .failureUrl("/login?error=true") // Redirect here on failed login
//         .permitAll()
//     )
//     .logout(logout -> logout
//         .logoutSuccessUrl("/login?logout=true") // Redirect here after logout
//         .permitAll()
//     );
//	return null;
//	
//}
//}
