package com.wsr.business.controller;

import com.wsr.business.data.models.User;
import com.wsr.business.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    public List<User> list() {
        return repository.findAll();
    }

    public User details(long id) {
        return repository.findById(id);
    }
}
