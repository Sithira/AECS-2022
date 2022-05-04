package me.sithiramunasinghe.services.authservice.services;

import lombok.extern.slf4j.Slf4j;
import me.sithiramunasinghe.services.authservice.doa.User;
import me.sithiramunasinghe.services.authservice.doa.UserRepository;
import me.sithiramunasinghe.services.authservice.dto.LoginResponse;
import me.sithiramunasinghe.services.authservice.dto.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(String username, String password) {
        Optional<User> userOptional = this.userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return null;
        }

        if (this.passwordEncoder.matches(password, userOptional.get().getPassword())) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setAccessToken(Long.toString(userOptional.get().getId()));
            return loginResponse;
        }

        return null;
    }

    @Override
    public RegisterResponse register(String username, String password) {
        Optional<User> userOptional =  this.userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            throw new RuntimeException("Already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode(password));
        user = this.userRepository.save(user);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        return registerResponse;
    }
}
