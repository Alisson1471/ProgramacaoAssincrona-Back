package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Admin;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.repository.AdminRepository;
import com.example.Secretaria.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAdapter {

    private final AdminRepository adminRepository;

    public Admin login(String cpf, String senha) {
        return adminRepository.findByCpfAndSenha(cpf, senha)
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado"));
    }

    public Admin findById(Integer id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado"));
    }

}