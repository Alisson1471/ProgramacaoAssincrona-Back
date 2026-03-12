package com.example.Secretaria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObservacaoResponse {

    private Integer id;
    private String aluno;
    private String professor;
    private String text;
    private OffsetDateTime data;

}
