package com.example.Secretaria.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class NotaDisciplinaResponse {
    private BigDecimal media;
    private String disciplina;
    private boolean status;
}
