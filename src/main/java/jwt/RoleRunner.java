package jwt;

import jwt.model.Role;
import jwt.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleRunner(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save the roles
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        System.out.println("Roles saved successfully.");
    }
}

