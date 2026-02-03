package com.example.Secretaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaResponse {

    private String aluno;

    private String titulo;

    private Double nota;

    private String disciplina;

}
