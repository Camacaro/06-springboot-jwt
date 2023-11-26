package com.jesus.courses.springboot.jwtauthenticationserver.app.config;

import com.jesus.courses.springboot.jwtauthenticationserver.app.models.Role;
import com.jesus.courses.springboot.jwtauthenticationserver.app.models.User;
import com.jesus.courses.springboot.jwtauthenticationserver.app.repositories.UserRepository;
import com.jesus.courses.springboot.jwtauthenticationserver.app.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeedDataConfig implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        if (userService.count() == 0) {
            User admin = User.builder()
                    .firstName("admin")
                    .lastName("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("password"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userService.save(admin);
            log.debug("Created ADMIN user - {}", admin);
        }
    }
}
