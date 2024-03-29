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
    public static class Comments {
        private List<CommentDto> commentList;
        private Long nextCursor;
        private Boolean isLast;
        private Long remainComments;
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
        private List<CommentReplyDto> commentReplyList;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentReplyDto {
        private Long id;
        private String content;
        private Integer commentLikeCount;
        private Boolean isCommentLike;
        private Boolean isReport;
        private Boolean isBan;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
        private UserResponseDto.UserDto userDto;
    }
}
