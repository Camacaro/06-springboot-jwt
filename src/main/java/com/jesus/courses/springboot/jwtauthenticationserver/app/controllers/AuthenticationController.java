package com.jesus.courses.springboot.jwtauthenticationserver.app.controllers;

import com.jesus.courses.springboot.jwtauthenticationserver.app.dto.JwtAuthenticationResponse;
import com.jesus.courses.springboot.jwtauthenticationserver.app.filters.SignInRequest;
import com.jesus.courses.springboot.jwtauthenticationserver.app.filters.SignUpRequest;
import com.jesus.courses.springboot.jwtauthenticationserver.app.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }
}
