package dev.umc.smuing.postLike.repository;

import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Page<PostLike> findByIdGreaterThanAndUserOrderByIdAsc(Long id, User user, Pageable pageable);

    // 특정 포스트에 대한 좋아요 개수를 조회하는 메서드
    @Query("SELECT COUNT(pl) FROM PostLike pl WHERE pl.post.id = :postId")
    Integer countLikesByPostId(Long postId);

    // 특정 사용자가 특정 포스트에 좋아요를 눌렀는지 확인하는 메서드
    @Query("SELECT pl FROM PostLike pl WHERE pl.user.id = :userId AND pl.post.id = :postId")
    Optional<PostLike> findByUserIdAndPostId(Long userId, Long postId);


}
