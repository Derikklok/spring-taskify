package com.taski.Task.Service;

import com.taski.Task.Exception.EmailAlreadyExistsException;
import com.taski.Task.Exception.InvalidCredentialsException;
import com.taski.Task.Model.User;
import com.taski.Task.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User register(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        return userRepository.save(user);
    }

    public Map<String, Object> login(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Email and password are required");
        }
        User user = userRepository.findByEmail(email)
                .orElseThrow(InvalidCredentialsException::new);
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException();
        }
        return Map.of(
                "message", "Login successful",
                "userId", user.getId(),
                "email", user.getEmail()
        );
    }
}
