package com.example.Secretaria.service;

import com.example.Secretaria.adapter.ObservacaoAdapter;
import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.ObservacaoRequest;
import com.example.Secretaria.dto.response.ObservacaoResponse;
import com.example.Secretaria.mapper.ObservacaoMapper;
import com.example.Secretaria.model.Observacao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObservacaoService {

    private final ObservacaoAdapter observacaoAdapter;
    private final AlunoService alunoService;
    private final ProfessorAdapter professorAdapter;
    private final ObservacaoMapper observacaoMapper;

    public ObservacaoResponse create(ObservacaoRequest request) {
        var aluno = alunoService.getAluno(request.getAlunoId());
        var professor = professorAdapter.findById(request.getProfessorId());

        var observacao = observacaoMapper.toObservacao(request, aluno, professor);
        var retorno = observacaoAdapter.create(observacao);

        return observacaoMapper.toResponse(retorno);
    }

    public List<ObservacaoResponse> get(Integer alunoId, Integer professorId) {
        List<Observacao> list;
        if (alunoId != null && professorId != null) {
            list = observacaoAdapter.getObservacaoByAlunoAndProfessor(alunoId, professorId);
        } else if (alunoId != null) {
            list = observacaoAdapter.getObservacaoByAluno(alunoId);
        } else if (professorId != null) {
            list = observacaoAdapter.getObservacaoByProfessor(professorId);
        } else {
            list = observacaoAdapter.getObservacoes();
        }

        return list.stream()
                .map(ObservacaoMapper::toResponse)
                .toList();
    }

    public Long getTotal() {
        return observacaoAdapter.getTotalObservacoes();
    }

    public void delete(Integer id) {
        var resultado = observacaoAdapter.delete(id);

        if (!resultado) {
            throw new EntityNotFoundException("Observacao não encontrada.");
        }
    }

}
