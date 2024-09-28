package lk.asiripr.auth_02.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lk.asiripr.auth_02.models.*;
import lk.asiripr.auth_02.repositories.UserRepository;

@Service
public class CustomUserDetailsServices implements UserDetailsService{

	private final UserRepository userRepository;
	
	
	public CustomUserDetailsServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Sorry! User not found."));
		
		return org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}

}
