package com.example.Secretaria.repository;

import com.example.Secretaria.model.Admin;
import com.example.Secretaria.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Professor> criarProfessor(Professor professor);
    Void aprovarAluno(Professor professor);
    Optional<Admin> findByCpfAndSenha(String cpf, String senha);
    Optional<Admin> findById(Integer id);
}
