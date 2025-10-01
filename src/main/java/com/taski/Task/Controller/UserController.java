package com.taski.Task.Controller;

import com.taski.Task.Model.AuthRequest;
import com.taski.Task.Model.User;
import com.taski.Task.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody AuthRequest request) {
        return userService.login(request.getEmail(), request.getPassword());
    }
}
