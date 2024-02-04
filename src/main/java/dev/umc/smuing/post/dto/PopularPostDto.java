package dev.umc.smuing.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
public class PopularPostDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("memberCount")
    private int memberCount;

    @JsonProperty("dueDate")
    private String dueDate;

    @JsonProperty("college")
    private String college;

    @JsonProperty("viewCount")
    private int viewCount;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("isPostLike")
    private boolean isPostLike;

    @JsonProperty("postLikeCount")
    private int postLikeCount;

    @JsonProperty("userDto")
    private UserResponseDto.UserDto userDto;

    @JsonProperty("postImage")
    private PostImageDto postImage;

}
