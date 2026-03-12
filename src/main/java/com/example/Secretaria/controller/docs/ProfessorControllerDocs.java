package com.example.Secretaria.controller.docs;

import com.example.Secretaria.dto.request.ProfessorRequest;
import com.example.Secretaria.dto.response.ProfessorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfessorControllerDocs {

    @Operation(summary = "Cria um novo professor")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Professor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<ProfessorResponse> create(ProfessorRequest request);


    @Operation(summary = "Lista todos os professores cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de professores retornada com sucesso")
    })
    ResponseEntity<List<ProfessorResponse>> getAll();

}