package com.api.pedido.controller;


import com.api.pedido.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @GetMapping
    public ResponseEntity<User> exibirTodos(){
        User user = new User(1L, "Mauricio", "teste@gmail.com", "19999662703", "123456");
        return ResponseEntity.ok().body(user);
    }
}
