package dev.umc.smuing.postImage.repository;

import dev.umc.smuing.postImage.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
