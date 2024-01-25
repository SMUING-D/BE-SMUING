package dev.umc.smuing.postComment.converter;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.user.User;

public class PostCommentConverter {

    public static PostComment toPostComment(PostCommentRequestDto.CommentPostDto commentPostDto, User user, Post post) {
        return PostComment.builder()
                .content(commentPostDto.getContent())
                .user(user)
                .post(post)
                .build();
    }

    public static PostComment toPostCommentComment(PostCommentRequestDto.CommentPostDto commentPostDto, User user, PostComment parent) {
        return PostComment.builder()
                .content(commentPostDto.getContent())
                .user(user)
                .post(parent.getPost())
                .parent(parent)
                .build();
    }
}
