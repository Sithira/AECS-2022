package me.sithiramunasinghe.services.authservice.dto.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
