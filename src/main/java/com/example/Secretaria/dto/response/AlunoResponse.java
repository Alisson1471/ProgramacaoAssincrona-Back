package com.example.Secretaria.dto.response;

public class AlunoResponse extends UserResponse {

    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
