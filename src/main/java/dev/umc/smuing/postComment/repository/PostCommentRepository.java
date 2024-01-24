package dev.umc.smuing.postComment.repository;

import dev.umc.smuing.postComment.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
