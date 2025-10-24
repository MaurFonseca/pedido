package com.api.pedido.config;


import com.api.pedido.model.Order;
import com.api.pedido.model.User;
import com.api.pedido.repository.OrderRepository;
import com.api.pedido.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Mauricio", "maur@test.com", "19999662703", "123456", null);
        User u2 = new User(null, "Ana", "ana@test.com", "19999662905", "12345678", null);

        Order o1 = new Order(null, LocalDateTime.now(), u1);
        Order o2 = new Order(null, LocalDateTime.now(), u2);
        Order o3 = new Order(null, LocalDateTime.now(), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
