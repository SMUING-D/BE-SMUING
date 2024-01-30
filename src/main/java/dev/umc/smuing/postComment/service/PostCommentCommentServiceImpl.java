package dev.umc.smuing.postComment.service;

import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.CommentException;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postComment.converter.PostCommentConverter;
import dev.umc.smuing.postComment.dto.PostCommentRequestDto;
import dev.umc.smuing.postComment.repository.PostCommentRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommentCommentServiceImpl implements PostCommentCommentService {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    @Override
    public void postCommentComment(PostCommentRequestDto.CommentPostDto commentPostDto, Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        PostComment parentComment = postCommentRepository.findById(commentId).orElseThrow(()-> new CommentException(ErrorStatus.COMMENT_NOT_FOUND));

        if (parentComment.getParent() != null) {
            throw new CommentException(ErrorStatus.COMMENTCOMMENT_ALREADY_HAS);
        }

        PostComment comment = PostCommentConverter.toPostCommentComment(commentPostDto, user, parentComment);
        postCommentRepository.save(comment);
    }
}
