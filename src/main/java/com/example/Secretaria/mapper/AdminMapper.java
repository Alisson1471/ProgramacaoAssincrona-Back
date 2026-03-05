package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.response.AdminResponse;
import com.example.Secretaria.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminResponse convertToResponse(Admin admin) {
        var adminResponse = new AdminResponse();
        adminResponse.setId(admin.getId());
        adminResponse.setNome(admin.getNome());
        adminResponse.setCpf(admin.getCpf());
        adminResponse.setSenha(admin.getSenha());

        return adminResponse;
    }
}
