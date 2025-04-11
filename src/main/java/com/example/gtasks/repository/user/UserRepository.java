package com.example.gtasks.repository.user;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gtasks.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
