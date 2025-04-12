package com.example.gtasks.controller.auth;

import com.example.gtasks.dto.auth.LoginRequestDTO;
import com.example.gtasks.dto.auth.LoginResponseDTO;
import com.example.gtasks.security.JwtUtil;
import com.example.gtasks.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        UserDetails userDetails = userService.loadUserByUsername(dto.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new LoginResponseDTO(token);
    }
}
