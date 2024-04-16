package com.msatest.userService.user.service;

import com.msatest.userService.user.dto.UserDto;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();
}
