package dev.umc.smuing.postComment.service;

import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.CommentException;
import dev.umc.smuing.global.apiPayload.exception.PostException;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.repository.PostRepository;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.converter.PostCommentConverter;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.repository.PostCommentRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void postComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long postId) {
        PostComment postComment = PostCommentConverter.toPostComment(commentPostDto);
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        Post post = postRepository.findById(postId).orElseThrow(()-> new PostException(ErrorStatus.POST_NOT_FOUND));
        postComment.setUser(user);
        postComment.setPost(post);
        postCommentRepository.save(postComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        PostComment postComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));
        postCommentRepository.delete(postComment);
    }
}
