package dev.umc.smuing.postLike.repository;

import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Page<PostLike> findByIdGreaterThanAndUserOrderByIdAsc(Long id, User user, Pageable pageable);
}
