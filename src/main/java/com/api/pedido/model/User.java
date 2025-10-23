package com.api.pedido.model;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;
}
