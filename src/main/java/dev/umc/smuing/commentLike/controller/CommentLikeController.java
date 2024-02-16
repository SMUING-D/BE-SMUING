package dev.umc.smuing.commentLike.controller;

import dev.umc.smuing.commentLike.service.CommentLikeService;
import dev.umc.smuing.global.apiPayload.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/comments")
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @DeleteMapping("{userId}/{commentId}/likes")
    public BaseResponse<?> deleteCommentLike(@PathVariable Long userId, @PathVariable Long commentId) {
        commentLikeService.deleteCommentLike(userId, commentId);
        return BaseResponse.onSuccess("댓글 좋아요 취소가 완료되었습니다");
    }
}
