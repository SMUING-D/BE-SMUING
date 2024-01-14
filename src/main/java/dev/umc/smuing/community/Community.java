package dev.umc.smuing.community;

import dev.umc.smuing.communityComment.CommunityComment;
import dev.umc.smuing.communityImage.CommunityImage;
import dev.umc.smuing.global.Enum.CompanyScale;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Community extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_scale")
    private CompanyScale companyScale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "community")
    private List<CommunityComment> communityComments = new ArrayList<>();

    @OneToMany(mappedBy = "community")
    private List<CommunityImage> communityImages = new ArrayList<>();

}
