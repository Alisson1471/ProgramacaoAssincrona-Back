package com.example.Secretaria.service;

import com.example.Secretaria.DisciplinaAdapter;
import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.mapper.ProfessorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorAdapter professorAdapter;
    private final ProfessorMapper professorMapper;
    private final DisciplinaAdapter disciplinaAdapter;

    public List<ProfessorResponse> list() {
        var list = professorAdapter.findAll();
        return list.stream()
                .map(professorMapper::convertToResponse)
                .toList();
    }

    public ProfessorResponse findProfessorById(Integer id) {
        var professor = professorAdapter.findById(id);
        return professorMapper.convertToResponse(professor);
    }

    public ProfessorResponse createProfessor(ProfessorRequest request) {
        professorAdapter.verifyExists(request.getCpf());

        var disciplina = disciplinaAdapter.findByName(request.getDisciplina());

        var professor = professorMapper.convertToEntity(request, disciplina);

        professorAdapter.create(professor);

        return professorMapper.convertToResponse(professor);
    }

}
