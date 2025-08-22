package com.telacad.exempluSpringSecurity.repositories;

import com.telacad.exempluSpringSecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findUserByUsername(String username);
}
