package dev.umc.smuing.postImage;

import dev.umc.smuing.post.Post;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post_image")
public class PostImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "origin_name")
    private String originName;

    @Column(name = "post_image_path")
    private String postImagePath;

    @Column(name = "db_name")
    private String dbName;

    @Column(name = "image_type")
    private String imageType;
}
