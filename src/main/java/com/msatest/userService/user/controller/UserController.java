package com.msatest.userService.user.controller;

import com.msatest.userService.user.dto.UserDto;
import com.msatest.userService.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service/users")
public class UserController {

    private final UserService userService;

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
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUserByName() {

        return ResponseEntity.ok(userService.getAllUsers());
    }
}
