package com.example.Secretaria.repository;

import com.example.Secretaria.model.Aluno;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findByCpfAndSenha(String cpf, String senha);
    Optional<Aluno> findByMatricula(String matricula);

}
