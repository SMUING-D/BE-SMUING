package dev.umc.smuing.commentLike.service;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentLike.repository.CommentLikeRepository;
import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.CommentException;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.repository.PostCommentRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentLikeServiceImpl implements CommentLikeService{

    private final UserRepository userRepository;
    private final PostCommentRepository postCommentRepository;
    private final CommentLikeRepository commentLikeRepository;

    @Override
    @Transactional
    public void deleteCommentLike(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        PostComment postComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));
        CommentLike commentLike = commentLikeRepository.findCommentLikeByUserAndPostComment(user, postComment).orElseThrow(()->{
            throw new CommentException(ErrorStatus.COMMENT_LIKE_NOT_FOUND);
        });
        commentLikeRepository.delete(commentLike);
    }
}
