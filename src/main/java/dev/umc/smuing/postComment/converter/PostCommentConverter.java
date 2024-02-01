package dev.umc.smuing.postComment.converter;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;

import dev.umc.smuing.user.User;
import dev.umc.smuing.user.converter.UserConverter;
import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@RequiredArgsConstructor
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

    public static PostCommentResponseDto.CommentList toCommentList(Page<PostComment> postComments, Long userId) {
        List<PostCommentResponseDto.CommentDto> commentDtos  = postComments.stream().map(PostCommentConverter::toCommentDto).toList();
        return PostCommentResponseDto.CommentList
                .builder()
                .commentList(commentDtos)
                .build();
    }

    private PostCommentResponseDto.CommentDto toCommentDto(PostComment postComment) {
        UserResponseDto.UserDto userDto = UserConverter.toUserDto(postComment.getUser());



        return PostCommentResponseDto.CommentDto
                .builder()
                .id(postComment.getId())
                .content(postComment.getContent())
                .isCommentLike()
                .commentLikeCount(postComment.getLike())
                .isBan()
                .isReport()
                .commentReplyList()
                .createAt(postComment.getCreatedAt())
                .updateAt(postComment.getUpdateAt())
                .userDto(userDto)
                .build();
    }
}
