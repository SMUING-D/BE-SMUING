package dev.umc.smuing.postComment.service;

import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;

public interface PostCommentService {
    void postComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long postId);

    void deleteComment(Long commentId);

    void likeComment(Long userId, Long commentId);

    void updateComment(PostCommentRequestDto.CommentUpdateDto commentUpdateDto, Long commentId);

    void reportComment(Long userId, Long commentId);

    PostCommentResponseDto.Comments getComments(Long cursor, Integer take,Long postId, Long userId);
}
