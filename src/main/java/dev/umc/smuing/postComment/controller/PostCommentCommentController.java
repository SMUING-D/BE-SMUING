package dev.umc.smuing.postComment.controller;


import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.service.PostCommentCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post/comments")
public class PostCommentCommentController {

    private final PostCommentCommentService postCommentCommentService;

    @PostMapping("{userId}/{commentId}/comments")
    public BaseResponse<?> postCommentComment(@RequestBody PostCommentRequestDto.CommentPostDto commentPostDto, @PathVariable Long userId, @PathVariable Long commentId) {
        postCommentCommentService.postCommentComment(commentPostDto, userId, commentId);
        return BaseResponse.onSuccess("대댓글 작성에 성공하였습니다.");
    }

    @DeleteMapping("/comments/{commentId}")
    public BaseResponse<?> deleteComment(@PathVariable Long commentId) {
        postCommentCommentService.deleteCommentComment(commentId);
        return BaseResponse.onSuccess("대댓글 삭제에 성공하였습니다.");
    }
}
