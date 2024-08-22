package org.programing.daily5minuties.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.programing.daily5minuties.auth.request.UserRequest;
import org.programing.daily5minuties.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping
    public void registerUser(@RequestBody UserRequest userRequest) {
        log.info("new customer registration {}", userRequest);
        authService.registerUser(userRequest);
    }
}
