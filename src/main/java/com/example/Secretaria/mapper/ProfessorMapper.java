package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public UserResponse convertToResponse(Professor professor) {
        var userResponse = new UserResponse();
        userResponse.setId(professor.getId());
        userResponse.setNome(professor.getNome());
        userResponse.setCpf(professor.getCpf());
        userResponse.setUsuario(professor.getUsuario());
        userResponse.setSenha(professor.getSenha());
        userResponse.setMatricula(professor.getMatricula());

        var disciplina = professor.getDisciplina();

        if (disciplina != null) {
            userResponse.setDisciplina(disciplina.getNome());

        }

        return userResponse;
    }

}
