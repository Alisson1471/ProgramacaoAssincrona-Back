package com.example.Secretaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "campo 'nome' não pode ser vazio")
    private String nome;

    @NotNull(message = "campo 'usuario' não pode ser vazio")
    private String usuario;

    @NotNull(message = "campo 'senha' não pode ser vazio")
    private String senha;
}
