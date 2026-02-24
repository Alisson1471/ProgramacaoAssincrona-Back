package com.example.Secretaria.dto.response;

import java.math.BigDecimal;

public interface NotaDisciplinaAlunoResponse {
    BigDecimal getMedia();
    String getDisciplinaNome();
    boolean getStatus();
}
