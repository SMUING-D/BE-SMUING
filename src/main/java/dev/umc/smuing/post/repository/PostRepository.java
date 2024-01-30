package dev.umc.smuing.post.repository;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
