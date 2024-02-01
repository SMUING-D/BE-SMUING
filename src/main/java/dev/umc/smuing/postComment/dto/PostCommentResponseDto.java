package dev.umc.smuing.postComment.dto;

import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class PostCommentResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentList {
        private List<CommentDto> commentList;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentDto {
        private Long id;
        private String content;
        private Integer commentLikeCount;
        private Boolean isCommentLike;
        private Boolean isReport;
        private Boolean isBan;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
        private UserResponseDto.UserDto userDto;
        private List<commentReplyDto> commentReplyList;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class commentReplyDto {
        private Long id;
        private String content;
        private Integer commentReplyLikeCount;
        private Boolean isCommentReplyLike;
        private Boolean isReport;
        private Boolean isBan;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
        private UserResponseDto.UserDto userDto;
    }
}
