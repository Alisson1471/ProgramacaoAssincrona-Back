package com.example.Secretaria.dto.response;

import com.example.Secretaria.model.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorResponse extends UserResponse {

    private Disciplina disciplina;

    private String matricula;

}
