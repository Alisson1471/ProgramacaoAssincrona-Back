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
public class AlunoRequest {

    private String nome;
    private String usuario;
    private String senha;
    private String cpf;
    private String matricula;

    public Aluno toEntity() {
        return Aluno.builder()
                .nome(this.getNome())
                .usuario(this.getUsuario())
                .senha(this.getSenha())
                .cpf(this.getCpf())
                .matricula(this.getMatricula())
                .build();
    }
}
