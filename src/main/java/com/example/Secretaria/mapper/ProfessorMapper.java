package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorResponse convertToResponse(Professor professor) {
        var professorResponse = new ProfessorResponse();
        professorResponse.setId(professor.getId());
        professorResponse.setNome(professor.getNome());
        professorResponse.setCpf(professor.getCpf());
        professorResponse.setUsuario(professor.getUsuario());
        professorResponse.setMatricula(professor.getMatricula());

        var disciplina = professor.getDisciplina();

        if (disciplina != null) {
            professorResponse.setDisciplina(disciplina.getNome());

        }

        return professorResponse;
    }

}
