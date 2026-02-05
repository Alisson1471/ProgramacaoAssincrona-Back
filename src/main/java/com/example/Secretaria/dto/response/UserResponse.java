package com.example.Secretaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;

    private String nome;

    private String usuario;

    private String senha;

    private String cpf;
    
}
