package dev.umc.smuing.post.controller;

import dev.umc.smuing.global.apiPayload.BaseResponse;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.dto.PostRequestDto;
import dev.umc.smuing.post.dto.PostResponseDto;
import dev.umc.smuing.post.service.PostService;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;
import dev.umc.smuing.postComment.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
//    private final PostCommentService postCommentService;
    private final PostService postService;

    @PostMapping("") // userId는 나중에 토큰으로 교체
    public BaseResponse<?> savePost(@RequestBody PostRequestDto.PostSaveDto postSaveDto) {
        postService.postSave(postSaveDto);
        return BaseResponse.onSuccess("게시물 작성에 성공하였습니다.");
    }

    @PatchMapping("{postId}") // userId는 나중에 토큰으로 교체
    public BaseResponse<?> updatePost(@RequestBody PostRequestDto.PostUpdateDto postUpdateDto, @PathVariable("postId") Long postId) {
        postService.postUpdate(postUpdateDto, postId);
        return BaseResponse.onSuccess("게시물 수정에 성공하였습니다.");
    }
    @GetMapping("/{postId}") // userId는 나중에 토큰으로 교체
    public BaseResponse<?> getDetailPost(@PathVariable Long postId) {
        PostResponseDto.PostDetailDto post = postService.getPostById(postId);
        return BaseResponse.onSuccess(post);
    }
    @GetMapping("")
    public BaseResponse<?> getComments() {
        PostResponseDto.getAllMainPost allMainPost =  postService.getAllMainPost();
        return BaseResponse.onSuccess(allMainPost);
    }
    @DeleteMapping("{postId}")
    public BaseResponse<?> deletePost(@PathVariable Long postId) {
        postService.postDelete(postId);
        return BaseResponse.onSuccess("게시물 삭제에 성공하였습니다.");
    }

//    @PatchMapping("/comments/{commentId}")
//    public BaseResponse<?> updateComment(@RequestBody PostCommentRequestDto.CommentUpdateDto commentUpdateDto, @PathVariable Long commentId) {
//        postService.postUpdate(commentUpdateDto, commentId);
//        return BaseResponse.onSuccess("댓글 수정에 성공하였습니다.");
//    }

//    @PostMapping("/comments/{userId}/{commentId}/likes") // userId는 나중에 토큰으로 교체
//    public BaseResponse<?> likeComment(@PathVariable Long userId, @PathVariable Long commentId) {
//        postService.po(userId, commentId);
//        return BaseResponse.onSuccess("댓글 좋아요에 성공하였습니다.");
//    }
 }