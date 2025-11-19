package com.example.Hospital.service;

import com.example.Hospital.dto.LoginRequestDto;
import com.example.Hospital.dto.LoginResponseDto;
import com.example.Hospital.dto.SignupRequestDto;
import com.example.Hospital.dto.SignupResponseDto;
import com.example.Hospital.entity.UserEntity;
import com.example.Hospital.repository.UserRepository;
import com.example.Hospital.security.AuthUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthService(AuthenticationManager authenticationManager, AuthUtil authUtil, UserRepository userRepository,
                       PasswordEncoder passwordEncoder)
    {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto)
    {
        //for authentication we were delegating this to AuthenticationManager
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
            );

            UserEntity user = (UserEntity) authentication.getPrincipal();
            String token = authUtil.generateAccessToken(user);

            return new LoginResponseDto(token, user.getUserId());
        } catch (Exception e) {
            System.out.println(">>> AUTH ERROR: " + e.getClass().getName());
            e.printStackTrace();
            throw e;
        }
    }


    public SignupResponseDto signup(SignupRequestDto signupRequestDto)
    {
        UserEntity user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);
        if(user != null)throw new IllegalArgumentException("User Already Exists");

        user = userRepository.save(new UserEntity(signupRequestDto.getUsername(),passwordEncoder.encode(signupRequestDto.getPassword())));
        return new SignupResponseDto(user.getUserId(), user.getUsername());
    }
}
