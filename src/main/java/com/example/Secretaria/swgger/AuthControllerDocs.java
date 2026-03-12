package com.example.Secretaria.swgger;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação", description = "Endpoints responsáveis pela autenticação de usuários")
public interface AuthControllerDocs {

    @Operation(
            summary = "Login do usuário",
            description = "Realiza a autenticação do usuário com base no tipo de usuário informado."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados de autenticação inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Credenciais inválidas",
                    content = @Content
            )
    })
    ResponseEntity<UserResponse> login(@RequestBody AuthRequest authRequest);


    @Operation(
            summary = "Atualizar senha",
            description = "Permite que o usuário atualize sua senha informando o tipo de usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Senha atualizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<Void> updateSenha(@RequestBody UpdateRequest request);
}