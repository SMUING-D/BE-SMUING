package dev.umc.smuing.communityImage;

import dev.umc.smuing.community.Community;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CommunityImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    @Column(name = "community_image_path")
    private String communityImagePath;
}
