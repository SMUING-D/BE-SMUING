package dev.umc.smuing.community;

import dev.umc.smuing.communityReply.CommunityReply;
import dev.umc.smuing.communityReplyReply.CommunityReplyReply;
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
    private CompanyType companyType;

    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "community")
    private List<CommunityReply> communityReplies = new ArrayList<>();

    @OneToMany(mappedBy = "community")
    private List<CommunityReplyReply> communityReplyReplies = new ArrayList<>();
}
