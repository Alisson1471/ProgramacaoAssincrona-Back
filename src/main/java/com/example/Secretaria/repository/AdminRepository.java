package com.example.Secretaria.repository;

import com.example.Secretaria.model.Admin;
import com.example.Secretaria.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByCpf(String cpf);
    Optional<Admin> findById(Integer id);
}
