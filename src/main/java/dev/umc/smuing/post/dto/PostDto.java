package dev.umc.smuing.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("college")
    private String college;

    @JsonProperty("memberCount")
    private Integer memberCount;

    @JsonProperty("viewCount")
    private int viewCount;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("isPostLike")
    private boolean isPostLike;

    @JsonProperty("userDto")
    private UserResponseDto.UserDto userDto;

    private LocalDateTime dueDate;

    private Integer postLikeCount;
    // Constructors, Getters, and Setters
}
