package dev.umc.smuing.postComment.controller;

import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostCommentController {

    private final PostCommentService postCommentService;

    @PostMapping("/{userId}/{postId}/comments") // userId는 나중에 토큰으로 교체
    public BaseResponse<?> postComment(@RequestBody PostCommentRequestDto.CommentPostDto commentPostDto, @PathVariable Long userId, @PathVariable Long postId) {
        postCommentService.postComment(commentPostDto, userId, postId);
        return BaseResponse.onSuccess("댓글 작성에 성공하였습니다.");
    }

    @DeleteMapping("/comments/{commentId}")
    public BaseResponse<?> deleteComment(@PathVariable Long commentId) {
        postCommentService.deleteComment(commentId);
        return BaseResponse.onSuccess("댓글 삭제에 성공하였습니다.");
    }

    @PostMapping("/comments/{userId}/{commentId}/likes") // userId는 나중에 토큰으로 교체
    public BaseResponse<?> likeComment(@PathVariable Long userId, @PathVariable Long commentId) {
        postCommentService.likeComment(userId, commentId);
        return BaseResponse.onSuccess("댓글 좋아요에 성공하였습니다.");
    }
}
