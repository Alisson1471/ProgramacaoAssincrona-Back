package com.example.Secretaria.service;

import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.ProfessorResponse;
import com.example.Secretaria.mapper.ProfessorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorAdapter professorAdapter;

    private final ProfessorMapper professorMapper;

    public NotaResponse lancarNota(NotaRequest request, int professorId) {
        return null;
    }
}
