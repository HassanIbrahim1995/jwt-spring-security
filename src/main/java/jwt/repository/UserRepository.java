package jwt.repository;

import jwt.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<AppUser> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);
}
