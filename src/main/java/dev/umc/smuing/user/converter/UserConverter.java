package dev.umc.smuing.user.converter;

import dev.umc.smuing.user.User;
import dev.umc.smuing.user.dto.UserResponseDto;

public class UserConverter {

    public static UserResponseDto.UserDto toUserDto(User user) {
        return UserResponseDto.UserDto
                .builder()
                .userId(user.getId())
                .userName(user.getNickname())
                .profile(user.getProfile())
                .build();
    }
}
