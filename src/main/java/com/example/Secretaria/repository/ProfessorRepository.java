package com.example.Secretaria.repository;

import com.example.Secretaria.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByUsuarioAndSenha(String usuario, String senha);

}
