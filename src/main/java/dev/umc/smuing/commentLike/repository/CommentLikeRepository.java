package dev.umc.smuing.commentLike.repository;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    Optional<CommentLike> findCommentLikeByUserAndPostComment(User user, PostComment postComment);
}
