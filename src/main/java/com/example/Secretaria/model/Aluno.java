package com.example.Secretaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "campo 'nome' não pode ser vazio")
    private String nome;

    @NotNull(message = "campo 'usuario' não pode ser vazio")
    private String usuario;

    @NotNull(message = "campo 'senha' não pode ser vazio")
    private String senha;

    @NotNull(message = "campo 'cpf' não pode ser vazio")
    private String cpf;

    @NotNull(message = "campo 'matricula' não pode ser vazio")
    private String matricula;

}
