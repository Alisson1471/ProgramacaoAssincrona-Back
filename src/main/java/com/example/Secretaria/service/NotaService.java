package com.example.Secretaria.service;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.adapter.NotaAdapter;
import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.dto.response.NotaResponseDTO;
import com.example.Secretaria.dto.response.StatusDisciplineResponse;
import com.example.Secretaria.mapper.NotaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NotaService {

    private final ProfessorAdapter professorAdapter;

    private final AlunoAdapter alunoAdapter;

    private final NotaMapper notaMapper;

    private final NotaAdapter notaAdapter;

    public List<NotaResponseDTO> getNotas(int alunoId) {
        return notaAdapter.findByAluno(alunoId);
    }

    public NotaResponse create(NotaRequest request, int professorId) {
        var professor = professorAdapter.findById(professorId);
        var aluno = alunoAdapter.findById(request.getAlunoId());
        var nota = notaMapper.convertToNota(request, professor, aluno);

        notaAdapter.save(nota);

        return notaMapper.convertToNotaResponse(nota,
                aluno.getNome(),
                professor.getDisciplina().getNome());
    }

    public NotaResponse update(Integer notaId, BigDecimal novaNota) {
        var nota = notaAdapter.findById(notaId);

        nota.setValor(novaNota);

        var nota2 = notaAdapter.save(nota);

        return notaMapper.convertToNotaResponse(nota2);
    }

    public List<StatusDisciplineResponse> statusByDiscipline() {
        return notaAdapter.statusDisciplinas();
    }

}
