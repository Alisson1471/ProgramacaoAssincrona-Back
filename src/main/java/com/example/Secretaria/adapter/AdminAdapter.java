package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Admin;
import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.repository.AdminRepository;
import com.example.Secretaria.repository.AlunoRepository;
import com.example.Secretaria.utils.CryptServers;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAdapter {

    private final AdminRepository adminRepository;
    private final CryptServers cryptServers;

    public Admin login(String cpf, String senha) {

        var admin = adminRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado"));

        if (!cryptServers.matches(senha, admin.getSenha())) {
            throw new BadCredentialsException("Senha inválida");
        }

        return admin;
    }

    public Admin findById(Integer id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado"));
    }

}