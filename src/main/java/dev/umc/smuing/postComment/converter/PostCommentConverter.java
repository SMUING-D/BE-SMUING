package dev.umc.smuing.postComment.converter;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;

public class PostCommentConverter {

    public static PostComment toPostComment(PostCommentRequestDto.CommentPostDto commentPostDto) {
        return PostComment.builder()
                .content(commentPostDto.getContent())
                .build();
    }
}
