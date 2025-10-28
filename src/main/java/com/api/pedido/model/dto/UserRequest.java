package com.api.pedido.model.dto;

public record UserRequest (String name,
                           String email,
                           String phone,
                           String password){
}
