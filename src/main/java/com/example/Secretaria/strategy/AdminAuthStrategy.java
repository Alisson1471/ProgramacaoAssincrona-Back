package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AdminAdapter;
import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AdminMapper;
import com.example.Secretaria.model.Admin;
import com.example.Secretaria.utils.CryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminAuthStrategy implements AuthStrategy {

    private final AdminAdapter adminAdapter;

    private final AdminMapper adminMapper;

    private final CryptService cryptService;

    @Override
    public UserResponse login(AuthRequest loginRequest) {
        var admin = adminAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return adminMapper.convertToResponse(admin);
    }

    @Override
    public void updateSenha(UpdateRequest request) {
        var admin = adminAdapter.login(request.getCpf(), request.getPassword());
        admin.setSenha(cryptService.crypt(request.getNewPassword()));
        adminAdapter.salvar(admin);
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Admin");
    }

}
