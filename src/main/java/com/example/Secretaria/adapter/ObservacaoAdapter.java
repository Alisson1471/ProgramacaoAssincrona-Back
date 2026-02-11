package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Observacao;
import com.example.Secretaria.repository.ObservacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ObservacaoAdapter {

    private final ObservacaoRepository observacaoRepository;

    public Observacao create(Observacao observacao) {
        return observacaoRepository.save(observacao);
    }

    public List<Observacao> getObservacoes() {
        var list = observacaoRepository.findAll();

        if (list.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma observação salva.");
        }

        return list;
    }

    public List<Observacao> getObservacaoByAluno(Integer alunoId) {
        var list = observacaoRepository.findByAluno_Id(alunoId);

        if (list.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma observação do aluno com id "+alunoId+" salva.");
        }

        return list.get();
    }

    public List<Observacao> getObservacaoByProfessor(Integer professorId) {
        var list = observacaoRepository.findByProfessor_Id(professorId);

        if (list.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma observação do professor com id "+professorId+" salva.");
        }

        return list.get();
    }

    public List<Observacao> getObservacaoByAlunoAndProfessor(Integer alunoId, Integer professorId) {
        var list = observacaoRepository.findByAluno_IdAndProfessor_Id(alunoId, professorId);

        if (list.isEmpty()) {
            throw new EntityNotFoundException("Nenhuma observação do professor com id "+ professorId +" salva," +
                    " para o aluno com id "+ alunoId +".");
        }

        return list.get();
    }

    public boolean delete(Integer id) {
        observacaoRepository.deleteById(id);
        return !observacaoRepository.existsById(id);
    }

}
