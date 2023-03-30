package com.wsr.business.data.repo;

import com.wsr.business.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailIgnoreCaseOrLoginIgnoreCase(String email, String login);
    Optional<User> findByLoginIgnoreCase(String login);
}