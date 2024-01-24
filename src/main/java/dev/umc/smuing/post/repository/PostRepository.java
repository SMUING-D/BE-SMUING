package dev.umc.smuing.post.repository;

import dev.umc.smuing.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
