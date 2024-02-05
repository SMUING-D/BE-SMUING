package dev.umc.smuing.postComment.converter;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;

import dev.umc.smuing.postComment.service.PostCommentService;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.converter.UserConverter;
import dev.umc.smuing.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;


@RequiredArgsConstructor
public class PostCommentConverter {

    private static int banCount = 10;
    private final PostCommentService postCommentService;

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

    public static PostCommentResponseDto.Comments toCommentList(Page<PostComment> postComments, User user) {
        List<PostCommentResponseDto.CommentDto> commentDtos = null;
        Long nextCursor = null;

        if (!postComments.getContent().isEmpty()) {
            commentDtos = postComments.stream().map((PostComment postComment) -> toCommentDto(postComment, user)).toList();
            nextCursor = postComments.getContent().get(postComments.getContent().size() - 1).getId();
        }


        return PostCommentResponseDto.Comments
                .builder()
                .commentList(commentDtos)
                .nextCursor(nextCursor)
                .isLast(postComments.isLast())
                .remainComments(postComments.getTotalElements() - postComments.getContent().size())
                .build();
    }

    private static PostCommentResponseDto.CommentDto toCommentDto(PostComment postComment, User user) {
        UserResponseDto.UserDto userDto = UserConverter.toUserDto(postComment.getUser());

        List<PostCommentResponseDto.CommentReplyDto> children = postComment.getChildren().stream().map((PostComment postComment1) -> toCommentReplyDto(postComment1, user)).toList();



        return PostCommentResponseDto.CommentDto
                .builder()
                .id(postComment.getId())
                .content(postComment.getContent())
                .isCommentLike(postComment.isMyLike(user))
                .commentLikeCount(postComment.getLikeSum())
                .isBan(postComment.getReportSum() >= banCount)
                .isReport(postComment.isMyReport(user))
                .commentReplyList(children)
                .createAt(postComment.getCreatedAt())
                .updateAt(postComment.getUpdateAt())
                .userDto(userDto)
                .build();
    }

    private static PostCommentResponseDto.CommentReplyDto toCommentReplyDto(PostComment postComment, User user) {
        UserResponseDto.UserDto userDto = UserConverter.toUserDto(postComment.getUser());

        return PostCommentResponseDto.CommentReplyDto
                .builder()
                .id(postComment.getId())
                .content(postComment.getContent())
                .isCommentLike(postComment.isMyLike(user))
                .commentLikeCount(postComment.getLikeSum())
                .isBan(postComment.getReportSum() >= banCount)
                .isReport(postComment.isMyReport(user))
                .createAt(postComment.getCreatedAt())
                .updateAt(postComment.getUpdateAt())
                .userDto(userDto)
                .build();
    }

}
