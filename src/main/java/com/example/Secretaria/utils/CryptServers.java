package com.example.Secretaria.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CryptServers {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String crypt(String senha) {
        return passwordEncoder().encode(senha);
    }

    public Boolean matches(String senhaDigitada, String senhaCriptografada){
        return passwordEncoder().matches(senhaDigitada, senhaCriptografada);
    }

}