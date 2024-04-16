package com.msatest.userService.users.service;

import com.msatest.userService.users.dto.UserDto;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();
}
