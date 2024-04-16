package com.msatest.userService.users.service;

import com.msatest.userService.users.dto.UserDto;
import com.msatest.userService.users.model.Users;
import com.msatest.userService.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {
        userRepository.save(userDto.toEntity(userDto));
    }

    @Override
    public UserDto getUserById(Long userId) {
        Users user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found"));
        return UserDto.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = userRepository.findAll();

        return users.stream().map(UserDto::toDto).toList();
    }
}
