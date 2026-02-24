package com.example.Secretaria.adapter;

import com.example.Secretaria.dto.response.NotaDisciplinaAlunoResponse;
import com.example.Secretaria.dto.response.NotaDisciplinaResponse;
import com.example.Secretaria.dto.response.NotaResponseDTO;
import com.example.Secretaria.dto.response.StatusDisciplineResponse;
import com.example.Secretaria.mapper.NotaMapper;
import com.example.Secretaria.model.Nota;
import com.example.Secretaria.repository.NotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class NotaAdapter {

    private final NotaRepository notaRepository;

    private final NotaMapper notaMapper;

    public Nota save(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<NotaResponseDTO> findByAluno(int id) {
        var notas = notaRepository.findByAluno_Id(id);

        if (notas == null) {
            throw new EntityNotFoundException("Notas não encontradas!");
        }

        return notas;
    }

    public Nota findById(Integer id) {
        var nota = notaRepository.findById(id);

        if (nota.isEmpty()) {
            throw new EntityNotFoundException("Nota não encontrado!");
        }

        return nota.get();
    }

    public List<StatusDisciplineResponse> statusDisciplinas() {
        var retorno = notaRepository.findStatusDiscipline();

        if (retorno == null) {
            throw new EntityNotFoundException("Notas não encontradas!");
        }

        return retorno;
    }

    public List<NotaDisciplinaResponse> statusDisciplinasByAluno(Integer alunoId) {
        var notas = notaRepository.findStatusDisciplinaByAlunoId(alunoId);

        if (notas.isEmpty()) {
            throw new EntityNotFoundException("Notas não encontradas!");
        }

        return notas.stream()
                .map(notaMapper::convertToNotaDisciplina)
                .toList();
    }

}
