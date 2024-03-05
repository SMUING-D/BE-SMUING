package dev.umc.smuing.postComment.controller;


import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.global.token.ExtractUserId;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.service.PostCommentCommentService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/comments")
public class PostCommentCommentController {

    private final PostCommentCommentService postCommentCommentService;

    @PostMapping("/{commentId}/comments") // userId는 나중에 토큰으로 교체
    @Parameter(name = "userId", hidden = true)
    public BaseResponse<?> postCommentComment(@RequestBody PostCommentRequestDto.CommentPostDto commentPostDto, @ExtractUserId Long userId, @PathVariable Long commentId) {
        postCommentCommentService.postCommentComment(commentPostDto, userId, commentId);
        return BaseResponse.onSuccess("대댓글 작성에 성공하였습니다.");
    }
}
