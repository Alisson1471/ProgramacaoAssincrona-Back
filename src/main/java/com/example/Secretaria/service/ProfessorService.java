package com.example.Secretaria.service;

import com.example.Secretaria.DisciplinaAdapter;
import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.adapter.NotaAdapter;
import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.mapper.NotaMapper;
import com.example.Secretaria.mapper.ProfessorMapper;
import com.example.Secretaria.model.Professor;
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

        var disciplina = disciplinaAdapter.findByName(request.getNome());

        var professor = professorMapper.convertToEntity(request, disciplina, null);

        professorAdapter.create(professor);

        return professorMapper.convertToResponse(professor);
    }

}
