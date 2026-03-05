package com.example.Secretaria.dto.request;

import com.example.Secretaria.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminRequest {

    private String nome;
    private String cpf;
    private String senha;

    public Admin toEntity() {
        return Admin.builder()
                .nome(this.getNome())
                .senha(this.getSenha())
                .cpf(this.getCpf())
                .build();
    }
}
