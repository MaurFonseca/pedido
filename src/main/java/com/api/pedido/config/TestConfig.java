package com.api.pedido.config;


import com.api.pedido.model.User;
import com.api.pedido.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Mauricio", "maur@test.com", "19999662703", "123456");
        User u2 = new User(null, "Ana", "ana@test.com", "19999662905", "12345678");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
