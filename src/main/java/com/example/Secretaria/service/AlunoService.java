package com.example.Secretaria.service;

import com.example.Secretaria.dto.request.AlunoRequest;
import com.example.Secretaria.dto.response.AlunoResponse;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.repository.AlunoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorMatricula(String matricula) {
        return alunoRepository.findByMatricula(matricula);
    }

    public Aluno salvar(AlunoRequest alunoRequest) {
        if (alunoRequest == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo");
        }
        Aluno aluno = alunoRequest.toEntity();
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Integer id, AlunoRequest alunoAtualizado) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno com ID " + id + " não encontrado."));

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setUsuario(alunoAtualizado.getUsuario());
        aluno.setSenha(alunoAtualizado.getSenha());

        return alunoRepository.save(aluno);
    }

    public void deletar(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado com ID: " + id);
        }
        alunoRepository.deleteById(id);
    }
}
