package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.model.Admin;
import com.example.Secretaria.model.Disciplina;
import com.example.Secretaria.model.Professor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    private final PasswordEncoder passwordEncoder;

    public ProfessorMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public ProfessorResponse convertToResponse(Professor professor) {
        var professorResponse = new ProfessorResponse();
        professorResponse.setId(professor.getId());
        professorResponse.setNome(professor.getNome());
        professorResponse.setCpf(professor.getCpf());
        professorResponse.setSenha((professor.getSenha()));
        professorResponse.setMatricula(professor.getMatricula());

        var disciplina = professor.getDisciplina();

        if (disciplina != null) {
            professorResponse.setDisciplina(disciplina);

        }

        return professorResponse;
    }

    public Professor convertToEntity(ProfessorRequest request, Disciplina disciplina) {
        var professor = new Professor();
        professor.setCpf(request.getCpf());
        professor.setNome(request.getNome());
        professor.setDisciplina(disciplina);
        String senhaCriptografada = passwordEncoder.encode("123456");
        professor.setSenha(senhaCriptografada);
        professor.setMatricula("0001-"+request.getCpf());
        return professor;

    }

}
