package dev.umc.smuing.postComment.service;

import dev.umc.smuing.postComment.dto.PostCommentRequestDto;

public interface PostCommentCommentService {
    void postCommentComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long commentId);
}
