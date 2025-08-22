package com.telacad.exempluSpringSecurity.services;

import com.telacad.exempluSpringSecurity.entities.User;
import com.telacad.exempluSpringSecurity.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new RuntimeException("Username not found"));
    }
}
