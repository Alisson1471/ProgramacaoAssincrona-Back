package com.example.Secretaria.service;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.adapter.NotaAdapter;
import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.mapper.NotaMapper;
import com.example.Secretaria.mapper.ProfessorMapper;
import com.example.Secretaria.model.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorAdapter professorAdapter;

    private final ProfessorMapper professorMapper;

    public ProfessorResponse findProfessorById(Integer id) {
        var professor = professorAdapter.findById(id);
        return professorMapper.convertToResponse(professor);
    }
}
