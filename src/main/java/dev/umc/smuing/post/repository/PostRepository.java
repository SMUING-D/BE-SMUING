package dev.umc.smuing.post.repository;

import dev.umc.smuing.post.Post;
import dev.umc.smuing.global.Enum.CollegeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop5ByCollegeOrderByCreatedAtDesc(CollegeType college);
}
