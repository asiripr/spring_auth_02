package lk.asiripr.auth_02.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.asiripr.auth_02.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
 
}
