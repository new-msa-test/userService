package com.msatest.userService.users.dto;

import com.msatest.userService.users.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;

    public Users toEntity(UserDto userDto) {
        return Users.builder()
                .name(userDto.getName())
                .build();
    }

    public static UserDto toDto(Users user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
