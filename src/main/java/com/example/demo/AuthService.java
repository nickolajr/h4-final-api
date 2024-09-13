package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String mail, String password) {
        Optional<User> user = userRepository.findByMail(mail);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
