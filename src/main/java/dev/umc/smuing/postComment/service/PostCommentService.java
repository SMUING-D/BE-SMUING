package dev.umc.smuing.postComment.service;

import dev.umc.smuing.postComment.dto.PostCommentRequestDto;

public interface PostCommentService {
    void postComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long postId);

    void deleteComment(Long commentId);

    void likeComment(Long userId, Long commentId);
}
