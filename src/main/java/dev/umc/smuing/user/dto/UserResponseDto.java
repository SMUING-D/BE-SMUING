package dev.umc.smuing.user.dto;

import lombok.Builder;
import lombok.Getter;

public class UserResponseDto {

    @Builder
    @Getter
    public static class UserDto {
        private Long userId;
        private String userName;
        private String profile;
    }
}
