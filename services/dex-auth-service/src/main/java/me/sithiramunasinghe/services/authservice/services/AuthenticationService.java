package me.sithiramunasinghe.services.authservice.services;

import me.sithiramunasinghe.services.authservice.dto.LoginResponse;
import me.sithiramunasinghe.services.authservice.dto.RegisterResponse;

public interface AuthenticationService {
    LoginResponse login(String username, String password);

    RegisterResponse register(String username, String password);
}
