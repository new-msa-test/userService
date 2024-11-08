package com.msatest.userService.users.controller;

import com.msatest.userService.users.dto.UserDto;
import com.msatest.userService.users.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Environment env;

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        return "User Service is up and running : " + request.getServerPort();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {

        userService.createUser(userDto);

        return ResponseEntity.ok("회원가입 성공!");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/health_check")
    public String healthCheck() {
        return "User Service is up and running - env : " + env.getProperty("token.expriation_time") + env.getProperty("dbpassword");
    }
}
