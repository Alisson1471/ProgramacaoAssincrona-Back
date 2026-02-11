package com.example.Secretaria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Schema
@AllArgsConstructor
@NoArgsConstructor
public class ObservacaoRequest {

    @JsonProperty("aluno_id")
    private Integer alunoId;

    @JsonProperty("professor_id")
    private Integer professorId;

    private String text;

}
