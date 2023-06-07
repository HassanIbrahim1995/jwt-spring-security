package jwt.controller;

import jwt.model.AppUser;
import jwt.model.Role;
import jwt.repository.RoleRepository;
import jwt.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDto createUserDto) {
        // Create a new user entity
        AppUser user = new AppUser();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());

        // Encode the password using the password encoder
        String encodedPassword = passwordEncoder.encode(createUserDto.getPassword());
        user.setPassword(encodedPassword);

        Optional<Role> roleOptional = roleRepository.findByName(createUserDto.getRoleName().toUpperCase(Locale.ROOT));
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            user.setRoles(Set.of(role));
        } else {
            // Handle the case when no role is found
        }

        // Save the user to the database
        userRepository.save(user);

        return ResponseEntity.ok("User created successfully.");
    }


}
