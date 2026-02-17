package com.example.Secretaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorRequest {

    private String nome;
    private String cpf;
    private String disciplina;
    private int adminId;

}
