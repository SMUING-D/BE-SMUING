package dev.umc.smuing.post.dto;

import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.postImage.PostImage;
import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.Builder;
import lombok.Getter;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostTypeDto {
    @Getter
    @Builder
    public static class JobDto {
        private Long id;
        private String title;
        private String content;
        private String startDate;
        private int memberCount;
        private String dueDate;
        private CollegeType college;
        private int viewCount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private boolean isPostLike;
        private int postLikeCount;
        private UserResponseDto.UserDto userDto;
        private List<Comment> commentList;
        private List<PostImage> postImageList;

    }

    @Getter
    @Builder
    public static class StudyDto {
        private Long id;
        private String title;
        private String content;
        private String startDate;
        private int memberCount;
        private String dueDate;
        private CollegeType college;
        private int viewCount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private boolean isPostLike;
        private int postLikeCount;
        private UserResponseDto.UserDto userDto;
        private List<Comment> commentList;
        private List<PostImage> postImageList;
    }
}
