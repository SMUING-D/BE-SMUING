package dev.umc.smuing.postComment.service;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentLike.converter.CommentLikeConverter;
import dev.umc.smuing.commentLike.repository.CommentLikeRepository;
import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.CommentException;
import dev.umc.smuing.global.apiPayload.exception.PostException;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.repository.PostRepository;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.converter.PostCommentConverter;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;
import dev.umc.smuing.postComment.repository.PostCommentRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentLikeRepository commentLikeRepository;
    private static int cursorSize = 20;

    @Override
    public void postComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostException(ErrorStatus.POST_NOT_FOUND));
        PostComment postComment = PostCommentConverter.toPostComment(commentPostDto, user, post);
        postCommentRepository.save(postComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        PostComment postComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));

        if (postComment.getContent() == null) {
            throw new CommentException(ErrorStatus.COMMENT_ALREADY_DELETE);
        }

        postComment.deleteComment();
    }

    @Override
    public void likeComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        PostComment postComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));

        Optional<CommentLike> existsCommentLike = commentLikeRepository.findCommentLikeByUserAndPostComment(user, postComment);
        if (existsCommentLike.isPresent()) {
          throw new CommentException(ErrorStatus.COMMENT_LIKE_EXIST);
        }

        CommentLike commentLike = CommentLikeConverter.toCommentLike(user, postComment);
        commentLikeRepository.save(commentLike);
    }

    @Override
    public void updateComment(PostCommentRequestDto.CommentUpdateDto commentUpdateDto, Long commentId) {
        PostComment postComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));

        if (postComment.getContent() == null) {
            throw new CommentException(ErrorStatus.COMMENT_ALREADY_DELETE);
        }

        postComment.updateComment(commentUpdateDto.getContent());
    }

    @Override
    public PostCommentResponseDto.Comments getComments(Long cursor, Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostException(ErrorStatus.POST_NOT_FOUND));
        Page<PostComment> postComments = postCommentRepository.findByIdGreaterThanAndPostAndParentIsNullOrderByIdAsc(cursor, post, PageRequest.of(0, cursorSize));
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        PostCommentResponseDto.Comments comments = PostCommentConverter.toCommentList(postComments, user);
        return comments;
    }
}
