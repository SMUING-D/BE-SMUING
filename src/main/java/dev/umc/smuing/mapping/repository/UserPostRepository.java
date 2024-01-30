package dev.umc.smuing.mapping.repository;

import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {
    Page<UserPost> findByIdGreaterThanAndUserOrderByIdAsc(Long id, User user, Pageable pageable);
}
