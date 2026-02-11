package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.request.ObservacaoRequest;
import com.example.Secretaria.dto.response.ObservacaoResponse;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.model.Observacao;
import com.example.Secretaria.model.Professor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ObservacaoMapper {

    public Observacao toObservacao(ObservacaoRequest request, Aluno aluno, Professor professor) {
        Observacao observacao = new Observacao();
        observacao.setAluno(aluno);
        observacao.setProfessor(professor);
        observacao.setTexto(request.getText());
        observacao.setDataCriacao(OffsetDateTime.now());
        return observacao;
    }

    public static ObservacaoResponse toResponse(Observacao observacao) {
        ObservacaoResponse response = new ObservacaoResponse();
        response.setAluno(observacao.getAluno().getNome());
        response.setProfessor(observacao.getProfessor().getNome());
        response.setText(observacao.getTexto());
        response.setData(observacao.getDataCriacao());
        return response;
    }

}
