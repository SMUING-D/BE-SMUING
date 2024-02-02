package dev.umc.smuing.postComment.service;

import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;
import dev.umc.smuing.user.User;

public interface PostCommentService {
    void postComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long postId);

    void deleteComment(Long commentId);

    void likeComment(Long userId, Long commentId);

    void updateComment(PostCommentRequestDto.CommentUpdateDto commentUpdateDto, Long commentId);

    PostCommentResponseDto.CommentList getComments(Long cursor, Long postId, Long userId);

    void reportComment(Long userId, Long commentId);
}
