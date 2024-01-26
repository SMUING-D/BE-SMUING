package dev.umc.smuing.postComment.dto;

import lombok.Getter;

public class PostCommentRequestDto {

    @Getter
    public static class CommentPostDto {
        private String content;
    }

    @Getter
    public static class CommentUpdateDto {
        private String content;
    }
}
