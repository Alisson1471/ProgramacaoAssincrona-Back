package com.example.Secretaria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {

    private String cpf;
    private String password;
    private String newPassword;
    @JsonProperty("user_type")
    private String userType;

}
