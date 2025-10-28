package com.api.pedido.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StandardError {

    private String message;
    private int status;
    private String timestamp;
    private String path;
}
