package com.example.Secretaria.controller.docs;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;

public interface AuthControllerDocs {

    @Operation(summary = "Realiza login no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    ResponseEntity<UserResponse> login(AuthRequest authRequest);


    @Operation(summary = "Atualiza a senha do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Senha atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    ResponseEntity<Void> updateSenha(UpdateRequest request);

}
