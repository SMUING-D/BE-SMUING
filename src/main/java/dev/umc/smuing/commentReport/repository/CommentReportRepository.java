package dev.umc.smuing.commentReport.repository;


import dev.umc.smuing.commentReport.CommentReport;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {
    Optional<CommentReport> findCommentReportByUserAndPostComment(User user, PostComment postComment);
}
