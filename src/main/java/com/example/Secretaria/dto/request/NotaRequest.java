package com.example.Secretaria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaRequest {

    private String titulo;

    private BigDecimal nota;

    @JsonProperty("aluno_id")
    private int alunoId;

}
