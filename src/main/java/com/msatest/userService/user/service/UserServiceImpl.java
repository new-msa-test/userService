package com.msatest.userService.user.service;

import com.msatest.userService.user.dto.UserDto;
import com.msatest.userService.user.model.Users;
import com.msatest.userService.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
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
