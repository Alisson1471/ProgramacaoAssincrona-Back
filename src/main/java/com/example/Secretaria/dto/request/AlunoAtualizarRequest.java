package com.example.Secretaria.dto.request;

import com.example.Secretaria.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoAtualizarRequest {

    private String nome;
    private String senha;
    private String cpf;
    private Character ativo;

    public Aluno toEntity() {
        return Aluno.builder()
                .nome(this.getNome())
                .senha(this.getSenha())
                .cpf(this.getCpf())
                .ativo(this.getAtivo())
                .build();
    }
}

