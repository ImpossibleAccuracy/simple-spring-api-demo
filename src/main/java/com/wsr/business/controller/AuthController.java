package com.wsr.business.controller;

import com.wsr.business.data.converter.UserConverter;
import com.wsr.business.data.models.User;
import com.wsr.business.data.payload.SignInForm;
import com.wsr.business.data.payload.SignUpForm;
import com.wsr.business.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final UserConverter converter;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInForm signInForm) {
        if (signInForm.login().isBlank() || signInForm.password().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Optional<User> user = repository.findByLoginIgnoreCase(signInForm.login());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (!passwordEncoder.matches(signInForm.password(), user.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                converter.convert(user.get()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpForm signUpForm) {
        if (signUpForm.login().isBlank() ||
                signUpForm.login().isBlank() ||
                signUpForm.password().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        boolean userExists = repository.existsByEmailIgnoreCaseOrLoginIgnoreCase(
                signUpForm.email(), signUpForm.login());

        if (userExists) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = User.builder()
                .email(signUpForm.email())
                .login(signUpForm.login())
                .password(passwordEncoder.encode(signUpForm.password()))
                .creationTime(Instant.now())
                .build();

        user = repository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(
                converter.convert(user));
    }
}
