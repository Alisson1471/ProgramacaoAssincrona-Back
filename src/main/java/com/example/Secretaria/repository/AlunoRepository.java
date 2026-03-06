package com.example.Secretaria.repository;

import com.example.Secretaria.model.Aluno;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findByCpf(String cpf);
    Optional<Aluno> findByMatricula(String matricula);
    List<Aluno> findByAtivo(Character ativo);
}
