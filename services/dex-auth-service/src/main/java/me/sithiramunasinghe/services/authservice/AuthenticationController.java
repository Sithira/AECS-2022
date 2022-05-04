package me.sithiramunasinghe.services.authservice;

import me.sithiramunasinghe.services.authservice.dto.LoginResponse;
import me.sithiramunasinghe.services.authservice.dto.RegisterResponse;
import me.sithiramunasinghe.services.authservice.dto.login.LoginRequest;
import me.sithiramunasinghe.services.authservice.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/authentication/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "login", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "register", produces = "application/json")
    public ResponseEntity<RegisterResponse> register(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.authenticationService.register(loginRequest.getUsername(), loginRequest.getPassword()));
    }
}
