package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.request.NotaRequest;
import com.example.Secretaria.dto.response.NotaResponse;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.model.Nota;
import com.example.Secretaria.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public Nota convertToNota(NotaRequest request, Professor professor, Aluno aluno) {
        return new Nota(request.getTitulo(),
                request.getNota(),
                professor,
                professor.getDisciplina(),
                aluno);
    }

    public NotaResponse convertToNotaResponse(Nota nota, String aluno, String disciplina) {
        return new NotaResponse(aluno,
                nota.getTitulo(),
                nota.getValor(),
                disciplina);
    }

    public NotaResponse convertToNotaResponse(Nota nota) {
        return new NotaResponse(nota.getAluno().getNome(),
                nota.getTitulo(),
                nota.getValor(),
                nota.getDisciplina().getNome());
    }

}
