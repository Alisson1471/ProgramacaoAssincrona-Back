package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public UserResponse convertToResponse(Admin admin) {
        var adminResponse = new UserResponse();
        adminResponse.setId(admin.getId());
        adminResponse.setNome(admin.getNome());
        adminResponse.setCpf(admin.getCpf());
        adminResponse.setSenha(admin.getSenha());

        return adminResponse;
    }
}
